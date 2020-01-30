package test.main;

import test.mypac.Weapon;

public class MainClass04 {
	// Weapon type의 static 필드
	static Weapon w2 = new Weapon() {
		@Override
		public void attack() {
			System.out.println("누구를 떄려볼까용");
		}
	};

	public static void main(String[] args) {
		// Weapon 추상클래스 type의 참조값을 익명의 local innerClass를 이용해서 얻어내기
		Weapon w1 = new Weapon() {
			@Override
			public void attack() {
				System.out.println("내맘대로 공격할꺼지롱~~메롱");
			}
		};

		w1.prepare();
		w1.attack();

		w2.prepare();
		w2.attack();
	}
}
