package test.member.dto;

public class TodoDto {
	// 데이터를 저장할 필드를 private로 선언
	private int num;
	private String list;
	private String r_u_success;
	private String e_time;

	// 디폴트 생성자
	public TodoDto() {
	}

	public TodoDto(int num, String list, String r_u_success, String e_time) {
		super();
		this.num = num;
		this.list = list;
		this.r_u_success = r_u_success;
		this.e_time = e_time;
	}

	// 필드의 접근 메소드를 만든다(setter,getter 메소드) - 우클릭>소스>제너레이트 게터 앤 세터
	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getList() {
		return list;
	}

	public void setList(String list) {
		this.list = list;
	}

	public String getR_u_success() {
		return r_u_success;
	}

	public void setR_u_success(String r_u_success) {
		this.r_u_success = r_u_success;
	}

	public String getE_time() {
		return e_time;
	}

	public void setE_time(String e_time) {
		this.e_time = e_time;
	}

}
