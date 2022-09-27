package lu.atozdigital.api.order;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lu.atozdigital.api.article.Article;

@Entity
@Table(name = "order_a")
public class Order {
	@Id
	@GeneratedValue
	private Long ID;
	private String Reference;
	private String date;
	
	@OneToMany(targetEntity = Article.class)
	@JoinColumn(name = "oa_fk", referencedColumnName = "ID")
	private List<Article> articles;
	
	public Order() {
		super();
	}


	public Order(String reference, String date, List<Article> articles) {
		super();
		Reference = reference;
		this.date = date;
		this.articles = articles;
	}


	public Order(Long iD, String reference, String date, List<Article> articles) {
		super();
		ID = iD;
		Reference = reference;
		this.date = date;
		this.articles = articles;
	}


	public Long getID() {
		return ID;
	}


	public void setID(Long iD) {
		ID = iD;
	}


	public String getReference() {
		return Reference;
	}


	public void setReference(String reference) {
		Reference = reference;
	}


	public String getDate() {
		return date;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public List<Article> getArticles() {
		return articles;
	}


	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}


	@Override
	public String toString() {
		return "Order [ID=" + ID + ", Reference=" + Reference + ", date=" + date + ", articles=" + articles + "]";
	} 
}
