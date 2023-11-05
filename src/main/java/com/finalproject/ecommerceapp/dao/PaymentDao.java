package com.finalproject.ecommerceapp.dao;


import org.hibernate.HibernateException;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.PaymentBean;


public class PaymentDao extends DAO {

    public PaymentDao() {
	
	}
    
    public void addPayment(PaymentBean paymentBean) throws AdException {
        try {
            begin();
            
            getSession().save(paymentBean);
            
            commit();
            
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating order: " + e.getMessage());
        }
        
    }
    
}