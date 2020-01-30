package test.main;

import test.mypac.GuraUtil;

public class MainClass09 {
	public static void main(String[] args) {
		/*
		 * 1~45 사이의 랜덤한 정수를 5번 콘솔창에 출력하시오
		 */
		for (int i = 0; i < 5; i++) {
			int tmp = GuraUtil.ran.nextInt(45) + 1;
			GuraUtil.out.println(tmp);
		}
	}
}
