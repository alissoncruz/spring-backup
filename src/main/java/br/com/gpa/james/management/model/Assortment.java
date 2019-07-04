package br.com.gpa.james.management.model;


import java.io.Serializable;
import java.util.List;

public class Assortment implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long storyId;

	private List<Categories> categories;

	public Long getStoryId() {
		return storyId;
	}

	public void setStoryId(Long storyId) {
		this.storyId = storyId;
	}

	public List<Categories> getCategories() {
		return categories;
	}

	public void setCategories(List<Categories> categories) {
		this.categories = categories;
	}
	
}
