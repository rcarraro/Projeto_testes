package com.finalproject.ecommerceapp;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalproject.ecommerceapp.dao.CategoryDao;
import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.ProductDao;
import com.finalproject.ecommerceapp.dao.UserAccountBeanDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CategoryBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.ProductBean;
import com.finalproject.ecommerceapp.pojos.ReviewBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;

@Controller
@RequestMapping("/productDetails.htm")
public class ProductDetailsController {
	@SuppressWarnings("unused")
	@RequestMapping(method = RequestMethod.GET)
	public String form2(@RequestParam(value = "productId", required = false) long id,ModelMap model,HttpSession session) throws AdException{
		model.addAttribute("productId",id);
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserAccountBeanDao uabd = new UserAccountBeanDao();
		UserAccountBean uab = uabd.get(userDetails.getUsername());
		CustomerBean customerBean = uabd.getCustomerbyUserAccountID(uab.getUseraccountid());
		model.addAttribute("customer", customerBean);	
		ProductDao productDao = new ProductDao();
		ProductBean product = productDao.getProductById(id);
		model.addAttribute("product",product);
		CategoryDao categorydao = new CategoryDao();
		List<CategoryBean> categoryList = categorydao.list();
		model.addAttribute("categories", categoryList);
		ReviewBean reviewBean=new ReviewBean();
		model.addAttribute("reviewBean",reviewBean);
		session.setAttribute("product", product);
		
		DAO.close();
		return "productDetails";
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public String addProductReview(@ModelAttribute("reviewBean") ReviewBean reviewBean,ModelMap model,HttpSession session) throws AdException{
		
		ProductBean product = (ProductBean) session.getAttribute("product");
		
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserAccountBeanDao uabd = new UserAccountBeanDao();
		UserAccountBean uab = uabd.get(userDetails.getUsername());
		CustomerBean customerBean = uabd.getCustomerbyUserAccountID(uab.getUseraccountid());
		
		
		ProductDao productDao = new ProductDao();
		String review = reviewBean.getReview();
		productDao.addProductReview(product.getProductId(), customerBean, review);
		CategoryDao categorydao = new CategoryDao();
		List<CategoryBean> categoryList = categorydao.list();
		model.addAttribute("categories", categoryList);
		session.removeAttribute("product");
		model.addAttribute("product",product);
		model.addAttribute("customer", customerBean);
		DAO.close();
		return "customerHome";
}
}
