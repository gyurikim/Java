package test.main;

import test.mypac.Car;

public class MainClass02 {
	public static void main(String[] args) {
		// data type은 클래스 명이 부여된다. 그러므로 참조 데이터 타입의 종류는 무수히 많다.
		Car c1 = new Car();

		// 달려요를 띄워야한다면
		c1.drive();

		// car type 객체의 field에 string type의 값을 넣어줘야 한다면
		c1.brand = "벤츠";
		// System.out.println(c1.brand);
		c1.showBrand();
	}

}
