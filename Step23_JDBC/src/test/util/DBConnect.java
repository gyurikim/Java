package test.util;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * Connection객체의 참조값을 얻어와서 리턴해주는 객체를 생성하기 위한 클래스
 */
public class DBConnect {
	// 필드
	private Connection conn;

	// 생성자
	public DBConnect() {
		try {
			// 드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속할 DB정보
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 1521 > 포트번호 아니면 ip주소를 직접 작성해도 됨
			// 접속하고 Connection 객체의 참조값 얻어오기
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 계정,비밀번호
			System.out.println("Oracle DB 접속성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Connection 객체를 리턴해주는 메소드
	public Connection getConn() {
		return conn;
	}
}
