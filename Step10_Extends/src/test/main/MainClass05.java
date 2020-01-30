package test.main;

import test.mypac.HandPhone;
import test.mypac.SmartPhone;

public class MainClass05 {
	public static void main(String[] args) {
		SmartPhone p1=new SmartPhone();
		p1.doInternet();
		//오버라이드 되서 출력
		p1.takePicture();
		
		HandPhone p2= new HandPhone();
		//원래대로 출력
		p2.takePicture();
	}
}
