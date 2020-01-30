package test.main;

import java.awt.BorderLayout;
import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class FrameExample extends JFrame implements ActionListener {
	// 필드
	JTextArea area;
	JFileChooser fc = new JFileChooser();

	// 생성자
	public FrameExample(String title) {
		super(title);

		// 메뉴 아이템 만들기
		JMenuItem item_open = new JMenuItem("open");
		JMenuItem item2_save = new JMenuItem("save");
		JMenuItem item3_delete = new JMenuItem("delete");
		// 메뉴 아이템을 감싸줄 메뉴 만들기
		JMenu menu = new JMenu("File");
		menu.add(item_open);
		menu.add(item2_save);
		menu.add(item3_delete);
		// 메뉴를 감싸줄 메뉴바 만들기
		JMenuBar bar = new JMenuBar();
		bar.setBounds(0, 0, 500, 20);
		bar.add(menu);
		// 프레임에 메뉴바 추가 하기
		add(bar, BorderLayout.NORTH);

		// 텍스트 파일의 내용을 출력할 UI
		area = new JTextArea();

		// Scroll 계층에 JTextArea 를 넣고
		JScrollPane scrollPane = new JScrollPane(area);
		scrollPane.setBounds(0, 20, 480, 480);

		// 스크롤 계층을 프레임에 추가 하기
		add(scrollPane, BorderLayout.CENTER);

		// 메뉴 아이템을 눌렀을때 동작하기위해
		item_open.addActionListener(this);
		item_open.setActionCommand("open");
		item2_save.addActionListener(this);
		item2_save.setActionCommand("save");
		item3_delete.addActionListener(this);
		item3_delete.setActionCommand("delete");
	}

	public static void main(String[] args) {
		FrameExample frame = new FrameExample("예제");
		frame.setSize(500, 500);
		frame.setLocation(100, 100);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 어떤 action command를 가지고왔는지 읽어온다
		String command = e.getActionCommand();

		if (command.equals("open")) { // 만약 open이라는 command라면
			int result = fc.showOpenDialog(this);

			// 정상적으로 파일을 선택하고 확인을 눌렀다면 > 0이 리턴된다
			if (result == JFileChooser.APPROVE_OPTION) {
				// 선택한 파일을 access 할수있는 file 객체의 참조값얻어오기
				File selectedFile = fc.getSelectedFile();
//				selectedFile.delete();
				FileReader fr = null;
				BufferedReader br = null;

				try {
					// 파일에서 문자열을 읽어들일 객체생성하기
					fr = new FileReader(selectedFile);
					br = new BufferedReader(fr);
					while (true) {
						// 한줄씩 읽어낸다
						String line = br.readLine();
						if (line == null)
							break;
						// 읽은 내용을 JTextArea객체에 추가하기
						area.append(line);
						area.append("\r\n");// 개행기호 표시하기

					}
				} catch (Exception e1) {
					e1.printStackTrace();
				} finally {
					try {
						// 마무리 클로우즈시키기
						if (fr != null)
							fr.close();
						if (br != null)
							br.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		} else if (command.equals("save")) { // 만약 save이라는 command라면
			// 선택된 file객체를 얻어온다
			File seleFile = fc.getSelectedFile();
			if (seleFile == null) {
				JOptionPane.showMessageDialog(this, "파일을 열어주세요");
				return;// 메소드 끝내기
			}
			// 현재 입력한 문자열 읽어오기
			String content = area.getText();
			FileWriter fw = null;
			try {
				// 파일에 문자열을 출력할 객체 생성
				fw = new FileWriter(seleFile);
				// 문자열 출력
				fw.write(content);
				fw.flush();
				JOptionPane.showMessageDialog(this, "저장했습니다");
			} catch (Exception e1) {
				e1.printStackTrace();
			} finally {
				try {
					if (fw != null)
						fw.close();
				} catch (Exception e2) {
				}
			}

		} else if (command.equals("delete")) { // 만약 delete이라는 command라면
			File selFile = fc.getSelectedFile();
			if (selFile == null) {
				return;
			}
			// 정말삭제할꺼니?
			int result = JOptionPane.showConfirmDialog(this, selFile.getName() + "을 정말 삭제하시겠습니까?");
			System.out.println(result);
			if (result == JOptionPane.YES_OPTION) {
				selFile.delete();
				JOptionPane.showMessageDialog(this, "삭제했습니다");
			}
		}
	}
}
