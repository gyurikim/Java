package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		System.out.println("main 메소드가 시작되었습니다.");
		// 변수선언과 동시에 초기값 대입하기
		int num = 1;
		String name = "김구라";

		// 변수를 선언만 하기 >> 선언만 했을 경우 만들어지지 않는다!!!!!
		int num2;
		String name2;

		// 변수를 선언하고 초기값으로 기본값을 넣어주고 싶다면
		int num3 = 0;
		// 참조 데이터 타입에만 빈 공간을 의미하는 null을 집어넣을수 있다.
		String name3 = null;
		
		//빈 공간에 참조값 대입하기
		name3="원숭이";

		System.out.println("main메소드가 종료됩니다.");
	}
}
