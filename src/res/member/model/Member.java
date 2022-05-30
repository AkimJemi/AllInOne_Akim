package res.member.model;

public class Member {
	private int no;

	private String id;
	private String password;
	private String email;
	private String name;
	private String gender;
	private int age;

	public Member(int no, String id, String password, String email, String name, String gender, int age) {
		super();
		this.no = no;
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.gender = gender;
		this.age = age;

	}

	public Member(String id, String password) {
		super();
		this.id = id;
		this.password = password;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public boolean matchPassword(String password) {
		if (this.password == password) {
			return true;
		}
		return false;
	}
}
