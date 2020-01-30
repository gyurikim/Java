package test.mypac;
/*
 * 추상(abstract)클래스
 * - 구현되지 않은 추상메소드를 가질 수 있는 클래스이다
 * - abstract 예약어를 이용해서 만든다
 * - 생성자는 존재 하지만 단독으로 객체 생성은 불가하다
 * - 추상클래스 type의 참조값이 필요하면 추상클래스를 상속받은 자식 클래스를 이용해서 생성해야한다.
 * - 상속받은 자식클래스에서는 추상클래스에 있는 추상메소드를 반드시 오버라이드해야한다.
 */

//추상메소드를 하나라도 가지고 있는 클래스는 abstract 예약어를 붙여줘야한다
public abstract class Weapon {
	// 메소드
	public void prepare() {
		System.out.println("무기작동을 준비합니다");
	}

	/*
	 * 메소드를 호출했을떄 어떤 code 를 수행할지는 정해지지 않고 메소드의 형태만 정의된 메소드를 추상(abstract)메소드라고 한다.
	 * 추상메소드는 abstract 예약어를 붙여줘야한다.
	 */
	// 추상메소드
	public abstract void attack();
}
