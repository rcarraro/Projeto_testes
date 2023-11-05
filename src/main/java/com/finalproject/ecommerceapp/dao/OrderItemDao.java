package com.finalproject.ecommerceapp.dao;


import org.hibernate.HibernateException;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.OrderItemBean;


public class OrderItemDao extends DAO {

	public OrderItemDao() {

	}

	public void addOrderItem(OrderItemBean orderItemBean) throws AdException {
		try {
			begin();
			getSession().save(orderItemBean);
			commit();

		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while adding order item : " + e.getMessage());
		}

	}

}