package test.main;

import test.mypac.MyUtil;
import test.mypac.Pen;

public class MainClass04 {
	public static void main(String[] args) {
		MyUtil mu = new MyUtil();
		// MyUtil 클래스에 정의된 showNum 메소드 호출해보세요
		mu.showNum(1);

		// MyUtil 클래스에 정의된 showInfo 메소드 호출해보세요
		mu.showInfo(10, "규링");

		// MyUtil 클래스에 정의된 usePen 메소드 호출해보세요
		Pen p = new Pen();
		mu.usePen(p);
	}
}
