package test.main;

import test.mypac.Weapon;

public class MainClass05 {
	public static void main(String[] args) {
		// useWeapon메소드를 호출해보세요
		MainClass05.useWeapon(new Weapon() {
			@Override
			public void attack() {
				System.out.println("dfsdfsdfsdf");
			}
		});
	}

	public static void useWeapon(Weapon w) {
		w.prepare();
		w.attack();
	}
}
