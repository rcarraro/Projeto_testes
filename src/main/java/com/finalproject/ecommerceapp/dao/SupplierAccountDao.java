package com.finalproject.ecommerceapp.dao;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.AddressBean;
import com.finalproject.ecommerceapp.pojos.ProductBean;
import com.finalproject.ecommerceapp.pojos.RoleBean;
import com.finalproject.ecommerceapp.pojos.SupplierBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;;

public class SupplierAccountDao extends DAO {

	public SupplierAccountDao() {
	}

	public SupplierBean getSupplierByAccount(long accountid) throws AdException{
		try {
			begin();
			Query q = getSession().createQuery("from SupplierBean where useraccountbean = :id");
			q.setParameter("id", accountid);
			SupplierBean supplierBean=(SupplierBean) q.uniqueResult();
			commit();
			return supplierBean;
		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while getting product: " + e.getMessage());
		}
	}
	public UserAccountBean get(String username)
			throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from useraccountbean where name = :username");
			q.setString("username", username);
			UserAccountBean user = (UserAccountBean) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + username, e);
		}
	}

	public SupplierBean create(String username, String password,String emailid,String contactnumber, String suppliername, String streetAddress,String city,String state,String country,String zipcode)
			throws AdException {
		try {
			begin();
			AddressBean addressBean=new AddressBean();
			addressBean.setCity(city);
			addressBean.setStreetAddress(streetAddress);
			addressBean.setState(state);
			addressBean.setCountry(country);
			addressBean.setZipcode(zipcode);
			getSession().save(addressBean);
			
			UserAccountBean accountBean=new UserAccountBean();
			accountBean.setContactnumber(contactnumber);
			accountBean.setEmailid(emailid);
			accountBean.setPassword(password);
			accountBean.setUsername(username);
			accountBean.setRole(RoleBean.Supplier);
			getSession().save(accountBean);
			
			SupplierBean supplierBean=new SupplierBean();
			supplierBean.setSuppliername(suppliername);
			supplierBean.setAddressBean(addressBean);
			supplierBean.setUserAccountBean(accountBean);
			getSession().save(supplierBean);
			
			commit();
			return  supplierBean;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	public void delete(UserAccountBean user)
			throws AdException {
		try {
			begin();
			getSession().delete(user);
			commit();
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not delete user " + user.getUsername(), e);
		}
	}
	public UserAccountBean validate(String username, String password)
			throws AdException {
		try {
			System.out.println("1");
			begin();
			Query query = getSession().createQuery("from UserAccountBean where username = :username and password= :password");
			query.setParameter("username", username);
			query.setParameter("password", password);
			System.out.println("the value is query"+query);
			UserAccountBean userAccountBean = (UserAccountBean) query.uniqueResult();
			commit();
			return userAccountBean;
		} 
		catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + username, e);
		}
	}
}