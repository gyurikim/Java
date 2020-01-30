package test.mypac;

public class MyPhone extends SmartPhone {
	// Phone 클래스에 정의된 call메소드 재정의 하기
	@Override
	public void call() {
		// TODO Auto-generated method stub
		// super.call();
		System.out.println("전화를 걸려다가 꼴밤을 떄려요");
	}

	@Override
	public void takePicture() {
		// TODO Auto-generated method stub
		// super.takePicture();
		System.out.println("몬난 사진을 찍어서 공유해요");
	}
}
