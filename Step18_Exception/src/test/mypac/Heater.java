package test.mypac;

public class Heater {
	//생성자에서도 예외가 throw 될 수 있다
	public Heater() throws InterruptedException {
		Thread.sleep(5000);
		System.out.println("예열이 끝났습니다");
	}
	
	public void heat() {
		System.out.println("난방을 시작합니다");
	}
	public void off() {
		System.out.println("난방을 종료합니다");
	}
}
