package test.main;

public class MainClass02 {
	public static void main(String[] args) {
		// 국어점수
		int kor = 95;
		// 영어점수
		int eng = 100;

		// 국어점수와 영어점수의 평균울 규해서 콘솔창에 출력하고 싶다면?
		int sum = kor + eng;
		// 정수 나누기 정수는 정수값만 나오기 때문에 소숫점까지 알고싶다면 둘중하나는 실수로 만들어줘야한다.
		float ave = sum / 2f;
		System.out.println("평균은 " + ave + " 입니다.");
	}
}
