package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass05 {
	public static void main(String[] args) {
		// 1번회원의 이름을 이정호로 수정하기
		int num=1;
		String name="이정호";
		String addr="독산동";
		
		//위의 내용을 토대로 회원정보를 수정하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "update member set name=?,addr=? where num=?";
			pstmt = conn.prepareStatement(sql);
			// ?에 값을 바인딩하기
			// name 문자열 읽어오기
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			pstmt.setInt(3, num);
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
				System.out.println("수정 성공!!!");
			} else {
				System.out.println("수정 실패ㅠㅠ");
			}
		}
	}
}
