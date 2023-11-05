package com.finalproject.ecommerceapp.pojos;

public class ReviewBean {
	private long reviewId;
	private String review;
	private CustomerBean customerBean;
	
	public ReviewBean(){
		
	}
	public ReviewBean(String review,CustomerBean bean){
		this.review=review;
		this.customerBean=bean;
	}
	public long getReviewId() {
		return reviewId;
	}
	public void setReviewId(long reviewId) {
		this.reviewId = reviewId;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
	public CustomerBean getCustomerBean() {
		return customerBean;
	}
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}
	
	
}
