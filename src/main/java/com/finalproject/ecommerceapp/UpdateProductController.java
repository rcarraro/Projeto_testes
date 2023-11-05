package com.finalproject.ecommerceapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.ProductDao;
import com.finalproject.ecommerceapp.dao.SupplierAccountDao;
import com.finalproject.ecommerceapp.dao.UserAccountBeanDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CategoryBean;
import com.finalproject.ecommerceapp.pojos.ProductBean;
import com.finalproject.ecommerceapp.pojos.SupplierBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;

@Controller
public class UpdateProductController {
	@RequestMapping(value = "/updateProduct.htm" ,method = RequestMethod.GET)
	public String getUpdateProduct(@RequestParam(value = "productId", required = false) long productId,ModelMap model) throws AdException{
		model.addAttribute("productId",productId);
		ProductDao productDao = new ProductDao();
		ProductBean productBean = productDao.getProductById(productId);
		model.addAttribute("product",productBean);
		com.finalproject.ecommerceapp.dao.CategoryDao categoryDao = new com.finalproject.ecommerceapp.dao.CategoryDao();
		java.util.List<CategoryBean> categoryList = categoryDao.list();
		model.addAttribute("categories", categoryList);
		DAO.close();
		return "updateProduct";
		
		
		
	
		
		
		
		
	}	
	@RequestMapping(value="/updateProduct.htm", method=RequestMethod.POST)
	public String updateProduct(@RequestParam String action, @ModelAttribute("product") ProductBean productBean, BindingResult result, SessionStatus status,HttpSession session,ModelMap model) throws AdException{
		if( action.equals("Update") ){
			ProductDao productDao=new ProductDao();
			long productId=productBean.getProductId();
			String name=productBean.getName();
			String description=productBean.getDescription();
			int price=productBean.getPrice();
			int availability=productBean.getAvailability();
			String pictureUrlLink=productBean.getProductPictureUrlString();
			productDao.updateProduct(productId,name,description,price,availability,pictureUrlLink);

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			
			UserAccountBeanDao uabd = new UserAccountBeanDao();
			UserAccountBean uab = uabd.get(userDetails.getUsername());
			
			SupplierAccountDao sad = new SupplierAccountDao();
			
			SupplierBean supplier = sad.getSupplierByAccount(uab.getUseraccountid());
			
			
			String supplierName=supplier.getSuppliername();
			List<ProductBean> products=productDao.getProductBySupplier(supplierName);
			model.addAttribute("products", products);
			DAO.close();
			return "viewProducts";
		}
		else if( action.equals("Delete") ){
			ProductDao productDao=new ProductDao();
			long productId=productBean.getProductId();
			productDao.deleteProductByProductId(productId);

			UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			
			
			UserAccountBeanDao uabd = new UserAccountBeanDao();
			UserAccountBean uab = uabd.get(userDetails.getUsername());
			
			SupplierAccountDao sad = new SupplierAccountDao();
			
			SupplierBean supplier = sad.getSupplierByAccount(uab.getUseraccountid());
			
			
			String supplierName=supplier.getSuppliername();
			List<ProductBean> products=productDao.getProductBySupplier(supplierName);
			model.addAttribute("products", products);
			DAO.close();
			return "viewProducts";
		}
		return null;
	} 
}
