package com.finalproject.ecommerceapp.dao;


import java.util.List;


import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CartItemBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.OrderBean;

public class OrderDao extends DAO {

    public OrderDao() {
	
	}
    
    public void addOrder(OrderBean orderBean) throws AdException {
        try {
            begin();
         
            getSession().save(orderBean);
            
            commit();
            
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating order: " + e.getMessage());
        }
        
    }
    
    public void updateOrder(OrderBean orderBean) throws AdException {
        try {
            begin();            
            getSession().update(orderBean);
            
            commit();
            
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating order: " + e.getMessage());
        }
        
    }
    
    public boolean deleteItem(CustomerBean customerBean,CartItemBean cartItemBean) throws AdException{
    	try {
            begin();
            System.out.println("cart item delete function");
            System.out.println(customerBean.getCartItems().size());
            boolean isRemoved = customerBean.getCartItems().remove(cartItemBean);
            System.out.println(isRemoved);
            System.out.println(customerBean.getCartItems().size());
            
            getSession().update(customerBean);
            System.out.println("deleted from customer");
            commit();
            return isRemoved;
            
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while deleting item: " + e.getMessage());
        }
     
    }
        

    @SuppressWarnings("rawtypes")
	public List list() throws AdException {
        try {
            begin();
            Query q = getSession().createQuery("from Cart");
            List list = q.list();
            commit();
            return list;
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Could not list the categories", e);
        }
    }
    
}