package com.finalproject.ecommerceapp.validator;


import com.finalproject.ecommerceapp.pojos.CategoryBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoryValidation implements Validator {

    @SuppressWarnings("rawtypes")
	public boolean supports(Class aClass)
    {
        return aClass.equals(CategoryBean.class);
    }

    @SuppressWarnings("unused")
	public void validate(Object obj, Errors errors)
    {
        UserAccountBean newUserAccountBean = (UserAccountBean) obj;
     
    }
}