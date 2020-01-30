package test.mypac;

public class MyUtil {
	public static void draw() {
		System.out.println("5초동안 그림을 그려요");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("그림그리기 완료!!");
	}
	
	public static void send() throws InterruptedException {
		System.out.println("5초동안 전송해요");
		Thread.sleep(5000);
		System.out.println("전송완료!!");
	}
}
