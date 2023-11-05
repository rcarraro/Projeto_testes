package com.finalproject.ecommerceapp;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.CategoryDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CategoryBean;
import com.finalproject.ecommerceapp.validator.CategoryValidation;;

@Controller
@RequestMapping("/addCategory.htm")
public class AddCategoryController{

CategoryValidation categoryValidation;
    
@Autowired
public AddCategoryController(CategoryValidation categoryValidation){
    this.categoryValidation=categoryValidation;
    }

    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap model){
    CategoryBean categoryBean = new CategoryBean();
    model.addAttribute("categoryBean",categoryBean);
    return "addProductCategory";
    }
    
    @RequestMapping(method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("categoryBean") CategoryBean categoryBean,BindingResult result,SessionStatus status,HttpSession session) throws Exception
    {
        try
        {	
        status.setComplete();
       
        CategoryDao categoryDao = new CategoryDao();
        categoryDao.create(categoryBean.getCategory());
       
                DAO.close();
                return "adminWelcomePage";
            
        }
        catch (AdException e)
        {
            System.out.println("Exception: " + e.getMessage());
            throw new AdException("Exception while adding category: " + e.getMessage());
        }
    }
}