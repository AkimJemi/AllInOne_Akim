package res.dto;

public class Book {

	private int no;
	private int member_no;
	private String res_nvm;
	private String if_res;
	private String check_res;

	public Book(int no, int member_no, String res_nvm, String if_res, String check_res) {
		this.no = no;
		this.member_no = member_no;
		this.res_nvm = res_nvm;
		this.if_res = if_res;
		this.check_res = check_res;
	}

	public Book(String if_res) {
		this.if_res = if_res;
	}

	public int getMember_no() {
		return member_no;
	}

	public void setMember_no(int member_no) {
		this.member_no = member_no;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
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
