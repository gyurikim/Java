package test.main;

import java.util.ArrayList;
import java.util.List;

public class MainClass01 {
	public static void main(String[] args) {
		//String type  을 담을수 있는 가변 배열객체 생성해서 참조값을 변수에 담기
		List<String> names=new ArrayList<>();
		names.add("김구라");
		names.add("해골");
		names.add("원숭이");
		
		//배열의 방의 크기 참조
		int size=names.size();
		
		//0번방에 저장된 참조값 얻어오기
		String name0=names.get(0);
		
		//1번방 없애기(삭제하기)
		names.remove(1);
		
		//모든 방 없애기(삭제하기)
		names.clear();
		
	}
}




