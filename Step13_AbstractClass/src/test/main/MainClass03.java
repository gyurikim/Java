package test.main;

import test.mypac.Weapon;

public class MainClass03 {

	// Weapon 추상클래스를 상속받은 innerClass
	class AWeapon extends Weapon {
		@Override
		public void attack() {
			System.out.println("A 형태로 공격해요!");
		}
	}

	public static void main(String[] args) {

		// Weapon 추상클래스를 상속받은 자식 local innerClass
		class BWeapon extends Weapon {
			@Override
			public void attack() {
				System.out.println("B 형태로 공격해요~");
			}
		}

		// non-static innerClass를 이용해서 객체생성
		Weapon w1 = new MainClass03().new AWeapon();
		w1.prepare();
		w1.attack();

		// local innerClass를 이용해서 객체생성
		Weapon w2 = new BWeapon();
		w2.prepare();
		w2.attack();
	}
}
