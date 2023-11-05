package com.finalproject.ecommerceapp.pojos;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;



public class OrderBean {

	private long orderID;
	private CustomerBean customerBean;
	private float totalPrice;
	private String orderStatus;
	private InvoiceBean invoiceBean;
	private Date orderDate;
	private Set<OrderItemBean> orderItems;

	public OrderBean(){
		this.orderItems = new HashSet<OrderItemBean>();
	}

	public long getOrderID() {
		return orderID;
	}
	public void setOrderID(long orderID) {
		this.orderID = orderID;
	}
	public CustomerBean getCustomerBean() {
		return customerBean;
	}
	public void setCustomerBean(CustomerBean customerBean) {
		this.customerBean = customerBean;
	}
	public float getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(float totalPrice) {
		this.totalPrice = totalPrice;
	}
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public InvoiceBean getInvoiceBean() {
		return invoiceBean;
	}

	public void setInvoiceBean(InvoiceBean invoiceBean) {
		this.invoiceBean = invoiceBean;
	}
	public Date getOrderDate() {
		return orderDate;
	}
//	public String getOrderDateDisplay() {
//		return orderDate.toString();
//	}
	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}
	public Set<OrderItemBean> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(Set<OrderItemBean> orderItems) {
		this.orderItems = orderItems;
	}
	public void createAndAddOrderItem(OrderItemBean orderItem){
		getOrderItems().add(orderItem);   
	}

	public void deleteOrderItem(OrderItemBean orderItem) {
		getOrderItems().remove(orderItem);
	}

	public float totalPrice(){
		float price = 0;
		System.out.println("entered total price");
		for(OrderItemBean orderItemBean : orderItems){
			price = price + orderItemBean.getprice();
		}
		return price;
	}

	public void generateInvoice(float tax){
		invoiceBean = new InvoiceBean();
		invoiceBean.setCostOfOrder(Math.round(totalPrice *100)/100);
		invoiceBean.setTaxDue(Math.round(tax*totalPrice*100)/100);
		invoiceBean.setTotalAmount(Math.round((totalPrice*(1 + tax)*100)/100));

	}

	@Override
	public String toString() {
		return String.valueOf(orderID);
	} 
}
