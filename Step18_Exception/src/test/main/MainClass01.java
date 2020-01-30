package test.main;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainClass01 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		// Exception이 발생할수 있는 code블럭을 try { }안에 위치시킨다
		try {
			System.out.print("나눌수 입력(정수) : ");
			int num1 = scan.nextInt();

			System.out.print("나누어 지는수 입력(정수) : ");
			int num2 = scan.nextInt();

			int result = num2 / num1;
			System.out.println(result);
		} catch (InputMismatchException ime) { // catch(예외type 변수) { }
			System.out.println("숫자형태가 아닙니다");
			ime.printStackTrace();// stack에서 일어난 오류정보를 출력해라
			System.out.println(ime.getMessage());
		} catch (ArithmeticException ae) { // ArithmeticException 대신에 Exception type으로 받아도 가능하다
			System.out.println("0으로 나눌수 없습니다");
			ae.printStackTrace();
			System.out.println(ae.getMessage());
		}

		System.out.println("main메소드가 종료됩니다.");

	}
}
