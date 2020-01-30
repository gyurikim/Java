package test.mypac;

public class Acorn {
	// 동일한 이름의 메소드가 오버로딩(다중정의)되어있다.
	public void study() {
		System.out.println("study() 호출됨");
	}

	public void study(int num) {
		System.out.println("study(int num) 호출됨");
	}

	public void study(String name) {
		System.out.println("study(String name) 호출됨");
	}
}
