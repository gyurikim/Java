package test.main;

public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main메소드가 시작되었습니다");
		//새로운 스레드 시작 시키기
		new CounterThread().start();//간접적으로 
		draw();
		new CounterThread().start();//간접적으로 
		new CounterThread().start();//간접적으로 
		
		System.out.println("main메소드가 종료됩니다");
	}

	public static void draw() {
		System.out.println("5초동안 그림을그려요");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/*
	 * - 새로운 작업단위 (thread) 만들기
	 *  1. Thread 클래스를 상속받은 클래스를 정의한다
	 *  2. run()메소드를 오버라이드한다
	 *  3. 만든 클래스를 이용해서 객체를 생성하고 start()메소드를 호출하면 생성된 객체의 run() 메소드에서 새로운 작업단위가 시작된다
	 *  
	 *  동시동작 하는것처럼 보이지만 일정시간에 진행되는 스레드는 오직 하나이다. 코드를 빠르게 처리하기위해서 사용하는것은 아니다 
	 *  스레드 사용이유 > 멀티쓰레드는 한 프로그램 내에서 여러개의 동작이 동시에 일어나는 겁니다. 독립적으로 코드를 사용하기위해서 쓰는것이다
	 */
	static class CounterThread extends Thread {
		@Override
		public void run() {
			int count = 0;
			System.out.println("새로운 스레드가 시작됨");
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				count++;
				System.out.println(count);
				if(count==10)break;
			}
		}
	}
}
