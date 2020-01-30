package test.main;

public class MainClass06 {
	public static void main(String[] args) {
		//final을 붙이면 변수를 상수화 시키기 때문에 값이 바뀔 가능성이 사라진다.
		final String myName="김구라";
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				System.out.println("새로운 스레드가 시작되었습니다");
				//바깥쪽에 정의된 지역변수 final 상수만 참조!!!
				System.out.println("myName : "+myName);
			}
		}).start();
		//myName="해골";
	}
}
