package lu.atozdigital.api.article;

public class ArticleDTO {
	private Long id;
	private String name;
	private float price;
	private String picture;
	
	
	
	public ArticleDTO() {
		super();
	}



	public ArticleDTO(Long id, String name, float price, String picture) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.picture = picture;
	}



	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public double getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public String getPicture() {
		return picture;
	}



	public void setPicture(String picture) {
		this.picture = picture;
	}



	@Override
	public String toString() {
		return "ArticleDTO [id=" + id + ", name=" + name + ", price=" + price + ", picture=" + picture + "]";
	}
}
