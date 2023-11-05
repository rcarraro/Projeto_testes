package com.finalproject.ecommerceapp.pojos;

public class SupplierBean {
	private long supplierid;
	private String suppliername;
	private AddressBean addressBean;
	private UserAccountBean userAccountBean;
	public SupplierBean(){

	}
	public SupplierBean(String suppliername,AddressBean addressBean,UserAccountBean userAccountBean){
		this.suppliername=suppliername;
		this.addressBean=addressBean;
		this.userAccountBean=userAccountBean;
	}
	public long getSupplierid() {
		return supplierid;
	}
	public void setSupplierid(long supplierid) {
		this.supplierid = supplierid;
	}
	public String getSuppliername() {
		return suppliername;
	}
	public void setSuppliername(String suppliername) {
		this.suppliername = suppliername;
	}
	public AddressBean getAddressBean() {
		return addressBean;
	}
	public void setAddressBean(AddressBean addressBean) {
		this.addressBean = addressBean;
	}
	public UserAccountBean getUserAccountBean() {
		return userAccountBean;
	}
	public void setUserAccountBean(UserAccountBean userAccountBean) {
		this.userAccountBean = userAccountBean;
	}


}
