package pom.user.model;

import java.sql.Date;

public class User {
	

	private int no;
	private String id;
	private String password;
	private String filename;
	private String filerealname;
	private String name;
	private int reg_num;
	private String phone;
	private String addr;
	private String email;
	private String school_name;
	private String school_major;
	private Date school_out;
	private int tall;
	private int weight;
	private String eye_l;
	private String eye_r;
	private String gender;
	private String marry;
	private String disabled;
	private int disabled_grade;
	private Date disabled_day;
	
	public User(String id, String password) {
		this.id = id;
		this.password = password;
	}
	
	public User(int no, String filename, String filerealname, String name, int reg_num, String phone, String addr, String email,
			String school_name, String school_major, Date school_out, int tall, int weight, String eye_l, String eye_r,
			String gender, String marry, String disabled, int disabled_grade, Date disabled_day) {
		this.no = no;
		this.filename = filename;
		this.filerealname = filerealname;
		this.name = name;
		this.reg_num = reg_num;
		this.phone = phone;
		this.addr = addr;
		this.email = email;
		this.school_name = school_name;
		this.school_major = school_major;
		this.school_out = school_out;
		this.tall = tall;
		this.weight = weight;
		this.eye_l = eye_l;
		this.eye_r = eye_r;
		this.gender = gender;
		this.marry = marry;
		this.disabled = disabled;
		this.disabled_grade = disabled_grade;
		this.disabled_day = disabled_day;
	}
	
	public User() {}
	
	public int getNo() {
		return no;
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

	public String getFilename() {
		return filename;
	}
	public String getFilerealname() {
		return filerealname;
	}
	public String getName() {
		return name;
	}
	public int getReg_num() {
		return reg_num;
	}
	public String getPhone() {
		return phone;
	}
	public String getAddr() {
		return addr;
	}
	public String getEmail() {
		return email;
	}
	public String getSchool_name() {
		return school_name;
	}
	public String getSchool_major() {
		return school_major;
	}
	public Date getSchool_out() {
		return school_out;
	}
	public int getTall() {
		return tall;
	}
	public int getWeight() {
		return weight;
	}
	public String getEye_l() {
		return eye_l;
	}
	public String getEye_r() {
		return eye_r;
	}
	public String getGender() {
		return gender;
	}
	public String getMarry() {
		return marry;
	}
	public String getDisabled() {
		return disabled;
	}
	public int getDisabled_grade() {
		return disabled_grade;
	}
	public Date getDisabled_day() {
		return disabled_day;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public void setFilerealname(String filerealname) {
		this.filerealname = filerealname;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setReg_num(int reg_num) {
		this.reg_num = reg_num;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setSchool_name(String school_name) {
		this.school_name = school_name;
	}
	public void setSchool_major(String school_major) {
		this.school_major = school_major;
	}
	public void setSchool_out(Date school_out) {
		this.school_out = school_out;
	}
	public void setTall(int tall) {
		this.tall = tall;
	}
	public void setWeight(int weight) {
		this.weight = weight;
	}
	public void setEye_l(String eye_l) {
		this.eye_l = eye_l;
	}
	public void setEye_r(String eye_r) {
		this.eye_r = eye_r;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public void setMarry(String marry) {
		this.marry = marry;
	}
	public void setDisabled(String disabled) {
		this.disabled = disabled;
	}
	public void setDisabled_grade(int disabled_grade) {
		this.disabled_grade = disabled_grade;
	}
	public void setDisabled_day(Date disabled_day) {
		this.disabled_day = disabled_day;
	}
}
