package test.main;

import java.util.HashMap;

import test.mypac.Pen;

public class MainClass06 {
	public static void main(String[] args) {
		/*
		 * 1. Pen 객체를 담을 수 있는 HashMap 객체를 생성해서 참조값을 pens 라는 지역변수에 담아보세요
		 */
		HashMap<String, Pen> pens = new HashMap<>();

		/*
		 * 2. pens 객체에 Pen 객체를 3개 생성해서 담아보세요
		 *  단, 담을때 key 값은 "red_pen", "green_pen", "blue_pen"으로 담아보세요
		 */
		pens.put("red_pen", new Pen("red"));
		pens.put("green_pen", new Pen("green"));
		Pen p1=new Pen("blue");
		pens.put("blue_pen", p1);
		
		/*
		 * 3. pens에 들어있는 Pen 객체의 참조값불러오기
		 * Object type이 아닌 Pen type이기 때문에 따로 캐스팅해주지 않아도 오류나지 않는다
		 */
		Pen pen1=pens.get("red_pen");
		Pen pen2=pens.get("green_pen");
		Pen pen3=pens.get("blue_pen");
		
		/*
		 * 4. 테스트로 Pen객체의 메소드 호출해보기
		 */
		pen1.write();
		pen2.write();
		pen3.write();
		
		//변수에 저장하지 않고 직접 Pens를 이용해서 Pen 객체를 참조해서 메소드 호출하기
		pens.get("red_pen").write();
		pens.get("green_pen").write();
		pens.get("blue_pen").write();
	}
}
