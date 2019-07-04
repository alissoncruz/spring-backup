package br.com.gpa.james.management.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

public class Item implements Serializable {

	private static final long serialVersionUID = -6865328782230683833L;

	private Long product;

	private BigDecimal price;
	
	private BigDecimal currentPrice;
	
	private Integer storage;
	
	private String name;
	
	private String shortDescription;
	
	private List<Ean> eans;
	
	private List<String> images;
	 
	public Long getProduct() {
		return product;
	}

	public void setProduct(Long product) {
		this.product = product;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getCurrentPrice() {
		return currentPrice;
	}

	public void setCurrentPrice(BigDecimal currentPrice) {
		this.currentPrice = currentPrice;
	}

	public Integer getStorage() {
		return storage;
	}

	public void setStorage(Integer storage) {
		this.storage = storage;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public List<Ean> getEans() {
		return eans;
	}

	public void setEans(List<Ean> eans) {
		this.eans = eans;
	}

	public List<String> getImages() {
		return images;
	}

	public void setImages(List<String> images) {
		this.images = images;
	}
}
