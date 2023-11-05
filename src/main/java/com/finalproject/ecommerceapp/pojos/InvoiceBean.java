package com.finalproject.ecommerceapp.pojos;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InvoiceBean {
	private long invoiceid;
	private String invoiceStatus;
	private float totalAmount;
	private float taxDue;
	private float costOfOrder;
	private String date;
	private DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");

    public InvoiceBean() {
        date = String.valueOf(dateFormat.format(new Date()));
    }

	public long getInvoiceid() {
		return invoiceid;
	}

	public void setInvoiceid(long invoiceid) {
		this.invoiceid = invoiceid;
	}

	public String getInvoiceStatus() {
		return invoiceStatus;
	}

	public void setInvoiceStatus(String invoiceStatus) {
		this.invoiceStatus = invoiceStatus;
	}

	public float getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(float totalAmount) {
		this.totalAmount = totalAmount;
	}

	public float getTaxDue() {
		return taxDue;
	}

	public void setTaxDue(float taxDue) {
		this.taxDue = taxDue;
	}

	public float getCostOfOrder() {
		return costOfOrder;
	}

	public void setCostOfOrder(float costOfOrder) {
		this.costOfOrder = costOfOrder;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}


}
