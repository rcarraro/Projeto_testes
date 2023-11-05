package com.finalproject.ecommerceapp;


import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.finalproject.ecommerceapp.dao.CartDao;
import com.finalproject.ecommerceapp.dao.CartItemDao;
import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.ProductDao;
import com.finalproject.ecommerceapp.dao.SupplierAccountDao;
import com.finalproject.ecommerceapp.dao.UserAccountBeanDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CartItemBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.ProductBean;
import com.finalproject.ecommerceapp.pojos.SupplierBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;


@Controller
public class AddToCartController{

	@RequestMapping(value="/cart.htm" ,method = RequestMethod.GET)
	public String showCart(ModelMap model,HttpSession session){

		try{
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserAccountBeanDao uabd = new UserAccountBeanDao();
		UserAccountBean uab = uabd.get(userDetails.getUsername());
		CustomerBean customerBean = uabd.getCustomerbyUserAccountID(uab.getUseraccountid());
		
		session.setAttribute("customerBean", customerBean);}
		catch(Exception ex){return "error";}
		return "viewShoppingCart";
	}

	@RequestMapping(value = "/addToCart.htm" ,method = RequestMethod.GET)
	public String addToCart(@RequestParam(value = "prodID", required = false) long id,ModelMap model,HttpSession session) throws AdException{
		model.addAttribute("prodID",id);
		ProductDao productDao = new ProductDao();
		ProductBean productBean = productDao.getProductById(id);

		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserAccountBeanDao uabd = new UserAccountBeanDao();
		UserAccountBean uab = uabd.get(userDetails.getUsername());
		CustomerBean customerBean = uabd.getCustomerbyUserAccountID(uab.getUseraccountid());
		
		
		
		boolean counter = true;
		CartDao cartDao = new CartDao();
		CartItemDao cartItemDao = new CartItemDao();
		for(CartItemBean cartItemBean: customerBean.getCartItems()){
			System.out.println(cartItemBean.getProductBean().getName());
			if(cartItemBean.getProductBean().getProductId()==productBean.getProductId()){
				counter = false;
				cartItemBean.setQuantity(cartItemBean.getQuantity() + 1);
				cartItemBean.setPrice();
				cartDao.updateCart(cartItemBean);
				break;
			}
		}
		if(counter){
			CartItemBean cartItemBean = cartItemDao.addToCart(productBean);
			cartDao.addToCart(customerBean, cartItemBean);
		}
		session.setAttribute("customer", customerBean);
		DAO.close();
		return "addProductToCart";
	}

	@RequestMapping(value="/updateShoppingCart.htm",method = RequestMethod.GET)
	public String doSubmitAction(@RequestParam(value = "cartItemId", required = false) long cartItemId,HttpSession session) throws Exception
	{   	
		try{
			System.out.print(cartItemId);
			System.out.println("request received");
			CustomerBean customerBean = (CustomerBean) session.getAttribute("customer");
			CartDao cartDao = new CartDao();
			CartItemDao cartItemDao = new CartItemDao();
			CartItemBean cartItemBean = cartItemDao.getCartById(cartItemId);
			boolean isRemoved = cartDao.deleteItem(customerBean, cartItemBean);
			if(isRemoved){
				cartItemDao.deleteCartItem(cartItemBean);
			}
			session.setAttribute("customer", customerBean);
			DAO.close();
			return "addProductToCart";
		} catch(Exception e) {
			return "addProductToCart";
		}
	}
}
