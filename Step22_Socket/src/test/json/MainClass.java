package test.json;

import org.json.JSONArray;

public class MainClass {
	public static void main(String[] args) {
		JSONArray jsonArr=new JSONArray();
		jsonArr.put("김구라");
		jsonArr.put("해골");
		jsonArr.put("원숭이");
		//JSONArray 객체안에 있는 정보를 문자열로 얻어내기
		String result1=jsonArr.toString();
		System.out.println(result1);
		
		
	}
}
