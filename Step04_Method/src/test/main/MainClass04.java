package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		MainClass04.showSum(3, 5);
		int a = 12;
		int b = 15;
		MainClass04.showSum(a, b);

		int c = 16;
		MainClass04.showSum(c, c);
	}

	// 전달된 두개의 인수를 더해서 콘솔창에 띄우는 메소드
	public static void showSum(int num1, int num2) {
		int sum = num1 + num2;
		System.out.println("num1 + num2 = " + sum);
	}
}
