package lu.atozdigital.api.article;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lu.atozdigital.api.exception.ApiRestException;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(path="/articles")
public class ArticleController {
	
	 @Autowired
	private ModelMapper modelMapper;
	final ArticleService articleService;
	public ArticleController(ArticleService articleService) {
		this.articleService  = articleService;
	}	
		
	@PostMapping()
	public ResponseEntity<Article> addArticle(@RequestBody ArticleDTO articleDTO) {
		try {
			articleService.addArticle(modelMapper.map(articleDTO, Article.class));
		}catch(Exception e) {
			throw new ApiRestException("Oops Upload problem !!");
		}
		return new ResponseEntity<Article>(HttpStatus.OK);
	}
	
	@GetMapping(path="{articleId}")
	public ResponseEntity<ArticleDTO> findArticle(@PathVariable("articleId") Long id){
		Optional <Article> articleO;
		ArticleDTO articleDTO;
		
		articleO =  articleService.findArticle(id);
		if(!articleO.isPresent())
			throw new ApiRestException("Oops article not found !!");
		articleDTO = modelMapper.map(articleO.get(), ArticleDTO.class);
		return new ResponseEntity<ArticleDTO>(articleDTO, HttpStatus.OK);
	}
	
	@GetMapping
	public List<ArticleDTO> getArticles(){
		List<Article> articles;
		List<ArticleDTO> articlesDTO;
		
		articles = articleService.getArticles();
		articlesDTO = articles.stream().map(article -> modelMapper.map(article, ArticleDTO.class))
				.collect(Collectors.toList());
		return articlesDTO;
	}
}
