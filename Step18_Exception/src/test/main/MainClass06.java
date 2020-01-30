package test.main;

import java.util.InputMismatchException;
import java.util.Scanner;

import test.mypac.Heater;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 날씨가 춥다 어떻게 해야할까? > Heater를 키자
		 */
		Heater heater = null;// 비어있는 전역변수를 try 밖에서 정의하고
		try {
			heater = new Heater();// 참조값을 전역변수에 넣어주기
			heater.heat();// 난방을 따뜻하게

			Scanner scan = new Scanner(System.in);
			System.out.print("정수입력 : ");
			int num = scan.nextInt();
			System.out.println("입력한 정수 : " + num);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally { // 예외가 발생해도 무조건 실행되는 블럭 >>마무리 작업은 이 블럭에서 하면된다
			heater.off();// 따뜻해지면 히터를 꺼요
		}
	}
}
