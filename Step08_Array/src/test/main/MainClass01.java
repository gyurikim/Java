package test.main;

/*
 * 배열
 * - java 배열을 한번 만들면 방의 갯수를 늘이거나 줄일수 없다.
 * - 배열 리터럴을 이용해서 만들거나 new라는 예약어를 이용해서 배열객체를 생성할수 있다 
 * - 배열도 참조 데이터 타입이다
 */
public class MainClass01 {
	public static void main(String[] args) {
		System.out.println("main()메소드가 시작되었습니다");
		// 배열 리터럴을 이용해서 int type 5개를 담을 수 있는 배열 만들기
		//생성하자마자 값을 채워주고 싶을때 사용
		int[] nums = { 10, 20, 30, 40, 50 };
		
		//new 예약어를 이용해서 int type5개를 담을수 있는 배열 만들기
		//일단 배열을 생성시켜놓고 나중에 값을 채워 넣어줄때 사용
		int[] nums2=new int[5];
		nums2[0]=10;
		nums2[1]=20;
		nums2[2]=30;
		nums2[3]=40;
		nums2[4]=50;
	}
}
