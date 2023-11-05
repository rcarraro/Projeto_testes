package com.finalproject.ecommerceapp.pojos;


public class CategoryBean {
	private long categoryid;
	private String category;

	public CategoryBean(){

	}
	public CategoryBean(String category){
		this.category=category;
	}

	public long getCategoryid() {
		return categoryid;
	}


	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}


	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}

}
