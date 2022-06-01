package res.dto;




public class MemberAndBook {
	private int no;
	private String id;
	private String password;
	private String email;
	private String name;
	private String gender;
	private int age;
	private String res_nvm;
	private String if_res;
	private String check_res;
	
	
	public MemberAndBook(int no, String id, String password, String email, String name, String gender, int age,
			String res_nvm, String if_res, String check_res) {
		this.no = no;
		this.id = id;
		this.password = password;
		this.email = email;
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.res_nvm = res_nvm;
		this.if_res = if_res;
		this.check_res = check_res;
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
	public String getRes_nvm() {
		return res_nvm;
	}
	public void setRes_nvm(String res_nvm) {
		this.res_nvm = res_nvm;
	}
	public String getIf_res() {
		return if_res;
	}
	public void setIf_res(String if_res) {
		this.if_res = if_res;
	}
	public String getCheck_res() {
		return check_res;
	}
	public void setCheck_res(String check_res) {
		this.check_res = check_res;
	}
	
	
}
