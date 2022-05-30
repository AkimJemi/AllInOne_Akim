package res.exception;

public class exceptionError extends RuntimeException{
	public exceptionError(String result) {
		System.out.println("error : " + result);
	}
}
