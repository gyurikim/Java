package test.mypac;

public class MyWeapon extends Weapon {
	// 추상메소드 오버라이드가 강제되어있다
	@Override
	public void attack() {
		// TODO Auto-generated method stub
		System.out.println("반장님을 공격해요~");
	}

}
