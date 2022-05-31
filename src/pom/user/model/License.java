package pom.user.model;

import java.sql.Date;

public class License {
	
	private int no;
	private int lic_no;
	private String license;
	private Date license_day;
	
	public License() {}
	
	public License(int no, int lic_no, String license, Date license_day) {
		this.no = no;
		this.lic_no = lic_no;
		this.license = license;
		this.license_day = license_day;
	}
	

	public int getNo() {
		return no;
	}

	public int getLic_no() {
		return lic_no;
	}

	public String getLicense() {
		return license;
	}

	public Date getLicense_day() {
		return license_day;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public void setLic_no(int lic_no) {
		this.lic_no = lic_no;
	}

	public void setLicense(String license) {
		this.license = license;
	}

	public void setLicense_day(Date license_day) {
		this.license_day = license_day;
	}
	
	

}
