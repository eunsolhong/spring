package board;

public class WriteArticleServiceImpl implements WriteArticleService {

	private ArticleDao articleDao;
	
	public WriteArticleServiceImpl(ArticleDao articleDao) {
		this.articleDao = articleDao;
	}
	
	@Override
	public void write(NewArticleRequest newArticleReq) {
		System.out.println("WrtieArticleServiceImpl.write() 호출됨");
		Article article = toArticle(newArticleReq);
		articleDao.insert(article);
	}
	
	private Article toArticle(NewArticleRequest newArticleReq) {
		return new Article(
				newArticleReq.getWriteName(),
				newArticleReq.getTitle(),
				newArticleReq.getContent());
	}
}
