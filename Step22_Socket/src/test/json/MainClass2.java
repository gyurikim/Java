package test.json;

import org.json.JSONObject;

public class MainClass2 {
	public static void main(String[] args) {
		JSONObject jsonobj=new JSONObject();
		jsonobj.put("num", 1);
		jsonobj.put("name", "김구라");
		jsonobj.put("isMan", true);
		
		String result=jsonobj.toString();
		System.out.println(result);
		
	}
}
