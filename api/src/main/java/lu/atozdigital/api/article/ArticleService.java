package lu.atozdigital.api.article;

import java.util.List;
import java.util.Optional;

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
	
	public Optional <Article> findArticle(Long id) {
		Optional<Article> articleO;
	
		articleO = articleRepository.findById(id);
		return articleO;
	}
	
	public List<Article> getArticles() {
		return articleRepository.findAll();
	}
}
