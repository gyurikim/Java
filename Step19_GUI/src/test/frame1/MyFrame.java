package test.frame1;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener {
	// 생성자
	public MyFrame(String title) { // 생성자의 인자로 프레임의 제목을 전달받아서
		super(title);// 부모생성자에 전달한다
		// 스윙프로그램을 쓰면서 엑시트를 안하면 눈에서는 사라진거처럼 보이지만 메모리상에서는 사라지지 않기때문에 적어주어야한다
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// x, y, width, height를 한번에 저장하기
		setBounds(200, 200, 300, 300);
		// 기본레이아웃으로 동작하게 하기
		setLayout(null);
		// 화면에 보이게하기
		setVisible(true);

		// 버튼
		JButton btn = new JButton("눌러보세용");
		// x, y, width, height를 한번에 저장하기
		btn.setBounds(10, 10, 100, 40);
		// 버튼을 프레임에 추가하기
		add(btn);
		// 버튼에 리스너 등록하기
		btn.addActionListener(this);
	}

	// 카운트를 세는 필드만들기
	private int count;

	@Override
	public void actionPerformed(ActionEvent e) {
		count++;
		// .showMessageDialog(컴포넌트의 참조값, 메세지);
		JOptionPane.showMessageDialog(this, count + "번 버튼을 클릭했네?");
	}

	public static void main(String[] args) {
		new MyFrame("MyFrame_1");
	}
}
