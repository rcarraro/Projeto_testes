package com.finalproject.ecommerceapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.UserAccountBeanDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;
import com.finalproject.ecommerceapp.validator.UserAccountValidation;

@Controller
@RequestMapping( "/account/registration.htm")
public class CustomerRegisterController {
	UserAccountValidation accountValidation;
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(ModelMap model) {
		CustomerBean customerBean=new CustomerBean();   
		model.addAttribute("customerBean", customerBean);         
		return "registration";
	}
	@Autowired
	public CustomerRegisterController(UserAccountValidation accountValidation){
		this.accountValidation=accountValidation;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("customerBean") CustomerBean customerBean, BindingResult result, SessionStatus status) {
		try
		{

			status.setComplete();
			UserAccountBeanDao userAccountBeanDao = new UserAccountBeanDao(); 
			UserAccountBean user = userAccountBeanDao.validate(customerBean.getUserAccountBean().getUsername(), customerBean.getUserAccountBean().getPassword()); 
			if(user != null){ 
				return "UserAlreadyExistPage"; 
			} else { 
				userAccountBeanDao.create(customerBean.getUserAccountBean().getUsername(), customerBean.getUserAccountBean().getPassword(),customerBean.getUserAccountBean().getEmailid(),customerBean.getUserAccountBean().getContactnumber(),customerBean.getCustomerfirstname(),
						customerBean.getCustomerlastname(),customerBean.getAddress().getStreetAddress(),customerBean.getAddress().getCity(),customerBean.getAddress().getState(),customerBean.getAddress().getCountry(),customerBean.getAddress().getZipcode());
				
				DAO.close();
				return "loginpage";
			}

		}
		catch (AdException e)
		{
			System.out.println("Exception: " + e.getMessage());
			return "registration";
		}
	}
}