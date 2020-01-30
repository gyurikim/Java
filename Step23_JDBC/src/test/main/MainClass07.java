package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

public class MainClass07 {
	public static void main(String[] args) {
	//한명의 회원정보를 얻어오고 싶다
		int num=1;
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "select num,name,addr from member where num=?";
			// sql문을 수행할 prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩하기
			pstmt.setInt(1, num);
			// sql문을 수행하고 결과를 ResultSet 으로 받아오기
			rs = pstmt.executeQuery();
			// sql문 실행하기
			while (rs.next()) {
				//커서가 위치한 곳에서 "name"칼럼에 있는 문자열 읽어오기
				String name = rs.getString("name");
				//커서가 위치한 곳에서 "addr"칼럼에 있는 문자열 읽어오기
				String addr = rs.getString("addr");
				System.out.println(num + "|" + name + "|" + addr);
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
