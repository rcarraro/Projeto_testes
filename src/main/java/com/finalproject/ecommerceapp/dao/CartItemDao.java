package com.finalproject.ecommerceapp.dao;


import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CartItemBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.ProductBean;

public class CartItemDao extends DAO {

	public CartItemDao() {

	}

	public CartItemBean getCartById(long cartItemId) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from CartItemBean where cartItemId = :cartItemId");
			q.setLong("cartItemId",cartItemId);
			CartItemBean cartItemBean = (CartItemBean) q.uniqueResult();
			commit();
			return cartItemBean;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not obtain the item on cart " + e.getMessage());
		}
	}


	public CartItemBean addToCart(ProductBean productBean) throws AdException {
		try {
			begin();

			CartItemBean cartItemBean = new CartItemBean(productBean, 1);
			getSession().save(cartItemBean);
			commit();
			return cartItemBean;

		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}


	public void deleteCartItem(CartItemBean cartItemBean) throws AdException{
		try {
			begin();
			getSession().delete(cartItemBean);
			commit();

		} catch (HibernateException e) {
			rollback();

			throw new AdException("Exception while deleting cartitem: " + e.getMessage());
		}

	}

	public void updateShoppingCart(CustomerBean customerBean,CartItemBean cartItemBean) throws AdException {
		try {
			begin();
			getSession().save(cartItemBean);
			customerBean.addCartItems(cartItemBean);
			getSession().update(customerBean);
			commit();

		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}


}