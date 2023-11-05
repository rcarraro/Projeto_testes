
package com.finalproject.ecommerceapp.pojos;

public class TransactionBean {
	
	private long transactionID;
	private String sentOrganization;
	private String receivedOrganization;
	private float transactionAmount;
	java.util.Date date= new java.util.Date();
	private String transactiondate=String.valueOf(date);
	private Type transactiontype;
	private static int count=13401;
	public enum Type{
		Credit("Credit"), Debit("Debit");
		private String value;
		private Type(String value) {
			this.value = value;
		}
		public String getValue() {
			return value;
		}
	}

	public TransactionBean(){

	}

	public TransactionBean(Type type){
		count++;
		transactionID=count;
		this.transactiontype=type;
	}

	public String getSentOrganization() {
		return sentOrganization;
	}

	public void setSentOrganization(String sentOrganization) {
		this.sentOrganization = sentOrganization;
	}

	public String getReceivedOrganization() {
		return receivedOrganization;
	}

	public void setReceivedOrganization(String receivedOrganization) {
		this.receivedOrganization = receivedOrganization;
	}

	public Float getTransactionAmount() {
		return transactionAmount;
	}

	public void setTransactionAmount(Float transactionAmount) {
		this.transactionAmount = transactionAmount;
	}

	public long getTransactionID() {
		return transactionID;
	}

	public void setTransactionID(long transactionID) {
		this.transactionID = transactionID;
	}

	public String getTransactiondate() {
		return transactiondate;
	}

	public Type getTransactiontype() {
		return transactiontype;
	}

	public void setTransactiontype(Type transactiontype) {
		this.transactiontype = transactiontype;
	}

	@Override
	public String toString() {
		return String.valueOf(transactionID);
	}



}
