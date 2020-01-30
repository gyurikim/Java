package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

public class todoselect {
	public static void main(String[] args) {
		/*
		 * member 테이블의 모든 정보를 콘솔창에 출력해보세여 단 회원번호에 대해서 오름차순을 하세여
		 */
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
				System.out.println(num + "|" + list + "|" + r_u_success + "|" + e_time);
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
