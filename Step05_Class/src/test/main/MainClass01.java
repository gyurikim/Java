package test.main;

//다른 패키지에 들어있는 car 클래스 참조
import test.mypac.Car;

public class MainClass01 {
	public static void main(String[] args) {
		// 객체를 생성하면 다시 사용할 방법이 없음......일회용임
		// new 를 붙일때마다 새로운 클래스가 생겨남
		// car type 객체의 drive() 메소드 호출하기
		new Car().drive();
		// car type 객체의 필드에 값 대입하기
		String a = new Car().brand = "Tesla";
		System.out.println(a);

		// car type 객체의 필드에 저장된 값 읽어오기
		String b = new Car().brand;
		System.out.println(b);
	}
}
