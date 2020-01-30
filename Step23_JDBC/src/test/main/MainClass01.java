package test.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement; //insert,select
import java.sql.ResultSet;

/*
 * Java DataBase connectivity (JDBC)
 * -oracle에 연결하기 위해서는 ojdbc.jar 파일이 필요하다
 */
public class MainClass01 {
	public static void main(String[] args) {
		// DB 연결객체를 담을 지역변수
		Connection conn = null;
		try {
			// 드라이버로딩
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// 접속할 DB정보
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; // 1521 > 포트번호 아니면 ip주소를 직접 작성해도 됨 / xe: default DB이름
			// 접속하고 Connection 객체의 참조값 얻어오기
			conn = DriverManager.getConnection(url, "scott", "tiger"); // 계정,비밀번호
			System.out.println("Oracle DB 접속성공!");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// emp 테이블의 사원번호, 사원이름,급여 select 해보기
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			// 실행할 sql문작성
			String sql = "select empno,ename,sal from emp";
			// connection 객체의 메소드를 이용해서 prepareStatement 객체 얻어내기
			pstmt = conn.prepareStatement(sql);
			// select 문을 수행하고->(쿼리를 한다) 결과를 ResultSet 으로 받아오기
			rs = pstmt.executeQuery();
			// 반복문 돌면서 ResultSet 객체에 들어있는 정보를 출력하기
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				int sal = rs.getInt("sal");
				System.out.println(empno + "|" + ename + "|" + sal);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
