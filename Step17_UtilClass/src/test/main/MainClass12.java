package test.main;

import java.util.ArrayList;
import java.util.List;
import test.dto.MemberDto;

public class MainClass12 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다");
		MemberDto dto1 = new MemberDto(1, "김구라", "노량진");
		MemberDto dto2 = new MemberDto(2, "해골", "행신동");
		MemberDto dto3 = new MemberDto();
		dto3.setNum(3);
		dto3.setName("원숭이");
		dto3.setAddr("상도동");

		// MemberDto 객체를 ArrayList객체에 순서대로 담아보세요
		List<MemberDto> members = new ArrayList<>();
		members.add(dto1);
		members.add(dto2);
		members.add(dto3);

		// MemberDto 객체에 들어있는 값 참조해보기
		int a = members.get(0).getNum();
		String b = members.get(1).getName();

		List<MemberDto> c = members;
		MemberDto d = members.get(0);
		String e = members.get(0).getAddr();
		int f = members.get(0).getAddr().length();
	}
}
