package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		// showNum()메소드를 호출하는 코드를 작성해보시오
		MainClass03.showNum(10);

		// showNum()메소드를 호출할떄 a변수 안에있는 값을 전달해 보세용~^^
		int a = 999;
		MainClass03.showNum(a);
	}

	public static void showNum(int num) {
		System.out.println("num : " + num);
	}
}
