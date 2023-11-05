
package com.finalproject.ecommerceapp.validator;


import com.finalproject.ecommerceapp.pojos.UserAccountBean;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import org.springframework.validation.ValidationUtils;
@Component
public class UserAccountValidation implements Validator {

    @SuppressWarnings("rawtypes")
	public boolean supports(Class aClass)
    {
        return aClass.equals(UserAccountBean.class);
    }

    @SuppressWarnings("unused")
	public void validate(Object obj, Errors errors)
    {
        UserAccountBean newUserAccountBean = (UserAccountBean) obj;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "error.invalid.user", "User Name Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.invalid.password", "Password Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "emailid", "error.invalid.emailid", "Email ID Required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "contactnumber", "error.invalid.contactnumber", "Contact Number Required");
    }
}
