package chap08.stat;

public class PageRank {

	private int rank;
	private String page;

	public int getRank() {
		return rank;
	}

	public String getPage() {
		return page;
	}

	public PageRank(int rank, String page) {
		this.rank = rank;
		this.page = page;
	}
}
