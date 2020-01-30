package test.main;

import test.mypac.Pen;

public class MainClass04 {
	public static void main(String[] args) {
		// 1. pen 객체를 3개 생성해서 pen1,2,3이라는 지역변수에 담고
		Pen pen1 = new Pen("orange-red");
		Pen pen2 = new Pen("baby-pink");
		Pen pen3 = new Pen("blue-green");

		// 2. pen객체를 저장할수있는 방 3개짜리 빈배열 객체를 생성해서 참조값을 pens라는 이름의 지역변수에 담아보세여
		Pen[] pens = new Pen[3];

		// 3. 위에서 생성한 배열에 pen1,2,3에 저장된 참조값을 배열의 0,1,2방에 순서대로 담아보세여
		pens[0] = pen1;
		pens[1] = pen2;
		pens[2] = pen3;

		// 4-1. 배열안에 들어있는 pen객체의 참조값을 이용해서 write()메소드를 호출해보세요
		pens[0].write();
		pens[1].write();
		pens[2].write();

		// 4-2. 지역변수에 들어있는 pen객체의 참조값을 이용해서 write()메소드를 호출해보세요
		// pen1.write();
		// pen2.write();
		// pen3.write();

		// 5. 4번에서 했던 작업을 for문 활용해서 해 보세여
		for (int i = 0; i < pens.length; i++) {
			pens[i].write();
		}

	}
}
