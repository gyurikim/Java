package test.main;

import test.mypac.YourWeapon;

public class MainClass02 {
	public static void main(String[] args) {
		//다른공격을 하는 Weapon type의 참조값을 얻어내서 
		//.prepare() .attack()메소드를 참조해보세요
		YourWeapon w=new YourWeapon();
		w.prepare();
		w.attack();
	}
}
