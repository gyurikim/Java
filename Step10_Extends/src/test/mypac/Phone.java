package test.mypac;

/*
 * [다형성 : 다양한 타입을 지닐수 있다]
 * extends 클래스명을 작성하지 않으면 자동으로 extends Object가 된다
 * 즉 자동으로 Object 클래스를 상속받게 되는것이다
 * 
 * phone은 object의 자식클래스이고, object의 상속된다
 * 부모타입으로 클래스를 정의하면 유지보수가 편리해진다
 */
public class Phone extends Object {
	// public Phone() {} >>default 생성자
	// 전화하는 기능
	public void call() {
		System.out.println("전화를 걸어요!");
	}
}
