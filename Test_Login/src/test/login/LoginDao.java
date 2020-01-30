package test.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class LoginDao {
	public List<LoginDto> getList(){
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		List<LoginDto> list=new ArrayList<>();
		try {
			conn = new DBConnect().getConn();
			//실행할 select문 구성하기
			String sql = "select id, password, nickname"
					+ " from login"
					+ " order by id asc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			//ResultSet 객체에서 필요한 값 얻어내기
			while (rs.next()) {
				//select 된 row 하나당 하나의 MemberDto 객체를 생성해서
				LoginDto dto=new LoginDto();
				//row 에 있는 정보를 MemberDto 객체에 setter 메소드를 이용해 담고
				dto.setId(rs.getString("id"));
				dto.setPassword(rs.getInt("password"));
				dto.setNickName(rs.getString("nickname"));
				//회원 한 명의 정보가 담긴  MemberDto 객체의 참조값을 
				//ArrayList 객체에 누적 시키기
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
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return list;
	}
	public LoginDto getData(String id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; 
		LoginDto dto=null;
		try {
			conn = new DBConnect().getConn();
			//실행할 select문 구성하기
			String sql = "select id,password,nickname"
					+ " from login"
					+ " where id=?";
			pstmt = conn.prepareStatement(sql);
			//?에 값 바인딩하기
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			//ResultSet 객체에서 필요한 값 얻어내기
			while (rs.next()) {
				//회원정보를 담을 객체 생성
				dto=new LoginDto();			//dto를 생성하지 않을때 NullPointException 이 발생함
				//setter 메소드를 이용해서 dto 에 회원정보 저장
				dto.setId(id);
				dto.setPassword(rs.getInt("password"));
				dto.setNickName(rs.getString("nickname"));
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
					pstmt.close();
			} catch (Exception e) {
			}
		}
		return dto;
	}
	public boolean insert(LoginDto dto) {
		Connection conn=null;
		PreparedStatement pstmt=null;
		int flag=0;
		try {
			conn=new DBConnect().getConn();
			String sql="insert into login"
					+ " (id,password,nickname)"
					+ " values(?, ?, ?)";		
			pstmt=conn.prepareStatement(sql);		
			pstmt.setString(1, dto.getId());		
			pstmt.setInt(2, dto.getPassword());	
			pstmt.setString(3, dto.getNickName());	
			flag=pstmt.executeUpdate();				//Exception이 발생하는 곳. 발생하면서 실행순서가 catch로 넘어가서 수행하고 finally 수행
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt!=null)pstmt.close();
				if(conn!=null)conn.close();
			}catch(Exception e) {}
		}
		if(flag>0) {	//성공
			return true;
		}else {			//실패
			return false;
		}
	}
	
}
