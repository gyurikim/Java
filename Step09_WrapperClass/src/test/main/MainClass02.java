package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		String strNum = "999";
		String strNum2 = "10.1";
		// integer 클래스의 static 메소드를 이용해서 숫자형태의 문자열을 실제 정수로 바꾸기
		int result = Integer.parseInt(strNum);

		int sum = Integer.parseInt(strNum) + 5;
		System.out.println(sum);

		//Double 클래스의 static 메소드를 이용해서 숫자형태의 문자열을 실제 실수로 바꾸기
		double result2 = Double.parseDouble(strNum2);
		double sum2 = Double.parseDouble(strNum2) + 10.2;
		System.out.println(sum2);
		
		//정수를 문자열로 만들기
		String a=Integer.toString(100);
		System.out.println(a);
		
		//실수를 문자열로 만들기
		String b=Double.toString(10.1);
		System.out.println(b);
	}
}
