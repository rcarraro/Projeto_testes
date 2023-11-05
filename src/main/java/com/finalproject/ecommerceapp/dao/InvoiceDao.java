package com.finalproject.ecommerceapp.dao;


import org.hibernate.HibernateException;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.InvoiceBean;

public class InvoiceDao extends DAO {

	public InvoiceDao() {

	}

	public void addInvoice(InvoiceBean invoiceBean) throws AdException {
		try {
			begin();
			getSession().save(invoiceBean);

			commit();

		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating invoice: " + e.getMessage());
		}

	}

}