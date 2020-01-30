package test.login;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	//필드
	private Connection conn;
	//생성자
	public DBConnect() {
		try {
			//드라이버 로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			//접속할 DB 정보
			String url="jdbc:oracle:thin:@192.168.0.10:1521:xe";	//localhost 는 현재 내 컴퓨터. 다른 컴퓨터의 IP주소를 적으면 그 곳으로 접속. 1521은 port, xe는 DB명
			//접속하고 Connection 객체의 참조값 얻어오기
			conn=DriverManager.getConnection(url, "scott", "tiger");	//계정에 잘 들어가면 참조값이 잘 들어간다.
			System.out.println("Oracle DB 접속 성공");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	//Connection 객체를 리턴해주는 메소드
	public Connection getConn() {	//생성자에서 Connection 객체를 넣어주고 getConn() 메소드를 이용해서 객체를 받아온다.
		return conn;
	}
	
}
