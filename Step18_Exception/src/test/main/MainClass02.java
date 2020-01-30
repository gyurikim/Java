package test.main;

/*
 * Exception 의 종류
 * 모든 예외는 부모로 Exception을 상속받고있다
 * 따라서 어떤 예외가 발생할지 잘 모를때에는 Exception type으로 정의하면된다.
 * 
 * 1. 실행시에 발생하는 Exception 
 * - RuntimeException 을 상속받은 예외 type이다
 * - try~catch 블럭을 작성해도 되고 안해도 된다
 * 
 * 2. 컴파일시에 발생하는 Exception 
 * - RuntimeException 을 상속받지 않은 예외type이다
 * - 반드시 try~catch 블럭을 작성해야한다
 */
public class MainClass02 {
	public static void main(String[] args) {
		System.out.println("main메소드가 시작되었습니다");

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace(); // 일정시간동안 잡아두고있기 >> 무조건 try-catch구문을 사용해야한다!
		}

		System.out.println("main메소드가 종료돠었습니다");
	}

}
