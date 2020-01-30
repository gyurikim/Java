package test.json;

import java.util.HashMap;
import java.util.Map;

import org.json.JSONObject;

public class MainClass9 {
	public static void main(String[] args) {
		int num=1;
		String name="김구라";
		String addr="노량진";
		
		JSONObject obj=new JSONObject();
		obj.put("num", num);
		obj.put("name", name);
		obj.put("addr", addr);
		//.toString() 메소드를 호출하면  JSon type으로 변환된다
		String json2=obj.toString();
		
		Map<String, Object> map=new HashMap<>();
		map.put("num", 2);
		map.put("name", "해골");
		map.put("addr", "행신동");
		
		JSONObject obj2=new JSONObject(map);
		String json3=obj2.toString();
	}
}
