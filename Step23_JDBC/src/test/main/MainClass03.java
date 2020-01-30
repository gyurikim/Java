package test.main;

import java.sql.Connection;
import java.sql.PreparedStatement;

import test.util.DBConnect;

public class MainClass03 {
	public static void main(String[] args) {
		int num = 4;
		String name = "원숭이";
		String addr = "행신동";
		// 위의 정보를 member테이블에 insert 하기
		Connection conn = null;
		PreparedStatement pstmt = null;
//		ResultSet rs = null;		>>select문이 아닌경우에는 필요없음
		int flag = 0;
		try {
			
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "insert into member" + " (num,name,addr)" + " values(?,?,?)";
			// 준비된 참조값을 얻어오기 위해서는 sql문을 수행할 prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
			// ?에 필요한값 바인딩하기
			pstmt.setInt(1, num);// .setInt(몇번째물음표, num)
			pstmt.setString(2, name);
			pstmt.setString(3, addr);
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
			System.out.println("회원정보를 성공적으로 추가하였습니다");

		} else {// 실패
			System.out.println("회원정조 추가실패");
		}

	}
}
