package reservation.model;

public class Reservation {

	private int no;
	private String revNum;
	private String ifreservation;
	
	public Reservation(int no, String revNum, String ifreservation) {
		super();
		this.no = no;
		this.revNum = revNum;
		this.ifreservation = ifreservation;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public String getRevNum() {
		return revNum;
	}
	public void setRevNum(String revNum) {
		this.revNum = revNum;
	}
	public String getIfreservation() {
		return ifreservation;
	}
	public void setIfreservation(String ifreservation) {
		this.ifreservation = ifreservation;
	}

}
