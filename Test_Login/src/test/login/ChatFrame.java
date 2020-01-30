package test.login;


import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.json.JSONArray;
import org.json.JSONObject;



import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JList;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Vector;
import java.awt.Color;
import javax.swing.JTextArea;

public class ChatFrame extends JFrame implements ActionListener, KeyListener{

	private JPanel contentPane;
	private JTextField ip;
	private JTextField port;
	private JTextField inputText;
	private JTextArea ta;
	private Socket socket;
	private BufferedWriter bw;
	private BufferedReader br;
	private JList<String> list;
	private String chatName;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChatFrame frame = new ChatFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ChatFrame() {
		super("채팅방");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 621, 504);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 605, 33);
		contentPane.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblIp = new JLabel("IP주소");
		panel.add(lblIp);
		
		ip = new JTextField("127.0.0.1");
		panel.add(ip);
		ip.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("포트번호");
		panel.add(lblNewLabel);
		
		port = new JTextField("5000");
		panel.add(port);
		port.setColumns(10);
		
		JButton connectBtn = new JButton("접속");
		panel.add(connectBtn);
		
		//list
		String[] names= {"참여자 목록"};
		list = new JList<>(names);
		list.setBackground(new Color(255, 255, 225));
		list.setBounds(478, 32, 127, 402);
		contentPane.add(list);
		//참여자 이름 받아오기.
		chatName=Login.chatName;
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 434, 605, 31);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		inputText = new JTextField();
		inputText.setBounds(0, 0, 478, 31);
		panel_1.add(inputText);
		inputText.setColumns(10);
		
		JButton sendBtn = new JButton("입력");
		sendBtn.setBounds(477, 0, 128, 31);
		panel_1.add(sendBtn);
		
		ta = new JTextArea();
		ta.setBackground(SystemColor.inactiveCaptionBorder);
		ta.setBounds(0, 32, 478, 402);
		contentPane.add(ta);
		
		connectBtn.addActionListener(this);
		sendBtn.addActionListener(this);
		connectBtn.setActionCommand("conn");
		sendBtn.setActionCommand("send");
		inputText.addKeyListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command=e.getActionCommand();
		if(command.equals("conn")) {
			connect();
		}else if(command.equals("send")) {
			String msg=inputText.getText();
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("type", "message");
			jsonObj.put("msg", msg);
			jsonObj.put("chatName", this.chatName);
			String json=jsonObj.toString();
			this.send(json);	// this.send() 메세지 전송하는 메소드 호출
			inputText.setText("");
			inputText.requestFocus();
		}
	}

	public void connect() {
		try {
			//Socket 객체의 참조값을 필드에 저장하기
			socket=new Socket(ip.getText(),Integer.parseInt(port.getText()));	 //this.socket	
			System.out.println("Socket 연결 성공");
			// 서버에 출력
			OutputStream os=socket.getOutputStream();	//문자열을 출력하기 힘들다
			OutputStreamWriter osw=new OutputStreamWriter(os);
			bw=new BufferedWriter(osw);
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("type", "enter");
			jsonObj.put("chatName", this.chatName);
			String json=jsonObj.toString();
			send(json);
			
			// 서버로부터 입력
			InputStream is=socket.getInputStream();
			InputStreamReader isr=new InputStreamReader(is);
			br=new BufferedReader(isr);		 
			ClientThread t=new ClientThread();//새로운 스레드로 메인스레드에 영향 X
			t.start();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void send(String json) {
		//인자로 전달되는 json 문자열을 서버에 출력하기
		try {
			bw.write(json);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	class ClientThread extends Thread{
		@Override 
		public void run() {
			while(true) {
				try {
					//서버로 부터 문자열이 도착하면 readLine() 메소드가 호출된다.
					String json=br.readLine();
					//도착한 json 문자열을 이용해서 JSONObject 를 만든다.
					JSONObject jsonObj=new JSONObject(json);
					//어떤 type 의 문자열인지 얻어낸다.
					String type=jsonObj.getString("type");
					if(type.equals("enter")) {	//누군가 입장했을때
						String chatName=jsonObj.getString("chatName");
						String msg=chatName+" 님이 입장했습니다.";
						ta.append(msg);
						ta.append("\r\n");
					}else if(type.equals("message")) {	//대화 메세지
						String chatName=jsonObj.getString("chatName");
						String message=jsonObj.getString("msg");
						String msg=chatName+" : "+message;
						ta.append(msg);
						ta.append("\r\n");
					}else if(type.equals("update")) {
						
						JSONArray arr=jsonObj.getJSONArray("names");
//						String[] names=new String[arr.length()];
						Vector<String> names=new Vector<>();	//vector로 만들면 더 편할 수 있다.arraylist와 사용법이 같다. 다만 무겁다.
						names.add("참여자 목록");
						for(int i=0;i<arr.length();i++) {
							String name=arr.getString(i);
//							names[i]=name;
							names.add(name);
						}
						list.setListData(names);
					}else if(type.equals("leave")) {
						String chatName=jsonObj.getString("chatName");
						String msg=chatName+" 님이 나갔습니다.";
						ta.append(msg);
						ta.append("\r\n");
					}
					
					//가장 아래쪽으로 스크롤 시키기
					int height=ta.getDocument().getLength();
					ta.setCaretPosition(height);
					
				} catch (IOException e) {
					e.printStackTrace();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}//while
		}//run()
	}
	@Override
	public void keyPressed(KeyEvent e) {
		//키를 눌렀을때 호출되는 메소드
		int code=e.getKeyCode();	//눌러진 키의 코드값 읽어오기
		if(code==KeyEvent.VK_ENTER) {
			String msg=inputText.getText();
			JSONObject jsonObj=new JSONObject();
			jsonObj.put("type", "message");
			jsonObj.put("msg", msg);
			jsonObj.put("chatName", this.chatName);
			String json=jsonObj.toString();
			this.send(json);	// this.send() 메세지 전송하는 메소드 호출
			inputText.setText("");
			inputText.requestFocus();
		}
	}
	@Override
	public void keyReleased(KeyEvent e) {
		
	}
	@Override
	public void keyTyped(KeyEvent e) {
		
	}
}
