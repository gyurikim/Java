package test.frame;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MemberFrame2 extends JFrame implements ActionListener, ListSelectionListener {
	// 필드
	JTextField inputNum, inputName, inputAddr;
	JTable table;
	DefaultTableModel model;
	boolean isEditing = false;// 수정하고있는 상태인지 여부를 확인하는 변수
	JButton saveBtn, updateBtn, deleteBtn, cancelBtn;

	// 생성자
	public MemberFrame2(String title) {
		super(title);
		initUI();// ui초기화
		printMember();// 회원정보 출력하기
	}

	// ui초기화하는 메소드
	public void initUI() {
		setBounds(100, 100, 800, 500);// 위치와 크기설정
		setLayout(new BorderLayout());// 레이아웃법칙설정
		setDefaultCloseOperation(EXIT_ON_CLOSE);// 닫았을때 process종료

		table = new JTable();

		// 패널만들기
		JPanel p = new JPanel();
		// 칼럼명을 배열애 미리 준비하기
		String[] colName = { "번호", "이름", "주소" };
		// 모델
		model = new DefaultTableModel(colName, 0) {// 테이블 내용 수정못하게 막기
			@Override
			public boolean isCellEditable(int row, int column) {
				return false;
			}

		};
		// 모델을 테이블에 연결하기
		table.setModel(model);
		// 테이블을 감싸는 스크롤 계층을 만들고
		JScrollPane scPane = new JScrollPane(table);
		// 스크롤 계층을 프레임의 가운데에 붙이기
		add(scPane, BorderLayout.CENTER);

		ListSelectionModel selectionModel = table.getSelectionModel();
		selectionModel.addListSelectionListener(this);

		// 회원정보 입력ui만들기
		JLabel label1 = new JLabel("번호");
		JLabel label2 = new JLabel("이름");
		JLabel label3 = new JLabel("주소");

		inputNum = new JTextField(10);
		inputName = new JTextField(10);
		inputAddr = new JTextField(10);

		// 버튼의 참조값도 필드에 저장하기
		saveBtn = new JButton("저장");
		updateBtn = new JButton("수정");
		deleteBtn = new JButton("삭제");
		cancelBtn = new JButton("취소");

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
		p.add(cancelBtn);
		// 패널을 프레임상단에 배치
		add(p, BorderLayout.NORTH);

		// 버튼에 액션리스너 등록
		saveBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);
		cancelBtn.addActionListener(this);
		// 버튼액션에 command설정
		saveBtn.setActionCommand("save");
		updateBtn.setActionCommand("update");
		deleteBtn.setActionCommand("delete");
		cancelBtn.setActionCommand("cancel");

		// 번호는 입력이나 수정이 불가하도록 설정
		inputNum.setEditable(false);
		// 처음 프레임을 시작했을때는 수정, 삭제 버튼은 비활성화 시키기
		updateBtn.setEnabled(false);
		deleteBtn.setEnabled(false);

		setVisible(true);// 프레임이 화면에 보이게 설정
	}

	// 회원정보를 출력하는 메소드
	public void printMember() {
		// DefaultTableModel의 객체의 메소드를 이용해서table에 출력된 데이터를 일단모두 삭제한다
		model.setRowCount(0);

		// 회원목록 출력하기
		MemberDao dao = new MemberDao();
		List<MemberDto> list = dao.getList();
		for (MemberDto tmp : list) {
			// MemberDto에 들어있는 정보를 Vector<Object> 객체에 담는다
			Vector<Object> v = new Vector<Object>();
			v.add(tmp.getNum());
			v.add(tmp.getName());
			v.add(tmp.getAddr());
			// Vector객체를 DefaultTableModel객체에 전달해서 row를 추가
			model.addRow(v);

		}

	}

	// app을 처음 launching(실행)할때 호출되는 메소드
	public static void main(String[] args) {
		new MemberFrame2("회원정보");
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// 눌러진 버튼의 command문자열을 읽어와서
		String command = e.getActionCommand();
		if (command.equals("save")) {// 저장버튼을 눌렀으면
			// 입력한 번호,이름,주소 읽어오기
//			int num = Integer.parseInt(inputNum.getText());
			String name = inputName.getText();
			String addr = inputAddr.getText();

			// MemberDto객체에담고
			MemberDto dto = new MemberDto(0, name, addr);
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
				// 입력창 비우기
				inputNum.setText("");
				inputName.setText("");
				inputAddr.setText("");
				// 수정상태 취소
				isEditing = false;
				// 저장버튼만 작동하도록 설정
				saveBtn.setEnabled(true);
				updateBtn.setEnabled(false);
				deleteBtn.setEnabled(false);
				// 선택해제
				printMember();
			} else {
				JOptionPane.showMessageDialog(this, "삭제을 실패하였습니다");
			}
		} else if (command.equals("cancel")) {
			// 입력창 비우기
			inputNum.setText("");
			inputName.setText("");
			inputAddr.setText("");
			// 수정상태 취소
			isEditing = false;
			// 저장버튼만 작동하도록 설정
			saveBtn.setEnabled(true);
			updateBtn.setEnabled(false);
			deleteBtn.setEnabled(false);
			// 선택해제
			table.clearSelection();
		}
	}

	// 테이블 row가 선택되면 호출되는 메소드
	@Override
	public void valueChanged(ListSelectionEvent e) {
		// 선택한 row의 인덱스 값 읽어오기
		int selectedRow = table.getSelectedRow();
		if (selectedRow == -1) {// 다른버튼을 누르면 값을 지우고 다시 들어오게 되는데 이미 값이 없어진다. 값이 없어지면 -1이 리턴되기 때문에 오류가 발생한다
			return;
		}
		int num = (int) table.getValueAt(selectedRow, 0);
		String name = (String) table.getValueAt(selectedRow, 1);
		String addr = (String) table.getValueAt(selectedRow, 2);
		inputNum.setText(Integer.toString(num));
		inputName.setText(name);
		inputAddr.setText(addr);
		// 수정하고 있는 상태로 바꾸기
		if (!isEditing) {
			isEditing = true;
			saveBtn.setEnabled(false);
			updateBtn.setEnabled(true);
			deleteBtn.setEnabled(true);
		}
	}
}
