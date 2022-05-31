package pom.main.model;

public class Paging {
	private int currentPage;
	private int startPage;
	private int total;
	private int limit = 10;
	private int endPage;
	private int lastPage;

	public Paging(int total, int startPage, int currentPage) {
		this.total = total;
		this.currentPage = currentPage;
		this.startPage = startPage;
		this.lastPage = total / 10;
		this.endPage = startPage + 4;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getLastPage() {
		return lastPage;
	}

	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}

}