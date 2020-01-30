package test.main;

import java.util.HashMap;
import java.util.Map;

import test.member.dao.TodoDao;
import test.member.dto.TodoDto;

public class Todo {
	public static void main(String[] args) {
		// 추가할 멤버의 정보
		int num = 1;
		String list = "집에가기";
		String r_u_success = "실행전";
		String e_time = "6시30분";

		// 4개의 정보를 HashMap 객체에 담기
		Map<String, Object> map = new HashMap<String, Object>();
		// 객체를 담아보세요
		map.put("num", num);
		map.put("list", list);
		map.put("r_u_success", r_u_success);
		map.put("e_time", e_time);

		TodoDto dto = new TodoDto(num, list, r_u_success, e_time);

		TodoDao dao = new TodoDao();
		// insert()메소드를 호출해서 회원정보 추가 성공여부를 불리안 타입으로 리턴받는다
//		dao.select(dto);
//		boolean isSuccess = dao.insert(dto);
//		boolean isSuccess = dao.update(dto);
//		boolean isSuccess = dao.delete(dto);
//		if (isSuccess) {
//			System.out.println("회원정보를 추가했습니다");
//		} else {
//			System.out.println("회원정보 추가 실패");
//		}

	}
}
