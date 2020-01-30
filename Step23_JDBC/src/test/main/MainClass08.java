package test.main;

import java.util.HashMap;
import java.util.Map;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MainClass08 {
	public static void main(String[] args) {
		// 추가할 멤버의 정보
		int num = 7;
		String name = "돼지";
		String addr = "독산동";
		// 3개의 정보를 HashMap 객체에 담기
		Map<String, Object> map = new HashMap<String, Object>();
		// 객체를 담아보세요
		map.put("num", num);
		map.put("name", name);
		map.put("addr", addr);

		//
		MemberDto dto = new MemberDto(num, name, addr);

		MemberDao dao = new MemberDao();

		// 세개의 insert가 오버로딩이 되어있다
		// dao.insert(num, name, addr);
		// dao.insert(map);
		// dao.insert(dto);
		
		// insert()메소드를 호출해서 회원정보 추가 성공여부를 불리안 타입으로 리턴받는다
		boolean isSuccess = dao.insert(dto);
		if (isSuccess) {
			System.out.println("회원정보를 추가했습니다");
		} else {
			System.out.println("회원정보 추가 실패");
		}
	}
}
