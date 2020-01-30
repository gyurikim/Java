package test.main;

/*
 * [JAVA 참조 데이터 타입]  
 *  string type
 *   - 문자열을 다룰때 사용하는 데이터 type 이다
 */
public class MainClass05 {
	public static void main(String[] args) {
		// 스트링타입은 사물함에 저장되는 형식이여서 id값을 갖는다
		String name = "김구라";
		String msg = "안녕하세요";
		String fortune = "동쪽으로 가면 귀인을 만나요";
		String fortuneToday = "행신동으로 가면 반장님을 만나요!";

		String tmp1 = name; // name안에 들어있는 참조값을 tmp1 변수에 대입하기(참조값 복사)
		String tmp2 = msg;

		int num = 10;
		// num 안에 들어있는 value를 tmp3 변수에 대입하기(value 복사)
		int tmp3 = num;
		
		//string type 객체의 메소드 호출하기
		int a=tmp1.length();
	}
}
