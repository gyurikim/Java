package test.main;

import test.mypac.Car;

public class MainClass04 {
	public static void main(String[] args) {
		// car type의 참조값을 담을수있는 car1이라는 지역변수 만들기
		Car car1 = null;
		// car1 에 car 객체의 참조값을 담아보세요
		car1 = new Car();
		
		Car car2=null;
		//car2에 참조값이 없기 때문에 실행하면 에러가 발생한다
		car2.drive();
	}

}
