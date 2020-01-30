package test.mypac;

public class Dragon {
	// 에너지 체력
	public int energy = 200;
	// 공격력
	public static int attDemage = 20; // 공통으로 참조하는 변수이므로 static 붙여주기

	// 공격하는 메소드
	public void attack() {
		System.out.println(Dragon.attDemage + "의 데미지 공격을 해요");	//static필드는 .찍어서 매소드 호출 
	}

	// 움직이는 메소드
	public void move() {
		System.out.println("움직여요");
	}

	// 데미지를 입는 메소드(에너지 줄이기)
	public void demage() {
		this.energy -= 10; 		//일반 필드는 this로 매소드 호출 
	}
}
