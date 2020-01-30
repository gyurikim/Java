package test.main;

public class MainClass04 {
	public static void main(String[] args) {
		System.out.println("main메소드가 시작되었습니다");

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("새로운 스레드가 시작되었습니다");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.out.println("새로운 스레드가 종료되었습니다");
			}
		});
		t.start();
		draw();

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

}
