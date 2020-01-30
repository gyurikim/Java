package test.main;

import javax.swing.JButton;
import javax.swing.JFrame;

public class MainClass01 {
	public static void main(String[] args) {
		JFrame frame = new JFrame("MyFrame");
		// 닫기 버튼을 눌렀을떄 process가 종료되도록 설정
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// 크기
		frame.setSize(300, 300);
		// 위치
		frame.setLocation(200, 200);
		// 화면에 보이게 하기
		frame.setVisible(true);
		frame.setLayout(null);
		
		// 버튼객체만들어서
		JButton btn = new JButton("눌러보세여");
		btn.setSize(100, 40);
//		btn.setLocation(10, 10);
		// 프레임에추가하기
		frame.add(btn);

		new YourFrame("YourFrame");
	}

	static class YourFrame extends JFrame {
		// 생성자
		public YourFrame(String title) {
			super(title);

			this.setDefaultCloseOperation(EXIT_ON_CLOSE);
			this.setSize(300, 300);
			this.setLocation(500, 200);
			this.setVisible(true);
			this.setLayout(null);

			JButton btn = new JButton("눌러봥");
			btn.setSize(100, 40);
			btn.setLocation(10, 10);
			add(btn);
		}
	}
}
