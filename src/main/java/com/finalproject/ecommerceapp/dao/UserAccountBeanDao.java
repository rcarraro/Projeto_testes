package com.finalproject.ecommerceapp.dao;



import org.hibernate.HibernateException;
import org.hibernate.Query;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.AddressBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.RoleBean;
import com.finalproject.ecommerceapp.pojos.SupplierBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;;

public class UserAccountBeanDao extends DAO {

	public UserAccountBeanDao() {
	}

	public UserAccountBean get(String username)
			throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from UserAccountBean where username = :username");
			q.setString("username", username);
			UserAccountBean user = (UserAccountBean) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + username, e);
		}
	}

	public void create(String username, String password,String emailid,String contactnumber, String customerfirstname, String customerlastname,String streetAddress,String city,String state,String country,String zipcode)
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
			accountBean.setRole(RoleBean.Customer);
			getSession().save(accountBean);
			
			CustomerBean customerBean=new CustomerBean();
			customerBean.setCustomerfirstname(customerfirstname);
			customerBean.setCustomerlastname(customerlastname);
			customerBean.setAddress(addressBean);
			customerBean.setUserAccountBean(accountBean);
			getSession().save(customerBean);
			
			commit();
			
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
	
	public CustomerBean getCustomerbyUserAccountID(long id) throws AdException{
		try {
			begin();
			Query query = getSession().createQuery("from CustomerBean as customer where customer.userAccountBean.useraccountid  = :id");
			query.setParameter("id", id);
			CustomerBean customerBean= (CustomerBean) query.uniqueResult();
			commit();
			System.out.print(customerBean.getCustomerfirstname());
			return customerBean;
		} 
		catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + id, e);
		}
	}
	
	public SupplierBean getSupplierbyUserAccountID(long id) throws AdException{
		try {
			begin();
			Query query = getSession().createQuery("from SupplierBean as supplier where supplier.userAccountBean.useraccountid  = :id");
			query.setParameter("id", id);
			SupplierBean supplierBean= (SupplierBean) query.uniqueResult();
			commit();
			System.out.print(supplierBean.getSuppliername());
			return supplierBean;
		} 
		catch (HibernateException e) {
			rollback();
			throw new AdException("Could not get user " + id, e);
		}
	}
}