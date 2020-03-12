package board;

public class NewArticleRequest {

	private String writeName;
	private String title;
	private String content;
	
	public NewArticleRequest(String writeName, String title, String content) {
		this.writeName = writeName;
		this.title = title;
		this.content = content;
	}

	public String getWriteName() {
		return writeName;
	}

	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}
}
