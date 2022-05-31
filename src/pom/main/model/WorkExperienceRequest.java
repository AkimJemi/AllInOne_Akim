package pom.main.model;

public class WorkExperienceRequest {
	private int no;
	private int we_no;

	private int dept_no;
	private int mini_no;
	private String dept_name;
	private String mini_name;

	public WorkExperienceRequest() {
	}

	public WorkExperienceRequest(int no, int we_no, int dept_no, int mini_no) {
		this.no = no;
		this.we_no = we_no;
		this.dept_no = dept_no;
		this.mini_no = mini_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getWe_no() {
		return we_no;
	}

	public void setWe_no(int we_no) {
		this.we_no = we_no;
	}

	public int getDept_no() {
		return dept_no;
	}

	public void setDept_no(int dept_no) {
		this.dept_no = dept_no;
	}

	public int getMini_no() {
		return mini_no;
	}

	public void setMini_no(int mini_no) {
		this.mini_no = mini_no;
	}

	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getMini_name() {
		return mini_name;
	}

	public void setMini_name(String mini_name) {
		this.mini_name = mini_name;
	}

}
