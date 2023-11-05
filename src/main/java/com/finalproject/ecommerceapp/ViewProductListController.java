package com.finalproject.ecommerceapp;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.ProductDao;
import com.finalproject.ecommerceapp.dao.SupplierAccountDao;
import com.finalproject.ecommerceapp.dao.UserAccountBeanDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.ProductBean;
import com.finalproject.ecommerceapp.pojos.SupplierBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;
import com.finalproject.ecommerceapp.validator.ProductValidation;


@Controller
@RequestMapping("/viewProducts.htm")
public class ViewProductListController{

	ProductValidation productValidation;

	@Autowired
	public ViewProductListController(ProductValidation productValidation){
		this.productValidation = productValidation;
	}

	@RequestMapping(method = RequestMethod.GET)
	public String showForm(ModelMap model,HttpSession session) throws AdException{
		ProductDao productDao=new ProductDao();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		
		
		UserAccountBeanDao uabd = new UserAccountBeanDao();
		UserAccountBean uab = uabd.get(userDetails.getUsername());
		
		SupplierAccountDao sad = new SupplierAccountDao();
		
		SupplierBean supplier = sad.getSupplierByAccount(uab.getUseraccountid());
		//SupplierBean supplierBean=(SupplierBean) session.getAttribute("supplier");
		
		String supplierName=supplier.getSuppliername();
		List<ProductBean> products=productDao.getProductBySupplier(supplierName);
		model.addAttribute("products", products);
		DAO.close();
		return "viewProducts";
	}
}