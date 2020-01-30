package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		// 메소드안에서 클래스 정의?? 가능하다( local inner class)
		class Coffee {
			public void eat() {
				System.out.println("냠냠~");
			}
		}
		// 객체 생성가능?
		Coffee c = new Coffee();
		c.eat();
	}
}
