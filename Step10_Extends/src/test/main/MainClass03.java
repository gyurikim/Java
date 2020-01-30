package test.main;

import test.mypac.HandPhone;
import test.mypac.Phone;
import test.mypac.SmartPhone;

public class MainClass03 {
	public static void main(String[] args) {
		// p1에는 SmartPhone 객체의 참조값이 들어있다
		SmartPhone p1 = new SmartPhone();

		SmartPhone p2 = p1;
		HandPhone p3 = p1;
		Phone p4 = p1;
		Object p5 = p1;
		/*
		 * Object type을 casting 연산자(Phone)을 이용해서
		 * Phone type으로 강제 형 변환을 한 다음 Phone type변수에 담을 수 있다.
		 */
		Phone p6 = (Phone) p5;
		p6.call();
		
		//HandPhone type으로 케스팅
		HandPhone p7=(HandPhone)p5;
		//SmartPhone type으로 케스팅
		SmartPhone p8=(SmartPhone)p5;
	}
}
