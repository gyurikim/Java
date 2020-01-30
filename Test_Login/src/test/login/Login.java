package test.login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;

public class Login {

	private JFrame frame;
	private JTextField id;
	private JTextField useId;
	private JPasswordField pass;
	private JPasswordField usePwd;
	private JTextField useNick;
	public static String chatName;
	public static LoginDto forName;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Login() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setTitle("로그인");
		frame.setBounds(100, 100, 621, 504);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		final JPanel loginPanel = new JPanel();
		loginPanel.setBounds(0, 0, 605, 465);
		frame.getContentPane().add(loginPanel);
		loginPanel.setLayout(null);
		final JPanel createNewIDpanel = new JPanel();
		createNewIDpanel.setBounds(0, 0, 605, 465);
		frame.getContentPane().add(createNewIDpanel);
		createNewIDpanel.setLayout(null);
		
		
		JLabel lblNewLabel = new JLabel("사용할 아이디");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(161, 183, 76, 22);
		createNewIDpanel.add(lblNewLabel);
		
		useId = new JTextField();
		useId.setColumns(10);
		useId.setBounds(249, 184, 116, 21);
		createNewIDpanel.add(useId);
		
		JLabel label = new JLabel("비밀번호");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setBounds(161, 215, 76, 22);
		createNewIDpanel.add(label);
		
		usePwd = new JPasswordField();
		usePwd.setBounds(249, 216, 116, 21);
		createNewIDpanel.add(usePwd);
		JButton creatIDBtn = new JButton("가입하기");
		//회원가입 버튼
		creatIDBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String id=useId.getText();
				int pwd=Integer.parseInt(usePwd.getText());
				String nick=useNick.getText();
				LoginDto dto=new LoginDto(id,pwd,nick);
				LoginDao dao=new LoginDao();
				boolean isSuccess=dao.insert(dto);
				if(isSuccess) {
					JOptionPane.showMessageDialog(null, "가입되었습니다.");
					createNewIDpanel.setVisible(false);
					loginPanel.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "이미 사용중인 아이디 입니다.");
				}
			}
		});
		creatIDBtn.setBounds(249, 297, 99, 37);
		createNewIDpanel.add(creatIDBtn);
		
		JLabel nickLabel = new JLabel("닉네임");
		nickLabel.setHorizontalAlignment(SwingConstants.CENTER);
		nickLabel.setBounds(161, 247, 76, 22);
		createNewIDpanel.add(nickLabel);
		
		useNick = new JTextField();
		useNick.setColumns(10);
		useNick.setBounds(249, 247, 116, 21);
		createNewIDpanel.add(useNick);
		
		
		
		JLabel lblId = new JLabel("아이디");
		lblId.setBounds(161, 186, 57, 15);
		lblId.setHorizontalAlignment(SwingConstants.CENTER);
		loginPanel.add(lblId);
		
		JLabel lblPassword = new JLabel("비밀번호");
		lblPassword.setBounds(161, 211, 57, 15);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		loginPanel.add(lblPassword);
		
		id = new JTextField();
		id.setBounds(230, 183, 116, 21);
		loginPanel.add(id);
		id.setColumns(10);
		
		JButton btnNewButton = new JButton("로그인");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginDao dao=new LoginDao();
				LoginDto dto=dao.getData(id.getText());
				if(dto.getId().equals(id.getText()) && Integer.toString(dto.getPassword()).equals(pass.getText())) {
					JOptionPane.showMessageDialog(null, dto.getNickName()+" 님 반갑습니다!");
					chatName=dto.getNickName();	//ChatFrame으로 값을 넘기기 위해 필드에 저장.
					ChatFrame chat=new ChatFrame();
					forName=setName(dto.getNickName());
					chat.setVisible(true);
					
				}else {
					JOptionPane.showMessageDialog(null, "아이디 혹은 비밀번호가 틀렸습니다.");
					System.out.println(dto.getId()+"|"+dto.getPassword());
					
				}
			}
		});
		btnNewButton.setBounds(359, 182, 83, 44);
		loginPanel.add(btnNewButton);
		
		JButton button = new JButton("회원가입");
		button.setBounds(230, 258, 97, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginPanel.setVisible(false);
				createNewIDpanel.setVisible(true);
			}
		});
		pass = new JPasswordField();
		pass.setBounds(230, 208, 116, 21);
		loginPanel.add(pass);
		loginPanel.add(button);
	}
	public LoginDto setName(String name) {
		LoginDto dto=new LoginDto();
		dto.setNickName(name);
		return dto;
	}
}
