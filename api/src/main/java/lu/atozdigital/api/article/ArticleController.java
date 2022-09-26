package lu.atozdigital.api.article;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
}
