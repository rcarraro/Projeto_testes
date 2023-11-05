package com.finalproject.ecommerceapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CategoryBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.ProductBean;
import com.finalproject.ecommerceapp.pojos.ReviewBean;
import com.finalproject.ecommerceapp.pojos.SupplierBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;

public class ProductDao extends DAO {

	public ProductDao() {
	}
	private static int  pageSize = 1;
	public void create(String name, String description,int price,int availability,String productPictureUrlString,SupplierBean supplier,CategoryBean category) throws AdException {
		try {
			begin();
			ProductBean productBean=new  ProductBean();
			productBean.setName(name);
			productBean.setDescription(description);
			productBean.setPrice(price);
			productBean.setAvailability(availability);
			productBean.setSupplierBean(supplier);
			productBean.setProductPictureUrlString(productPictureUrlString);
			productBean.setCategoryBean(category);
			getSession().save(productBean);

			commit();
		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}

	}

	public UserAccountBean validate(String username, String password)
			throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from UserAccount where userName = :username and password = :password");
			q.setString("username", username);
			q.setString("password", password);
			UserAccountBean user = (UserAccountBean) q.uniqueResult();
			commit();
			return user;
		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while creating user: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProductBean> list() throws AdException {
		try {
			begin();
			Query q = getSession().createQuery("from ProductBean");
			List<ProductBean> list = q.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not list the productss", e);
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
	@SuppressWarnings("unchecked")
	public List<ProductBean> getSearchList(String searchKeyword) throws AdException{
		try {
			begin();
			//			Query q = getSession().createQuery("from ProductBean where name = :searchKeyword");
			//			q.setParameter("searchKeyword", searchKeyword);
			Criteria cr=getSession().createCriteria(ProductBean.class);
			cr.add(Restrictions.ilike("name", "%"+searchKeyword+"%"));
			List<ProductBean> searchList=cr.list();
			commit();
			return searchList;
		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while searching products: " + e.getMessage());
		}
	}

	public ProductBean getProductById(long id) throws AdException{
		try {
			begin();
			Query q = getSession().createQuery("from ProductBean where productId = :id");
			q.setParameter("id", id);
			ProductBean productBean=(ProductBean) q.uniqueResult();
			commit();
			return productBean;
		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while getting product: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProductBean> getProductByCategory(String category) throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from ProductBean as p where p.categoryBean.category= :category");
			q.setParameter("category", category);
			List<ProductBean> resultProducts=q.list();
			commit();
			return resultProducts;
		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while getting product: " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProductBean> pageList(Long pageNumber) throws AdException {
		try {
			begin();
			//			Query q = getSession().createQuery("from ProductBean");
			//			q = q.setFirstResult((int) (pageSize * (pageNumber-1)));
			//			q.setMaxResults(pageSize);
			Criteria criteria = getSession().createCriteria(ProductBean.class);
			criteria.setFirstResult((int) ((pageNumber - 1) * pageSize));
			criteria.setMaxResults(pageSize);
			List<ProductBean> list = criteria.list();
			commit();
			return list;
		} catch (HibernateException e) {
			rollback();
			throw new AdException("Could not list the categories", e);
		}
	}

	@SuppressWarnings("unchecked")
	public List<ProductBean> getProductBySupplier(String supplier) throws AdException{
		try{
			begin();
			Query q = getSession().createQuery("from ProductBean as p where p.supplierBean.suppliername= :supplier");
			q.setParameter("supplier", supplier);
			List<ProductBean> resultProducts=q.list();
			commit();
			return resultProducts;
		} catch (HibernateException e) {
			rollback();
			//throw new AdException("Could not create user " + username, e);
			throw new AdException("Exception while getting product: " + e.getMessage());
		}
	}

	public void updateProduct(long productId,String name,String description,int price,int availability,String pictureUrlLink) throws AdException{
		try{
			begin();
			ProductBean productBean = (ProductBean)getSession().get(ProductBean.class, productId);
			productBean.setAvailability(availability);
			productBean.setDescription(description);
			productBean.setName(name);
			productBean.setPrice(price);
			productBean.setProductPictureUrlString(pictureUrlLink);
			getSession().update(productBean);
			commit();
		}catch(HibernateException e){
			rollback();
			throw new AdException("Exception while updating product:"+e.getMessage());
		}

	}
	public void deleteProductByProductId(long productId) throws AdException{
		try{
			begin();
			ProductBean productBean = (ProductBean)getSession().get(ProductBean.class, productId);
			getSession().delete(productBean);
			commit();
		}catch(HibernateException e){
			rollback();
			throw new AdException("Exception while deleting product:"+e.getMessage());
		}

	}
	
	public void addProductReview(long productId,CustomerBean customer,String review) throws AdException{
		try{
			begin();
			ProductBean productBean=(ProductBean)getSession().get(ProductBean.class,productId);
			ReviewBean reviewBean=new ReviewBean(review,customer);
			getSession().save(reviewBean);
			productBean.getReviews().add(reviewBean);
			getSession().update(productBean);
			commit();
		}catch(HibernateException e){
			rollback();
			throw new AdException("Exception while adding review:"+e.getMessage());
		}
	}

}



