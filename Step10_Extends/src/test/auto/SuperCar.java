package test.auto;

public class SuperCar extends Car{
	//Engine 객체를 생성자의 인자로 전달받는 생성자
	public SuperCar(Engine engine) {
		//부모 생성자에 전달하기(바로, 제일먼저, 가장 첫줄에 작성해야 한다)
		super(engine);		//new Car(engine);
							//super()는 부모생성자를 의미한다.
	}
	@Override
	public void drive() {
		// TODO Auto-generated method stub
		//super.drive();
		if(this.engine==null) {
			System.out.println("엔진객체가없어서 못 달려요");
		}else {
			System.out.println("겁나 빠르게 달려요");
		}
		
	}
}
