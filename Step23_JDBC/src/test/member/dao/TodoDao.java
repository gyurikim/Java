package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTextField;

import test.member.dto.TodoDto;
import test.util.DBConnect;

public class TodoDao {
	public static boolean insert(TodoDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "insert into todolist (num, list, r_u_success, e_time) values(?,?,?,?)";
			// 준비된 참조값을 얻어오기 위해서는 sql문을 수행할 prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			int num = dto.getNum();
			String list = dto.getList();
			String r_u_success = dto.getR_u_success();
			String e_time = dto.getE_time();

			// ?에 필요한값 바인딩하기
			pstmt.setInt(1, num);// .setInt(몇번째물음표, num)
			pstmt.setString(2, list);
			pstmt.setString(3, r_u_success);
			pstmt.setString(4, e_time);
			// sql문 실행하기
			// executeUpdate()메소드는 변화된 row의 갯수를 리턴한다
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
			}
		}
		if (flag > 0) {// 성공
			return true;
		} else {// 실패
			return false;
		}
	}

	@SuppressWarnings("finally")
	public static boolean update(TodoDto dto) {
		// 1번회원의 이름을 이정호로 수정하기
		int num = 1;
		String list = "";
		String r_u_success = "";
		String e_time = "";

		// 위의 내용을 토대로 회원정보를 수정하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();

			String sql = "update todolist set list=?, r_u_success=?, e_time=? where num=?";
			pstmt = conn.prepareStatement(sql);
			// ?에 값을 바인딩하기
			pstmt.setString(1, dto.getList());
			pstmt.setString(2, dto.getR_u_success());
			pstmt.setString(3, dto.getE_time());
			pstmt.setInt(4, dto.getNum());
			// name 문자열 읽어오기
			// 실행
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			// 위의 작업의 성공여부를 알고 싶으면?
			if (flag > 0) {
				return true;
			} else {
				return false;
			}
		}

	}

	@SuppressWarnings("finally")
	public static boolean delete(int num) {
		// 4번회원 삭제하기
		num = 1;
		// 위의 내용을 토대로 회원정보를 수정하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "delete from todolist where num=?";
			pstmt = conn.prepareStatement(sql);

			// ?에 바인딩하기
			pstmt.setInt(1, num);

			// 실행
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
			// 위의 작업의 성공여부를 알고 싶으면?
			if (flag > 0) {
				return true;
			} else {
				return false;
			}
		}
	}

	
}
