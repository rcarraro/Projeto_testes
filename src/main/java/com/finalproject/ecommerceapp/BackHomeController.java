package com.finalproject.ecommerceapp;



import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.SupplierBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;

@Controller
public class BackHomeController {
@RequestMapping(value = "/welcomeAdmin.htm" ,method = RequestMethod.GET)
public String adminHome(ModelMap model,HttpSession session) throws AdException{
	UserAccountBean user=(UserAccountBean)session.getAttribute("admin");
	String name=user.getUsername();
	model.addAttribute("name",name);
	return "adminWelcomePage";
}

@RequestMapping(value = "/welcomeSupplier.htm" ,method = RequestMethod.GET)
public String supplierHome(ModelMap model,HttpSession session) throws AdException{
	SupplierBean supplierBean=(SupplierBean)session.getAttribute("supplier");
	model.addAttribute("supplier",supplierBean);
	return "supplierWelcomePage";
}
}
