package member.service;

public class exceptionError extends RuntimeException{
	public exceptionError(String result) {
		System.out.println("error : " + result);
	}
}
