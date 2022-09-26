package lu.atozdigital.api.article;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {
	
	final IArticleRepository articleRepository;
	
	@Autowired
	public ArticleService(IArticleRepository articleRepository) {
		this.articleRepository = articleRepository;
	}

	public void addArticle(Article article) {
		articleRepository.save(article);
	}
}
