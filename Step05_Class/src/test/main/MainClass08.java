package test.main;

import java.util.Random;

public class MainClass08 {
	public static void main(String[] args) {
		/*
		 * 1~45 사이의 랜덤한 정수를 5번 콘솔창에 출력하시오
		 */
		int ran1 = new Random().nextInt(45) + 1;
		System.out.println(ran1);

		int ran2 = new Random().nextInt(45) + 1;
		System.out.println(ran2);

		int ran3 = new Random().nextInt(45) + 1;
		System.out.println(ran3);

		int ran4 = new Random().nextInt(45) + 1;
		System.out.println(ran4);

		int ran5 = new Random().nextInt(45) + 1;
		System.out.println(ran5);

		Random ran = new Random();
		for (int i = 0; i < 5; i++) {
			int result = ran.nextInt(45) + 1;
			System.out.println(result);
		}

	}
}
