package br.com.gpa.james.management.model;

import java.io.Serializable;
import java.util.List;

public class Categories implements Serializable {

	private static final long serialVersionUID = -5193075715314494476L;
	
	private String title;
	
	private Long gpaId;
  
	private List<Item> items;
	  
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Long getGpaId() {
		return gpaId;
	}
	public void setGpaId(Long gpaId) {
		this.gpaId = gpaId;
	}
	public List<Item> getItems() {
		return items;
	}
	public void setItems(List<Item> items) {
		this.items = items;
	}
}
