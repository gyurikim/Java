package test.main;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 영어사전
		 * apple : 사과
		 * ball : 공 
		 * money : 돈 
		 * game : 놀이 
		 * book : 책
		 */
		Map<String, String> dic = new HashMap<String, String>();
		
		dic.put("apple", "사과");
		dic.put("ball", "공");
		dic.put("money", "돈");
		dic.put("game", "놀이");
		dic.put("book", "책");
		
		//키보드로부터 입력받을수있는 scanner객체 생성하기
		//system/in은 키보드와 연결된 InputStream 객체이다.
		Scanner scan = new Scanner(System.in);
		
		while(true) {
			System.out.print("찾을 단어 입력 (종료는 q입력) : ");

			// 문자열 한줄 입력받기
			String word = scan.nextLine();
			
			//문자열의 내용이 같은지 여부는 .equals() 메소드를 이용해야한다
			if (word.equals("q")) {
				break;
			}
			
			// 단어찾기
			String mean = dic.get(word);

			System.out.println(word + "의 뜻은 " + mean + " 입니다.");
			
			
		}
		
		

		System.out.println("main메소드가 종료됩니다");
	}
}
