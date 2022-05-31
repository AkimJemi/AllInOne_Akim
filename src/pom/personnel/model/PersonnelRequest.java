package pom.personnel.model;

public class PersonnelRequest {

	private int no;
	private String name;

	private int job_position;
	private int salary_class;

	private int mini_no;
	private int dept_no;
	private int money;

	private String mini_name;
	private String dept_name;

	public PersonnelRequest(String mini_name, String dept_name) {
		this.mini_name = mini_name;
		this.dept_name = dept_name;

	}

	public PersonnelRequest(int no, String name, int mini_no, int dept_no) {
		this.no = no;
		this.name = name;
		this.mini_no = mini_no;
		this.dept_no = dept_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public PersonnelRequest() {
	}

	public PersonnelRequest(int job_position, int salary_class, int mini_no, int dept_no, int money) {
		this.job_position = job_position;
		this.salary_class = salary_class;
		this.mini_no = mini_no;
		this.dept_no = dept_no;
		this.money = money;
	}

	public int getMoney() {
		return money;
	}

	public String getMini_name() {
		return mini_name;
	}

	public void setMini_name(String mini_name) {
		this.mini_name = mini_name;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public int getJob_position() {
		return job_position;
	}

	public void setJob_position(int job_position) {
		this.job_position = job_position;
	}

	public int getSalary_class() {
		return salary_class;
	}

	public void setSalary_class(int salary_class) {
		this.salary_class = salary_class;
	}

	public int getMini_no() {
		return mini_no;
	}

	public void setMini_no(int mini_no) {
		this.mini_no = mini_no;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

}
