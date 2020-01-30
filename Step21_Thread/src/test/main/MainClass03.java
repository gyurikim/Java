package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		System.out.println("main메소드가 시작되었습니다");

		// 익명의 local innerClass 이용하기
		new Thread() {
			public void run() {
				System.out.println("새로운 스레드가 시작됩니다");
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("새로운 스레드가 종료됩니다");
			}
		}.start();

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



