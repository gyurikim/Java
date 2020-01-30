package test.member.dto;

/*
 * Data Transfer Object
 * 설계이유
 * 		해쉬맵은 캐스팅을 해주어야하기 떄문에 사용을 잘 안하고 
 * 		보다 간편하게 여러가지의 데이터를 하나의 객체에 담고싶어서 DTO를 설계한다!!
 */
public class MemberDto {
	// 데이터를 저장할 필드를 private로 선언
	private int num;
	private String name;
	private String addr;

	// 디폴트 생성자
	public MemberDto() {
	}

	// 모든 필드의 값을 생성자의 인자로 전달받는 생성자 generate!
	public MemberDto(int num, String name, String addr) {
		super();
		this.num = num;
		this.name = name;
		this.addr = addr;
	}

	// 필드의 접근 메소드를 만든다(setter,getter 메소드) - 우클릭>소스>제너레이트 게터 앤 세터
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}

}
