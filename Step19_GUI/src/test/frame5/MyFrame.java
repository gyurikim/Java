package test.frame5;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Container;
import java.awt.Frame;
import java.awt.Window;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener {
	// 생성자
	public MyFrame(String title) { // 생성자의 인자로 프레임의 제목을 전달받아서
		super(title);// 부모생성자에 전달한다
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// x, y, width, height를 한번에 저장하기
		setBounds(200, 200, 500, 500);
		// 레이아웃설정하기
		setLayout(new BorderLayout());
	
		
		JButton btn1 = new JButton("up");
		add(btn1, "North"); // 이렇게 간단하게도 사용할수있지만 오타가 날수있는 관계로 아래처럼 사용한다

		JButton btn2 = new JButton("down");
		add(btn2, BorderLayout.SOUTH);

		JButton btn3 = new JButton("right");
		add(btn3, BorderLayout.EAST);

		JButton btn4 = new JButton("left");
		add(btn4, BorderLayout.WEST);

		JButton btn5 = new JButton("center");
		add(btn5, BorderLayout.CENTER);
		
		// 화면에 보이게하기	
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		MyFrame a = this;
		JFrame b = this;
		ActionListener c = this;
		Frame d = this;
		Window e1 = this;
		Container f = this;
		Component g = this;
		Object h = this;
		
		JOptionPane.showMessageDialog(this, "hello");
	}

	public static void main(String[] args) {
		new MyFrame("MyFrame_1");
	}

}










