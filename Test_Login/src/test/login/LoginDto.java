package test.login;

public class LoginDto {
	private String id;
	private int password;
	private String nickName;
	
	public LoginDto() {}

	public LoginDto(String id, int password, String nickName) {
		super();
		this.id = id;
		this.password = password;
		this.nickName = nickName;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getPassword() {
		return password;
	}

	public void setPassword(int password) {
		this.password = password;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	
	
}
