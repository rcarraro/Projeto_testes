package com.finalproject.ecommerceapp.validator;


import com.finalproject.ecommerceapp.pojos.ProductBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class ProductValidation implements Validator {

    @SuppressWarnings("rawtypes")
	public boolean supports(Class aClass)
    {
        return aClass.equals(ProductBean.class);
    }

    @SuppressWarnings("unused")
	public void validate(Object obj, Errors errors)
    {
        UserAccountBean newUserAccountBean = (UserAccountBean) obj;
     
    }
}