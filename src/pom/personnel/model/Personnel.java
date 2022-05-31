package pom.personnel.model;

import java.sql.Date;

import pom.personnel.service.SubService;

public class Personnel {
	private PersonnelRequest personnelRequest;

	private int no;
	private String name;
	private int job_position;
	private int salary_class;

	private int mini_no;
	private int dept_no;

	private int money;
	private Date enter_date;
	private Date resign_date;

	private String mini_name;
	private String dept_name;

	public Personnel(int no, String name, int job_position, int salary_class, int money, int mini_no, int dept_no,
			Date enter_date, Date resign_date) {
		this.no = no;
		this.name = name;
		this.money = money;
		this.enter_date = enter_date;
		this.resign_date = resign_date;
		this.job_position = job_position;
		this.salary_class = salary_class;
		this.mini_no = mini_no;
		this.dept_no = dept_no;
		personnelRequest = new PersonnelRequest(job_position, salary_class, mini_no, dept_no, money);
		ToStringlize(personnelRequest);

	}
	

	public Personnel(int job_position, int salary_class, int mini_no, int dept_no, int ex_mini_no, int ex_dept_no) {
		this.job_position = job_position;
		this.salary_class = salary_class;
		this.mini_no = mini_no;
		this.dept_no = dept_no;
	}

	public Personnel() {
	}

	public Personnel(int no, String name, int mini_no, int dept_no) {
		this.no = no;
		this.name = name;
		this.mini_no = mini_no;
		this.dept_no = dept_no;
		personnelRequest = new PersonnelRequest(no, name, mini_no, dept_no);
		ToStringlize(personnelRequest);
	}

	private void ToStringlize(PersonnelRequest subPers) {
		SubService subService = new SubService();
		subPers = subService.ToStringlize(subPers);
		this.money = subPers.getMoney();
		this.mini_name = subPers.getMini_name();
		this.dept_name = subPers.getDept_name();
	}

	public void setMini_name(String mini_name) {
		this.mini_name = mini_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	public String getMini_name() {
		return mini_name;
	}

	public String getDept_name() {
		return dept_name;
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

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
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

	public Date getEnter_date() {
		return enter_date;
	}

	public void setEnter_date(Date enter_date) {
		this.enter_date = enter_date;
	}

	public Date getResign_date() {
		return resign_date;
	}

	public void setResign_date(Date resign_date) {
		this.resign_date = resign_date;
	}

}
