package test.main;

/*
 * [wrapper class]
 * - 기본 데이터 타입을 참조 데이터 타입으로 포장하고 싶을떄 사용하는 클래스
 * - 기본 데이터 타입에 관련된 메소드도 내장되어 있다
 * 
 * Byte, Short, Integer ,Long
 * Float, Double
 * Character, Boolean
 */
public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main()메소드가 시작되옸습니다");
		int num = 10;
		// 정수 11을 객체형으로 선언하기
		Integer num2 = 11;

		// 기본데이터 타입과 참조데이터 타입의 산술연산기능이 자유롭게 가능하다
		int result = num + num2;
		Integer result2 = num * num2;
		System.out.println(result);
		System.out.println(result2);
	}
}
