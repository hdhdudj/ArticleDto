package sbs.demo.main;

public class ArticleDto {
	private String title;
	private String body;
	private long id;
	
	public long getId() {
		return this.id;
	}
	public String getTitle() {
		return this.title;
	}
	public String getBody() {
		return this.body;
	}
	
	@Override
	public String toString() {
		String asdf = "{ id = "+getId()+", title = \""+getTitle()+"\", body = \""+getBody()+"\"}";
		
		return asdf;
	}
	
	public void setArticle(long id, String title, String body) {
		this.id = id;
		this.title = title;
		this.body = body;
	}
	
	public String getArticles() {
		return this.toString();
	}
	
}
