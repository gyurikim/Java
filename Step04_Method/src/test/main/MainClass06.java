package test.main;

// 다른 패키지에 있는 클래스를 불러오고 싶다면 import를 사용해야한다.
import test.mypac.YourUtil;

public class MainClass06 {
	// run했을때 실행순서가 시작되는 특별한 main() 메소드
	public static void main(String[] args) {
		// 프로그래밍의 목적 > 파일을 다운로드하고, 업로드하기
		YourUtil.fileUp();
		YourUtil.fileDown();
	}
}
