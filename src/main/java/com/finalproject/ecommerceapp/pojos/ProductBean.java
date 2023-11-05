package com.finalproject.ecommerceapp.pojos;

import java.util.HashSet;
import java.util.Set;


public class ProductBean {
	private long productId;
	private String name;
	private int price; 
	private String description;
	private int availability;
	private CategoryBean categoryBean;
	private String productPictureUrlString;
	private SupplierBean supplierBean;
	private Set<ReviewBean> reviews;

	public ProductBean() {
		reviews=new HashSet<ReviewBean>();
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public void setProductId(long productId) {
		this.productId = productId;
	}

	public int getAvailability() {
		return availability;
	}

	public void setAvailability(int availability2) {
		this.availability = availability2;
	}

	public CategoryBean getCategoryBean() {
		return categoryBean;
	}

	public void setCategoryBean(CategoryBean categoryBean) {
		this.categoryBean = categoryBean;
	}

	public String getProductPictureUrlString() {
		return productPictureUrlString;
	}

	public void setProductPictureUrlString(String productPictureUrlString) {
		this.productPictureUrlString = productPictureUrlString;
	}

	public SupplierBean getSupplierBean() {
		return supplierBean;
	}

	public void setSupplierBean(SupplierBean supplierBean) {
		this.supplierBean = supplierBean;
	}

	public Set<ReviewBean> getReviews() {
		return reviews;
	}

	public void setReviews(Set<ReviewBean> reviews) {
		this.reviews = reviews;
	}
	

}
