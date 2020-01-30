package test.mypac;

/*
 * 생성자(Constructor)
 * 
 * 1. 정의하지 않아도 default 생성자는 있다고 간주된다
 * 2. 생성자는 return type이 없고 클래스 명과 동일하다
 * 3. 객체를 생성(new)하는 시점에 한번만 호출된다
 * 4. 초기화 작업을 할게 있을때 생성자 안에서 하면된다
 * 5. 생성자는 다중정의 (overloading) 할 수도 있다
 * 6. 생성자를 하나라도  정의하면 default 생성자는 없어진다
 * 7. 생성자도 메소드와 마찬가지로 인자를 전달 받을 수 있다
 */
public class Student {
	// 필드생성
	private String name; // getter : & setter :

	// default생성자
	// 용도에 따라 다르게 생성자를 정의할수있다
	public Student() {
		System.out.println("Student() 생성자가 호출되었습니다");
	}

	// String type을 인자로 전달받는 생성자
	public Student(String name) {
		System.out.println("Student(String name) 생성자가 호출되었습니다");
		// 생성자의 인자로 전달받은 data를 필드에 저장하기
		// 생성된 인자를 필드에 저장해 놨다가 다음에 특정 메소드에서 사용된다
		this.name = name;
	}

	// 메소드 생성
	public void showInfo() {
		System.out.println("내이름은 :" + this.name + "입니다.");
	}
}
