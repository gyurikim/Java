package test.main4;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
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
import java.util.Scanner;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import org.json.JSONArray;
import org.json.JSONObject;
import org.omg.CORBA.PUBLIC_MEMBER;

public class ClientMain extends JFrame implements ActionListener, KeyListener {
	// 필드
	private Socket socket;// 서버와 연결된 socket객체
	private BufferedWriter bw;// 서버에 문자열을 출력할수있는 객체
	private BufferedReader br;// 서버가 출력하는 문자열을 읽어들있수 있는 객체
	private JTextField inputText;
	private JTextArea ta;
	private String chatName;
	private JList<String> jList;

	// 생성자
	public ClientMain(String title) {
		super(title);// 부모생성자에 프레임의 제목 전달하기
		initUI();// UI준비하기
		connect();// socket 서버에 접속하기
	}

	// UI를 준비하는 메소드
	public void initUI() {
		setLayout(new BorderLayout());
		setBounds(100, 100, 500, 500);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		// 패널
		JPanel panelNorth = new JPanel();
		inputText = new JTextField(30);
		JButton sendBtn = new JButton("전송");
		// JTextArea
		ta = new JTextArea();
		ta.setBackground(Color.pink);

		// 스크롤
		JScrollPane scPane = new JScrollPane(ta, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, // 수직스크롤은 항상
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);// 수평스크롤은 필요에 따라서

		// 스크롤 계층을 프레임에 추가
		add(scPane, BorderLayout.CENTER);

		// 키리스너
		inputText.addKeyListener(this);

		//접속자 명단에 관령된 처리
		String[] names= {"참여자 목록"};
		jList=new JList<String>(names);
		jList.setBackground(Color.yellow);
		add(jList,BorderLayout.EAST);
		
		// 페널에 텍스트필드와 버튼을 추가하고
		panelNorth.add(inputText);
		panelNorth.add(sendBtn);
		// 페널을 프레임의 북쪽에 배치하기
		add(panelNorth, BorderLayout.NORTH);
		setVisible(true);

		// 대화명을 입력받기
		chatName = JOptionPane.showInputDialog(this, "대화명을 입력하세요");

		if (chatName == null || chatName.equals("")) {
			chatName = "바보";
		}
		// 지역변수에 있는 대화명을 필드에 저장
		this.chatName = chatName;

		// 버튼동작
		sendBtn.setActionCommand("send");
		sendBtn.addActionListener(this);
		
		//지역변수에 있는 대화명을 필드에 저장하기
//		this.chatName=chatName;
		//Jtextfield
		Font f= Font.decode("utf-8");
		//
		ta.setFont(f.deriveFont(Font.BOLD,18));
		
	}
	

	// Socket 서버에 접속하는 메소드 >> main Thread >> UI를 항상 제어하고 있어야하기 떄문에 무한루프를 만나거나 시간이 오래
	// 소요되는 작업이 이루어지면 안된다.
	public void connect() {
		try {
			// socket 객체의 참조값을 필드에 저장하기
			this.socket = new Socket("192.168.0.16", 5500);
			System.out.println("소켓연결성공");

			OutputStream os = socket.getOutputStream();
			OutputStreamWriter osw = new OutputStreamWriter(os);
			this.bw = new BufferedWriter(osw);
			// 챗팅방에 입장했다는 의미에서 대화명을 서버에 보내기
			// {"type":"enter","chatName":chatName}
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "enter");
			jsonObj.put("chatName", this.chatName);
			String json = jsonObj.toString();
			send(json);

			// 서버의 문자를 받아들이기
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			this.br = new BufferedReader(isr);

			// bufferdReader 객체를 이용해서 서버에서 문자열에 도착하는지 지속적으로 대기하는 스레드 객체를 생성해서 시작시켜야 된다
			ClientThread t = new ClientThread();
			t.start();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}// connect

	// 메세지를 전송하는 메소드 >> main Thread
	public void send(String json) {
		// 인자로 전달되는 json문자열을 서버에 출력하기
		try {
			bw.write(json);
			bw.newLine();
			bw.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		new ClientMain("Socket Client");

	}// main

	// 버튼을 누르면 호출되는 메소드 >> main Thread
	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		if (command.equals("send")) {// 만일 전송버튼을 눌렀다면
			String msg = inputText.getText();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "message");
			jsonObj.put("msg", msg);
			jsonObj.put("chatName", this.chatName);
			String json = jsonObj.toString();
			this.send(json);// 메세지를 전송하는 메소드 호출
			inputText.setText("");
			inputText.requestFocus();
		}
	}

	// 서버에서 문자열이 전송되는지 지속적으로 감시할 스레드 객체를 생성할 클래스
	class ClientThread extends Thread {
		@Override
		public void run() {
			while (true) {
				try {
					// 서버로부터 문자열이 도착하면 readLine()메소드가 호출된다
					String json = br.readLine();
					//도착한 json문자열을 이용해서 jsonobject를 만든다
					JSONObject jsonObj=new JSONObject(json);
					//어떤 type의 문자열인지 얻어낸다
					String type=jsonObj.getString("type");
					
					if(type.equals("enter")) {//누군가 입장했을떄
						String chatName=jsonObj.getString("chatName");
						String msg=chatName+"님이 입장하셧습니다.";
						ta.append(msg);
						ta.append("\r\n");
					}else if(type.equals("message")) {//대화메세지
						String chatName=jsonObj.getString("chatName");
						String message=jsonObj.getString("msg");
						String msg=chatName+":"+message;
						ta.append(msg);
						ta.append("\r\n");
					}else if(type.equals("update")) {
//						Vector<String>vec=null;
						JSONArray arr=jsonObj.getJSONArray("names");
						String[] names=new String[arr.length()];
						for(int i=0;i<arr.length();i++) {
							String name=arr.getString(i);
							names[i]=name;
						}
						jList.setListData(names);
					}else if(type.equals("leave")) {
						String chatName=jsonObj.getString("chatName");
						String msg=chatName+"님이 나갔습니다";
						ta.append(msg);
						ta.append("\r\n");
					}
					
					// 가장아래쪽으로 스크롤 이동시키기
					int height = ta.getDocument().getLength();
					ta.setCaretPosition(height);
				} catch (IOException e) {
					e.printStackTrace();
				}catch (Exception e2) {
				e2.printStackTrace();
				}
			}
		}// run
	}// ClientThread

	@Override
	public void keyPressed(KeyEvent e) {
		// 키를 눌렀을떄 호출되는 매소드
		int code = e.getKeyCode();// 눌러진 키의 코드값읽어오기
		if (code == KeyEvent.VK_ENTER) {
			String msg = inputText.getText();
			JSONObject jsonObj = new JSONObject();
			jsonObj.put("type", "message");
			jsonObj.put("msg", msg);
			jsonObj.put("chatName", this.chatName);
			String json = jsonObj.toString();
			this.send(json);// 메세지를 전송하는 메소드 호출
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
