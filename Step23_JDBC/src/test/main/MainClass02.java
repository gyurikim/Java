package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import test.util.DBConnect;

/*
 * 사원번호, 사원이름, 부서명을 select해서 콘솔창에 출력해보세요
 */
public class MainClass02 {
	public static void main(String[] args) {
		// emp 테이블의 사원번호, 사원이름,급여 select 해보기
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문작성
			String sql = "select empno,ename,dname "
					+ " from emp,dept "
					+ " where emp.deptno=dept.deptno "
					+ " order by empno asc";
			// connection 객체의 메소드를 이용해서 prepareStatement 객체 얻어내기
			pstmt = conn.prepareStatement(sql);
			// select 문을 수행하고 결과를 ResultSet 으로 받아오기
			rs = pstmt.executeQuery();
			// 반복문 돌면서 ResultSet 객체에 들어있는 정보를 출력하기
			while (rs.next()) {
				int empno = rs.getInt("empno");
				String ename = rs.getString("ename");
				String dname = rs.getString("dname");
				System.out.println(empno + "|" + ename + "|" + dname);

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
