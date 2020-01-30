package test.main;

import java.util.HashMap;

public class MainClass05 {
	public static void main(String[] args) {
		/*
		 * 회원 한명의 번호, 이름, 주소를 하나의 객체로 관리하고 싶다면?
		 */

		// new HashMap<String, Object>();
		// 데이터를 (key, value)쌍을 이뤄 저장하고
		HashMap<String, Object> mem = new HashMap<>();
		mem.put("num", 1);
		mem.put("name", "gura");
		mem.put("addr", "노량진");

		// 불러올때는 Object type으로 리턴되니 원래 데이터타입으로 casting해줘야한다
		int num1 = (int) mem.get("num");
		String name1 = (String) mem.get("name");
		String addr1 = (String) mem.get("addr");

		// 특정 key 값으로 저장된 데이터 삭제
		mem.remove("addr");
	}
}
