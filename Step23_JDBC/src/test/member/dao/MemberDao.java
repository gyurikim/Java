package test.member.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import test.member.dto.MemberDto;
import test.util.DBConnect;

/*
 * Data Access Object (DAO)
 * -insert,update,delete,select 작업을 할 클래스 설계
 */
public class MemberDao {
	// 회원전체목록을 리턴하는 메소드
	public List<MemberDto> getList() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// select된 결과를 저장해서 리턴할 객체를 저장할 지역변수 선언
		List<MemberDto> list = new ArrayList<>();
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "select num,name,addr from member order by num asc";
			pstmt = conn.prepareStatement(sql);
			// ?에 팔요한값 바인딩하기

			rs = pstmt.executeQuery();
			// resultSet객체에서 필요한값ㅇ 얻어내기
			while (rs.next()) {
				// select된 row하나당 하나의 MemberDto객체를 생성해서
				MemberDto dto = new MemberDto();
				// row에 있는 정보를 MemberDto 객체레 setter메소드를 이용해서 담고
				dto.setNum(rs.getInt("num"));
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
				// 회원한명의 정보가 담긴 MemberDto객체의 참조값을 arraylist에 누적시키기
				list.add(dto);
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
		return list;
	}

	// 회원 한명의 정보를 리턴하는 메소드
	public MemberDto getData(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		// select된 결과를 저장해서 리턴할 객체를 저장할 지역변수 선언
		MemberDto dto = null;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "select name,addr from member where num=?";
			pstmt = conn.prepareStatement(sql);
			// ?에 팔요한값 바인딩하기
			pstmt.setInt(1, num);
			rs = pstmt.executeQuery();
			// resultSet객체에서 필요한값ㅇ 얻어내기
			while (rs.next()) {
				dto = new MemberDto();// 까먹지말고 객체 생성해주기!!!
				// setter메소드를 이용해서 dto에 회원번호 저장
				dto.setNum(num);
				dto.setName(rs.getString("name"));
				dto.setAddr(rs.getString("addr"));
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
		// 회원정보가 담긴 memberDto 객체의 참조값을 리턴해준다
		return dto;
	}

	// 회원 한명의 정보를 수정하는 메소드
	public boolean update(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "update member set name=?,addr=? where num=?";
			// 준비된 참조값을 얻어오기 위해서는 sql문을 수행할 prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);

			// ?에 필요한값 바인딩하기
			pstmt.setString(1, dto.getName());
			pstmt.setString(2, dto.getAddr());
			pstmt.setInt(3, dto.getNum());
			// sql문 실행하기
			// executeUpdate()메소드는 변화된 row의 갯수를 리턴한다
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e);
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

	// 회원 한명의 정보를 삭제하는 메소드
	public boolean delete(int num) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "delete from member where num=?";
			// 준비된 참조값을 얻어오기 위해서는 sql문을 수행할 prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);

			// ?에 필요한값 바인딩하기
			pstmt.setInt(1, num);
			// sql문 실행하기
			// executeUpdate()메소드는 변화된 row의 갯수를 리턴한다
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
			// e.printStackTrace();
			System.out.println(e);
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

	// map은 캐스팅을 무조건 해주어야하는 불편함때문에 잘 사용하지 않는다
	// 대부분 DTO를 이용해서 회원정보를 입력한다

	// MemberDto객체를 인자로 전달받는 매소드
	public boolean insert(MemberDto dto) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "insert into member (num,name,addr) values(member_seq.nextval,?,?)";
			// 준비된 참조값을 얻어오기 위해서는 sql문을 수행할 prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);
//			int num = dto.getNum();
			String name = dto.getName();
			String addr = dto.getAddr();

			// ?에 필요한값 바인딩하기
//			pstmt.setInt(1, num);// .setInt(몇번째물음표, num)
			pstmt.setString(1, name);
			pstmt.setString(2, addr);
			// sql문 실행하기
			// executeUpdate()메소드는 변화된 row의 갯수를 리턴한다
			flag = pstmt.executeUpdate();
		} catch (Exception e) {
//			e.printStackTrace();
			System.out.println(e);
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

	// Map 객체를 인자로 전달받는 매소드 >> map은 캐스팅을 무조건 해주어야하는 불편함때문에 잘 사용하지 않는다
	public boolean insert(Map<String, Object> map) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "insert into member (num,name,addr) values(?,?,?)";
			// 준비된 참조값을 얻어오기 위해서는 sql문을 수행할 prepareStatement 객체의 참조값 얻어오기
			pstmt = conn.prepareStatement(sql);

			// map객체에 "num"이라는 키값으로 저장된 int type 불러오기
			int num = (int) map.get("num");
			// map객체에 "name"이라는 키값으로 저장된 String type 불러오기
			String name = (String) map.get("name");
			// map객체에 "addr"이라는 키값으로 저장된 String type 불러오기
			String addr = (String) map.get("addr");

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
			return true;
		} else {// 실패
			return false;
		}
	}

	// DB에 회원한명의 정보(num,name,addr)를 추가하는 메소드
	public boolean insert(int num, String name, String addr) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int flag = 0;
		try {
			conn = new DBConnect().getConn();
			// 실행할 sql문 의 뼈대 구성하기
			String sql = "insert into member (num,name,addr) values(?,?,?)";
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
			return true;
		} else {// 실패
			return false;
		}
	}
}
