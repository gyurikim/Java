package test.frame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import test.member.dao.TodoDao;
import test.member.dto.TodoDto;
import test.util.DBConnect;

public class todoFrame extends JFrame implements ActionListener {
	// 필드
//	private JTable table;

	private JTextField num;
	private JTextField list;
	private JTextField r_u_Success;
	private JTextField e_time;
	private JTable jtable;
	private DefaultTableModel model;

	// 생성자
	public todoFrame(String title) { // 생성자의 인자로 프레임의 제목을 전달받아서
		super(title);// 부모생성자에 전달한다
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		// x, y, width, height를 한번에 저장하기
		setBounds(200, 200, 800, 500);
		// 기본레이아웃으로 동작하게 하기
		setLayout(new BorderLayout());

		JPanel p1 = new JPanel();

		num = new JTextField(5);
		list = new JTextField(20);
		r_u_Success = new JTextField(10);
		e_time = new JTextField(10);

		JButton insertBtn = new JButton("insert");
		JButton updateBtn = new JButton("update");
		JButton deleteBtn = new JButton("delete");

		String[] colName = { "num", "list", "R_U_Success", "e_time" };
		model = new DefaultTableModel(colName, 0);

		// 테이블 생성하기
		jtable = new JTable(model);
		
		p1.setBounds(0, 0, 800, 10);
		jtable.setBounds(0, 10, 500, 490);
		add(new JScrollPane(jtable));

		p1.add(num);
		p1.add(list);
		p1.add(r_u_Success);
		p1.add(e_time);
		p1.add(insertBtn);
		p1.add(updateBtn);
		p1.add(deleteBtn);

		add(p1, BorderLayout.NORTH);
		insertBtn.addActionListener(this);
		updateBtn.addActionListener(this);
		deleteBtn.addActionListener(this);

		insertBtn.setActionCommand("insert");
		updateBtn.setActionCommand("update");
		deleteBtn.setActionCommand("delete");

		// 화면에 보이게하기
		setVisible(true);
		select();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
//		int row= jtable.getSelectedRow();

		if (command.equals("insert")) {
			try {
				String[] arr = new String[4];
				arr[0] = num.getText();
				arr[1] = list.getText();
				arr[2] = r_u_Success.getText();
				arr[3] = e_time.getText();
				int a = Integer.parseInt(arr[0]);
				TodoDto dto = new TodoDto(a, arr[1], arr[2], arr[3]);
				TodoDao.insert(dto);
				model.addRow(arr);
				
				num.setText("");
				list.setText("");
				r_u_Success.setText("");
				e_time.setText("");
				
				select();
//				JOptionPane.showMessageDialog(this, "성공적으로 입력하였습니다");
			} catch (Exception e1) {
				System.out.println(e1);
			}
		} else if (command.equals("delete")) {
			try {
				String[] arr = new String[4];
				arr[0] = num.getText();
				arr[1] = list.getText();
				arr[2] = r_u_Success.getText();
				arr[3] = e_time.getText();
				int a = Integer.parseInt(arr[0]);
				int rowNum = jtable.getSelectedRow();
				model.removeRow(rowNum);
				TodoDto dto = new TodoDto(a, arr[1], arr[2], arr[3]);
				TodoDao.delete(a);
				select();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		} else if (command.equals("update")) {
			try {
				String[] arr = new String[4];
				arr[0] = num.getText();
				arr[1] = list.getText();
				arr[2] = r_u_Success.getText();
				arr[3] = e_time.getText();
				int a = Integer.parseInt(arr[0]);
				int rowNum = jtable.getSelectedRow();
				model.setNumRows(rowNum);
				TodoDto dto = new TodoDto(a, arr[1], arr[2], arr[3]);
				TodoDao.update(dto);
				select();
			} catch (Exception e3) {
				System.out.println(e3);
			}
		}
	}

	public static void main(String[] args) {

		new todoFrame("나의 프레임");
	}

	public void select() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "select * from todolist order by num asc";
			// sql문을 수행할 prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// sql문을 수행하고 결과를 ResultSet 으로 받아오기
			rs = pstmt.executeQuery();
			// sql문 실행하기
			while (rs.next()) {
				int num = rs.getInt("num");
				String list = rs.getString("list");
				String r_u_success = rs.getString("r_u_success");
				String e_time = rs.getString("e_time");
//				System.out.println(num + "|" + list + "|" + r_u_success + "|" + e_time);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
	}
}
