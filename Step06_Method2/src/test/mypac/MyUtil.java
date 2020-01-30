package test.mypac;

/*
 * 메소드를 만들때 고려해야할 상황
 *  1. 접근 지정자
 *  2. static  or  non-static
 *  3. return type
 *  4. 메소드명
 *  5. 메소드에 전달 받는 인자의 갯수와 데이터 type
 */
public class MyUtil {
	// 날씨를 콘솔창에 띄워보세요
	public static void showWeather() {
		System.out.println("오늘은 첫눈이와요!!");
	}

	// 날씨를 콘솔창에 띄워보세요
	public void printWeather() {
		System.out.println("오늘은 엄청 추워요!!!!!");
	}

	// 날씨를 string type으로 리턴하는 메소드
	public String getWeather() {
		// 날씨를 얻어오는 작업을 수행했다고 가정
		String msg = "오늘은 흐려요";
		// 날씨정보가 있는 string type을 리턴해주기
		return msg;
	}

	// pen객체를 리턴해주는 메소드
	public Pen getPen() {
		Pen p = new Pen();
		return p;
	}

	// 총을 발사하는 메소드
	public MyUtil fire() {
		System.out.println("빵야~!");
		MyUtil a= this;
		return a;
	}

	// 인자로 전달 받은 int type을 콘솔에 출력
	public void showNum(int num) {
		System.out.println("num=" + num);
	}

	// int type과 string type을 전달받은 메소드
	public void showInfo(int num, String name) {
		System.out.println("num=" + num + " name" + name);
	}

	// pen type을 전달받은 메소드
	public void usePen(Pen p) {
		p.write();
	}
}
