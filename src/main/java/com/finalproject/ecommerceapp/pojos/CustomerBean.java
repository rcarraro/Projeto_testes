package com.finalproject.ecommerceapp.pojos;

import java.util.HashSet;
import java.util.Set;

public class CustomerBean {
	private long customerid;
	private String customerfirstname;
	private String customerlastname;
	private AddressBean address;
	private UserAccountBean userAccountBean;
	private Set<CartItemBean> cartItems;

	public CustomerBean(){
		this.cartItems = new HashSet<CartItemBean>();
	}

	public String getCustomerfirstname() {
		return customerfirstname;
	}

	public long getCustomerid() {
		return customerid;
	}

	public void setCustomerid(long customerid) {
		this.customerid = customerid;
	}

	public void setCustomerfirstname(String customerfirstname) {
		this.customerfirstname = customerfirstname;
	}
	public String getCustomerlastname() {
		return customerlastname;
	}
	public void setCustomerlastname(String customerlastname) {
		this.customerlastname = customerlastname;
	}
	public AddressBean getAddress() {
		return address;
	}
	public void setAddress(AddressBean address) {
		this.address = address;
	}
	public UserAccountBean getUserAccountBean() {
		return userAccountBean;
	}
	public void setUserAccountBean(UserAccountBean userAccountBean) {
		this.userAccountBean = userAccountBean;
	}

	public Set<CartItemBean> getCartItems() {
		return cartItems;
	}

	public void setCartItems(Set<CartItemBean> cartItems) {
		this.cartItems = cartItems;
	}

	public void addCartItems(CartItemBean cartItemBean) {
		getCartItems().add(cartItemBean);
	}
}
