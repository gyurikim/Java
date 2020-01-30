package test.main;

import java.util.List;

import test.member.dao.MemberDao;
import test.member.dto.MemberDto;

public class MainClass09 {
	public static void main(String[] args) {
		MemberDao dao=new MemberDao();
		//회원 한명을 추가하려면?
		MemberDto dto=new MemberDto(8,"개다리","용인");
		dao.insert(dto);
		//회원 한명의 정보를 수정 하려면?
		MemberDto dto2=new MemberDto(7,"김규리","안양");
		dao.update(dto2);
		
		//회원 한명의 정보(7번 회원)를 삭제 하려면?
		dao.delete(7);
		
		//회원한명의 정보를 얻어오려면(1번회원)
		MemberDto dto3=dao.getData(1);
		
		//회원전체목록을 얻어오려면?
		List<MemberDto> list = dao.getList();
	}
}
