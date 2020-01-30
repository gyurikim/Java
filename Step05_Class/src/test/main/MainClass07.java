package test.main;

import java.util.Random;

public class MainClass07 {
	public static void main(String[] args) {
		/*
		 * 랜덤한 숫자 만들기 : (0 ~ 100)사이 에서 1개를 얻어내서 콘솔창에 띄우기
		 */
		int a = new Random().nextInt(101);
		System.out.println(a);

		// 랜덤 객체를 생성하고 참조값을 random type지역변수 ran 에 담기
		Random ran = new Random();
		int b = ran.nextInt(101);
		System.out.println(b);
		
		System.out.println("a+b = " + (a + b));
	}
}
