package com.finalproject.ecommerceapp.pojos;



public class UserAccountBean {
	private long useraccountid;
	private String username;
	private String password;
	private String emailid;
	private String contactnumber;
	private RoleBean role;

	public UserAccountBean(){

	}
	public UserAccountBean(String username,String password,String emailid,String contactnumber,RoleBean role) {
		this.username=username;
		this.password=password;
		this.emailid=emailid;
		this.contactnumber=contactnumber;
		this.role=role;
	}

	public long getUseraccountid() {
		return useraccountid;
	}
	public void setUseraccountid(long useraccountid) {
		this.useraccountid = useraccountid;
	}
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmailid() {
		return emailid;
	}
	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}
	public String getContactnumber() {
		return contactnumber;
	}
	public void setContactnumber(String contactnumber) {
		this.contactnumber = contactnumber;
	}

	public void setRole(RoleBean role) {
		this.role = role;
	}
	@Override
	public String toString() {
		return username;
	}
	public RoleBean getRole() {
		return role;
	}
}
