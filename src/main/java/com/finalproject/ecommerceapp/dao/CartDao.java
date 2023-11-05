package com.finalproject.ecommerceapp.dao;

import java.util.HashSet;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CartItemBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;

public class CartDao extends DAO {

    public CartDao() {
	
	}
    
    public void addToCart(CustomerBean customerBean,CartItemBean cartItemBean) throws AdException {
        try {
            begin();
            customerBean.addCartItems(cartItemBean);        
            getSession().update(customerBean);          
            commit();
            
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating cart: " + e.getMessage());
        }
        
    }
    
    public boolean deleteItem(CustomerBean customerBean,CartItemBean cartItemBean) throws AdException{
    	try {
            begin();
            boolean isRemoved = customerBean.getCartItems().remove(cartItemBean);
            getSession().update(customerBean);
            commit();
            return isRemoved;
            
        } catch (HibernateException e) {
            rollback();
            throw new AdException("Exception while deleting item: " + e.getMessage());
        }
     
    }
        
    public void updateCart(CartItemBean cartItemBean) throws AdException {
        try {
            begin();
            getSession().update(cartItemBean);
            commit();
            
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
        }
        
    }
    @SuppressWarnings({ "rawtypes", "unchecked" })
	public CustomerBean clearShoppingCart(CustomerBean customerBean) throws AdException {
        try {
            begin();
            customerBean.setCartItems(new HashSet());
            getSession().update(customerBean);         
            commit();
            return customerBean;
        } catch (HibernateException e) {
            rollback();
            //throw new AdException("Could not create user " + username, e);
            throw new AdException("Exception while creating user: " + e.getMessage());
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