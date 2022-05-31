package pom.main.model;

public class Edu {
	private int no;
	private int edu_no;
	private String edu_content;

	public Edu(int no, int edu_no, String edu_content) {
		this.no = no;
		this.edu_no = edu_no;
		this.edu_content = edu_content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public int getEdu_no() {
		return edu_no;
	}

	public void setEdu_no(int edu_no) {
		this.edu_no = edu_no;
	}

	public String getEdu_content() {
		return edu_content;
	}

	public void setEdu_content(String edu_content) {
		this.edu_content = edu_content;
	}

}
