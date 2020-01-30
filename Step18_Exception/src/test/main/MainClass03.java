package test.main;

public class MainClass03 {
	public static void main(String[] args) {
		/*
		 * 1~10까지 출력을 하고싶다. 단, 1초에 1번씩
		 */

		try {
			for (int i = 0; i < 10; i++) {
				System.out.println(i + 1);
				Thread.sleep(1000);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
