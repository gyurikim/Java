package test.main;

public class MainClass02 {
	public static void main(String[] args) {
//		MainClass02.showMsg(10);		showMsg에 값을 받아낼 변수타입 선언하기
//		MainClass02.showMsg('A');
//		MainClass02.showMsg("hello");
//		MainClass02.showMsg(10.2);
//		MainClass02.showMsg(true);

		// 메소드를 호출하면서 참조값을 바로 만들어서 전달하기
		MainClass02.showMsg("안녕하세요");
		MainClass02.showMsg("집에 얼른 가고싶다아아아");

		String str = "참 재미없어요ㅠ";
		// 메소드를 호출하면서 변수 안에있는 참조값을 전달하기
		MainClass02.showMsg(str);
	}

	public static void showMsg(String msg) {
		// 전달받은 내용 가공해서 출력하기
		String result = "[" + msg + "]";
		System.out.println(result);
	}
}
