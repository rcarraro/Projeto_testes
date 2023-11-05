package com.finalproject.ecommerceapp.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CategoryBean;

public class CategoryDao extends DAO {

	public CategoryDao() {
	}

	public void create(String category) throws AdException {
		try {
			begin();
			CategoryBean categoryBean = new CategoryBean(category);
			getSession().save(categoryBean);
			commit();

		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating Category: " + e.getMessage());
		}

	}


	@SuppressWarnings("unchecked")
	public List<CategoryBean> list() throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from CategoryBean");
			List<CategoryBean> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not list the categories", e);
		}
	}

	public CategoryBean get(String category) throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from CategoryBean where category = :category");
			q.setString("category", category);
			CategoryBean categoryBean = (CategoryBean) q.uniqueResult();
			commit();
			return categoryBean;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not obtain the named category " + category + " " + e.getMessage());
		}
	}

}