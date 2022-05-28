package res.member.model;

public class Member {
	private int no;
	private String id;
	private String password;
	private String name;
	private String email;
	private String gender;
	private int age;

	public Member(String id, String name, String password) {
		this.id = id;
		this.name = name;
		this.password = password;
	}

	public Member(int no, String id, String password, String name, String email,
			String gender, int age) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.age = age;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Member(int no, String id, String name) {
		this.id = id;
		this.no = no;
		this.name = name;
	}

	public Member() {
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
