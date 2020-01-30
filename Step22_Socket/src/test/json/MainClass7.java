package test.json;

import org.json.JSONArray;

public class MainClass7 {
	public static void main(String[] args) {
		//JSONArray type을 이용해서 콘솔창에 띄우기
		String info = "[10,20,30,40,50]";
		JSONArray arr = new JSONArray(info);
		
		for(int i=0;i<arr.length();i++) {
			System.out.println(arr.getInt(i));
		}
		
//		System.out.println(arr.getInt(1));
//		System.out.println(arr.getInt(2));
//		System.out.println(arr.getInt(3));
//		System.out.println(arr.getInt(4));

	}
}
