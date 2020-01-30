package test.mypac;

/*
 * 클래스를 정의할때 final 예약을 붙이면 해당 클래스를 상속받는 자식클래스를 정의 할 수 없는 마지막 클래스
 * 즉, 종단클래스가 된다
 */
public final class Pen {
	public void write() {
		System.out.println("필기를 해요");
	}
}
