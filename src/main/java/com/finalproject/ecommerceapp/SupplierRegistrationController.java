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
import com.finalproject.ecommerceapp.dao.SupplierAccountDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.SupplierBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;
import com.finalproject.ecommerceapp.validator.UserAccountValidation;

@Controller
@RequestMapping( "/supplierRegistration.htm")
public class SupplierRegistrationController {
	UserAccountValidation accountValidation;
	@RequestMapping(method = RequestMethod.GET)
	public String viewRegistration(ModelMap model) {
		SupplierBean supplierBean=new SupplierBean();   
		model.addAttribute("supplierBean", supplierBean);         
		return "supplierRegistration";
	}
	@Autowired
	public SupplierRegistrationController(UserAccountValidation accountValidation){
		this.accountValidation=accountValidation;
	}
	@RequestMapping(method = RequestMethod.POST)
	public String processRegistration(@ModelAttribute("supplierBean") SupplierBean supplierBean, BindingResult result, SessionStatus status) {
		try
		{

			status.setComplete();
			SupplierAccountDao supplierAccountDao=new SupplierAccountDao();
			UserAccountBean supplier = supplierAccountDao.validate(supplierBean.getUserAccountBean().getUsername(), supplierBean.getUserAccountBean().getPassword()); 
			if(supplier != null){ 
				return "supplierRegistration"; 
			} else { 
				supplierAccountDao.create(supplierBean.getUserAccountBean().getUsername(), supplierBean.getUserAccountBean().getPassword(),supplierBean.getUserAccountBean().getEmailid(),supplierBean.getUserAccountBean().getContactnumber(),supplierBean.getSuppliername(),
						supplierBean.getAddressBean().getStreetAddress(),supplierBean.getAddressBean().getCity(),supplierBean.getAddressBean().getState(),supplierBean.getAddressBean().getCountry(),supplierBean.getAddressBean().getZipcode());
				DAO.close();
				return "adminWelcomePage";
			}

		}
		catch (AdException e)
		{
			System.out.println("Exception: " + e.getMessage());
			return null;
		}
	}
}
