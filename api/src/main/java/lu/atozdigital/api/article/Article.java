package lu.atozdigital.api.article;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

@Entity
@Table
public class Article {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;
	private String name;
	
	private float price;
	  
	@Lob
	@Column(columnDefinition="BLOB")
	private  String picture;
	
	
	public Article() {
	
	}

	

	public Article(String name, float price, String picture) {
		this.name = name;
		this.price = price;
		this.picture = picture;
	}



	public Article(Long ID, String name, float price, String picture) {
		this.ID = ID;
		this.name = name;
		this.price = price;
		this.picture = picture;
	}



	public Long getID() {
		return ID;
	}



	public void setID(Long ID) {
		this.ID = ID;
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
		return "Article [ID=" + ID + ", name=" + name + ", price=" + price + ", picture=" + picture + "]";
	}

}
