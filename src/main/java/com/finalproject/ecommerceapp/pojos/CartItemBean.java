package com.finalproject.ecommerceapp.pojos;


public class CartItemBean {
	private long cartItemId;
	private ProductBean productBean;
	private int quantity;
	private float price;

	public CartItemBean(){

	}
	public CartItemBean(ProductBean productBean,int quantity){
		this.productBean = productBean;
		this.quantity = quantity;
		this.price = quantity * productBean.getPrice();
	}
	public long getCartItemId() {
		return cartItemId;
	}
	public void setCartItemId(long cartItemId) {
		this.cartItemId = cartItemId;
	}
	public ProductBean getProductBean() {
		return productBean;
	}
	public void setProductBean(ProductBean productBean) {
		this.productBean = productBean;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getPrice() {
		return price;
	}
	 public void setPrice(float price) {
			this.price = price;
		}
	public void setPrice() {
		 this.price = quantity * productBean.getPrice();
	}


}
