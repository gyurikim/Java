package test.mypac;

public class Test {
	//non static 필드
	public String name1="김구라";
	
	//non static 메소드
	public void method1() {
		
	}
	//내부 클래스 
	class A{
		public void inner() {
			String a=name1;
			method1();
		}
	}
}





