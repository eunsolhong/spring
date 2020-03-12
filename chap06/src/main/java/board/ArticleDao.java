package board;

public interface ArticleDao {

	public void insert(Article article);
	
	public Article selectById(Integer id);
}
