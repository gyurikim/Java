package test.main;

public class MainClass01 {
	// run 했을때 실행순서가 시작되는 특별한 메소드
	public static void main(String[] args) {
			/*
			 * [static이 붙어있는 메소드를 호출하는 방법] 
			 * static 메소드를 가지고있는
			 *  >> 클래스명.메소드명() 
			 *  과 같은 형식으로 호출해야한다.
			 *
			 * 동일한 클래스 내에 있는 메소드인 경우에는 클래스 명 생략가능
			 */
		System.out.println("main() 메소드 시작됨");
		MainClass01.gura(); // 같은 클래스 내에서는 MainClass01.생략가능
		System.out.println("main() 메소드 종료됨");
	}

	public static void gura() {
		System.out.println("gura() 메소드 시작됨");

		System.out.println("gura() 메소드 종료됨");
	}
}
