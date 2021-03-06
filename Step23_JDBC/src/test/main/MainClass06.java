package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass06 {
	public static void main(String[] args) {
		// 4번회원 삭제하기
		int num=4;
				
		//위의 내용을 토대로 회원정보를 수정하기
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			String sql = "delete from member where num=?";
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
				System.out.println("삭제 성공!!!");
			} else {
				System.out.println("삭제 실패ㅠㅠ");
			}
		}
	}
}
