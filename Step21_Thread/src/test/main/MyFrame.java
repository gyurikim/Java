package test.main;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class MyFrame extends JFrame implements ActionListener {
	public MyFrame(String title) {
		super(title);
		setLayout(new BorderLayout());
		setBounds(100, 100, 300, 300);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		JButton downBtn = new JButton("다운로드");
		add(downBtn, BorderLayout.NORTH);
		setVisible(true);

		// 버튼에 ActionListner등록
		downBtn.addActionListener(this);
	}

	public static void main(String[] args) {
		new MyFrame("MyFrame");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JOptionPane.showMessageDialog(this, "다운로드시작됨");
		new Thread(new Runnable() {
			@Override
			public void run() {
				// 새로운 스레드에서 다운로드 작업을 한다
				String data = download();
				System.out.println("다운로드 결과 :" + data);
			}
		}).start();
	}

	// 가상의 다운로드를 하는 메소드
	public String download() {
		// 작업이 끝나는데 5초가 걸린다고 가정하자
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String data = "html, css, 자바스크립트, img . . . ";
		return data;
	}
}
