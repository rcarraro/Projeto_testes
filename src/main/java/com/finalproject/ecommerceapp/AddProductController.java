package com.finalproject.ecommerceapp;


import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.CategoryDao;
import com.finalproject.ecommerceapp.dao.ProductDao;
import com.finalproject.ecommerceapp.dao.SupplierAccountDao;
import com.finalproject.ecommerceapp.dao.UserAccountBeanDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CategoryBean;
import com.finalproject.ecommerceapp.pojos.ProductBean;
import com.finalproject.ecommerceapp.pojos.SupplierBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;
import com.finalproject.ecommerceapp.validator.ProductValidation;


@Controller
@RequestMapping("/addProduct.htm")
public class AddProductController{

ProductValidation productValidation;
    
@Autowired
public AddProductController(ProductValidation productValidation){
    this.productValidation = productValidation;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap model){
    	try{
    	CategoryDao categorydao = new CategoryDao();
		List<CategoryBean> categoryList = categorydao.list();
		model.addAttribute("categories", categoryList);}
    	catch (Exception ex){}
    ProductBean productBean= new ProductBean();
    model.addAttribute("productBean", productBean);
    return "addProduct";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("productBean") ProductBean productBean,BindingResult result,SessionStatus status,HttpSession session) throws Exception
    {
        try
        {	
        status.setComplete();

        CategoryDao categoryDao = new CategoryDao();
       
        CategoryBean categoryBean = categoryDao.get(productBean.getCategoryBean().getCategory());
        ProductDao productDao = new ProductDao();
       
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserAccountBeanDao uabd = new UserAccountBeanDao();
		UserAccountBean uab = uabd.get(userDetails.getUsername());
		SupplierAccountDao sad = new SupplierAccountDao();
		SupplierBean supplier = sad.getSupplierByAccount(uab.getUseraccountid());
                productDao.create(productBean.getName(), productBean.getDescription(), productBean.getPrice(), productBean.getAvailability(), productBean.getProductPictureUrlString(),supplier,categoryBean);
                 
                DAO.close();
                return "supplierWelcomePage";
            
        }
        catch (AdException e)
        {
            System.out.println("Exception: " + e.getMessage());
            throw new AdException("Exception while adding product: " + e.getMessage());
        }
    }
}