package member.model;

public class Member {
	private String id;
	private int no;
	private String name;
	private String password;

	public Member(String id, String name, String password) {
		this.id = id;
		this.password = password;
		this.name = name;
	}

	public Member(int no, String id, String name) {
		this.id = id;
		this.no = no;
		this.name = name;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public boolean matchPassword(String pwd) {
		return password.equals(pwd);
	}

}
