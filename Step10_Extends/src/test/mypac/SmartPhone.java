package test.mypac;

public class SmartPhone extends HandPhone {
	public void doInternet() {
		System.out.println("인터넷을 해요");
	}

	// 부모클래스(HandPhone)클래스에 정의된 메소드 오버라이드 하기
	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		// super를 지워도 되지만 어떠한 경우에는 다시 부모클래스를 불러와야 동작하는경우가 있다. 명확한 기준은 없다
		// super.takePicture();
		System.out.println("1000만 화소룰 찍어요오오오");
	}	
	
}
