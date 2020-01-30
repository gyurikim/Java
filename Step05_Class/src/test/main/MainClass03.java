package test.main;

import test.mypac.Car;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * car type 객체를 3개 생성해서 참조값을 c1,c2,c3를 지역변수에 담아보세요
		 */
		Car c1 = new Car();
		Car c2 = new Car();
		Car c3 = new Car();
		System.out.println(c1 == c2 ? "true" : "false");

		/*
		 * c1,c2,c3안에 있는 참조값을 이용해서 각자 좋아하는 자동파브랜드를 필드에 담아보세요
		 */
		c1.brand = "벤츠";
		c2.brand = "아우디";
		c3.brand = "테슬라";

		/*
		 * c1,c2,c3안에있는 참조값을 이용해서 showBrand()메소드를 호출해보세여
		 */
		c1.showBrand();
		c2.showBrand();
		c3.showBrand();
	}
}
