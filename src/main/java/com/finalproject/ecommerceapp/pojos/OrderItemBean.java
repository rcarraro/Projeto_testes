package com.finalproject.ecommerceapp.pojos;

public class OrderItemBean {
	private long orderitemid;
	private ProductBean product;
	private int quantity;
	private float price;
	private String orderItemStatus;
	private String estimatedDateOfDelivery;

	public long getOrderitemid() {
		return orderitemid;
	}

	public void setOrderitemid(long orderitemid) {
		this.orderitemid = orderitemid;
	}

	public ProductBean getProduct() {
		return product;
	}

	public void setProduct(ProductBean product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public float getprice() {
		return price;
	}

	public void setprice(float price) {
		this.price = price;
	}

	public String getOrderItemStatus() {
		return orderItemStatus;
	}

	public void setOrderItemStatus(String orderItemStatus) {
		this.orderItemStatus = orderItemStatus;
	}

	public String getEstimatedDateOfDelivery() {
		return estimatedDateOfDelivery;
	}

	public void setEstimatedDateOfDelivery(String estimatedDateOfDelivery) {
		this.estimatedDateOfDelivery = estimatedDateOfDelivery;
	}


	@Override
	public String toString() {
		return  String.valueOf(product);
	}
}
