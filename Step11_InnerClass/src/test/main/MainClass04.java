package test.main;

import test.mypac.Academy;

public class MainClass04 {
	public static void main(String[] args) {

		/*
		 * 1. Academy클래스의 teaching() 메소드를 재정의 하고싶다. 
		 * 2. teaching() 메소드 하나떄문에 파일을 새로 만들기는싫다.
		 * 3. 내부클래스로도 만들기 싫다면...? 
		 * 4. local 내부 클래스로 만들고 싶은데 새로운 type을 만들어 내기도 싫다
		 */
//		MyAcademy ma = new MyAcademy();
//		ma.teaching();

//		class MyAcademy extends Academy{
//			@Override
//			public void teaching() {
//				// TODO Auto-generated method stub
//				// super.teaching();
//				System.out.println("스파르타식으로 학셍들을 가리켜쵸");
//			}
//		}
//		MyAcademy ma=new MyAcademy();
//		ma.teaching();

		Academy ac=new Academy() {
			@Override
			public void teaching() {
				// TODO Auto-generated method stub
				//super.teaching();
				System.out.println("스파르타식으로 학셍들을 가리키죵");
			}
		};
		ac.teaching();
	}
}
