package lu.atozdigital.api.order;

import java.util.List;

import javax.validation.constraints.NotNull;

import lu.atozdigital.api.article.Article;

public class OrderDTO {
	@NotNull
	private Long ID;
	@NotNull
	private String Reference;
	@NotNull
	private String date;
	private List<Article> articles;
	
	public OrderDTO() {
		super();
	}

	public OrderDTO(String reference, @NotNull String date, List<Article> articles) {
		super();
		this.Reference = reference;
		this.date = date;
		this.articles = articles;
	}

	public OrderDTO(Long ID, String reference, @NotNull String date, List<Article> articles) {
		super();
		this.ID = ID;
		this.Reference = reference;
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

	public @NotNull String getDate() {
		return date;
	}

	public void setDate(@NotNull String date) {
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
		return "OrderDTO [ID=" + ID + ", Reference=" + Reference + ", date=" + date + ", articles=" + articles + "]";
	}
}
