package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberFrame extends JFrame implements ActionListener {
	// 필드
	JTextArea area;
	JTextField inputNum, inputName, inputAddr;

	// 생성자
	public MemberFrame(String title) {
		super(title);
		initUI();// ui초기화
		printMember();// 회원정보 출력하기 select문
	}

	// ui초기화하는 메소드
	public void initUI() {
		setBounds(100, 100, 800, 500);// 위치와 크기설정
		setLayout(new BorderLayout());// 레이아웃법칙설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 닫았을때 process종료

		area = new JTextArea();
		JScrollPane scPane = new JScrollPane(area);
		add(scPane, BorderLayout.CENTER);

		// 수정이나 포커스를 받지 못하도록 문자열 출력용으로만 사용하기
		area.setEditable(false);
		area.setFocusable(false);

		// 패널만들기
		JPanel p = new JPanel();

		// 회원정보 입력ui만들기
		JLabel label1 = new JLabel("번호");
		JLabel label2 = new JLabel("이름");
		JLabel label3 = new JLabel("주소");

		inputNum = new JTextField(10);
		inputName = new JTextField(10);
		inputAddr = new JTextField(10);

		JButton saveBtn = new JButton("저장");
		JButton updateBtn = new JButton("수정");
		JButton deleteBtn = new JButton("삭제");

		// 패널에 순서대로 ui나열시키기
		p.add(label1);
		p.add(inputNum);
		p.add(label2);
		p.add(inputName);
		p.add(label3);
		p.add(inputAddr);
		p.add(saveBtn);
		p.add(updateBtn);
		p.add(deleteBtn);
		// 패널을 프레임상단에 배치
		add(p, BorderLayout.NORTH);

		// 버튼에 액션리스너 등록
		saveBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		// 버튼액션에 command설정
		saveBtn.setActionCommand("save");
		updateBtn.setActionCommand("update");
		deleteBtn.setActionCommand("delete");

		setVisible(true);// 프레임이 화면에 보이게 설정
	}

	// 외원정보를 출력하는 메소드
	public void printMember() {
		// JTextArea에 문자열을 모두지우고
		area.setText("");

		// 회원목록 출력하기
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.getList();
		for (MemberDto tmp : list) {
			String info = tmp.getNum() + "|" + tmp.getName() + "|" + tmp.getAddr();
			area.append(info + "\r\n");
		}

	}

	// app을 처음 launching(실행)할때 호출되는 메소드
	public static void main(String[] args) {
		new MemberFrame("회원정보");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌러진 버튼의 command문자열을 읽어와서
		String command = e.getActionCommand();
		if (command.equals("save")) {// 저장버튼을 눌렀으면
			// 입력한 번호,이름,주소 읽어오기
			int num = Integer.parseInt(inputNum.getText());
			String name = inputName.getText();
			String addr = inputAddr.getText();

			// MemberDto객체에담고
			MemberDto dto = new MemberDto(num, name, addr);
			// MemberDao 객체를 이용해서 DB에 담기
			MemberDao dao = new MemberDao();
			// 작업의 성공여부가 리턴된다
			boolean isSccess = dao.insert(dto);
			if (isSccess) {
				JOptionPane.showMessageDialog(this, "저장되었습니다");
				printMember();
			} else {
				JOptionPane.showMessageDialog(this, "저장을 실패하였습니다");
			}
		} else if (command.equals("update")) {
			// 입력한 번호,이름,주소 읽어오기
			int num = Integer.parseInt(inputNum.getText());
			String name = inputName.getText();
			String addr = inputAddr.getText();

			// MemberDto객체에담고
			MemberDto dto = new MemberDto(num, name, addr);
			// DB에 수정 반영하기
			boolean isSccess = new MemberDao().update(dto);
			if (isSccess) {
				JOptionPane.showMessageDialog(this, "수정되었습니다");
				printMember();
			} else {
				JOptionPane.showMessageDialog(this, "수정을 실패하였습니다");
			}
		} else if (command.equals("delete")) {
			// 삭제할 번호 읽어오기
			int num = Integer.parseInt(inputNum.getText());
			// MemberDao객체를 이용해서 삭제하기
			boolean isSccess = new MemberDao().delete(num);
			if (isSccess) {
				JOptionPane.showMessageDialog(this, "삭제되었습니다");
				printMember();
			} else {
				JOptionPane.showMessageDialog(this, "삭제을 실패하였습니다");
			}
		}
	}
}
