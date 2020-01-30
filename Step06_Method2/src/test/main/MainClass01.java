package test.main;

import test.mypac.MyUtil;
import test.mypac.Pen;

public class MainClass01 {
	public static void main(String[] args) {
		//날씨가 궁금하다면
		MyUtil.showWeather();
		new MyUtil().printWeather();
		String result=new MyUtil().getWeather();
		System.out.println(result);
		
		new MyUtil().getPen().write();
		
		Pen p= new MyUtil().getPen();
		p.write();
		
	}
}
