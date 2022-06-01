package zJavaPractice;

public abstract class DispatcherServlet {
	public void doGett() {
		run();
	}

	public void doPostt() {
		run();
	}

	public DispatcherServlet() {
		System.out.println("init()");
	}

	public void run() {
		beforeDoAction();

		String path = doAction();

		if (path != null)
			afterDoAction();
		
	}

	protected abstract String doAction();

	private void beforeDoAction() {
		System.out.println("beforeDoAction");
	}

	private void afterDoAction() {
		System.out.println("afterDoAction");
	}

}
