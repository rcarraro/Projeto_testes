package com.finalproject.ecommerceapp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import com.finalproject.ecommerceapp.dao.CartDao;
import com.finalproject.ecommerceapp.dao.CartItemDao;
import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.InvoiceDao;
import com.finalproject.ecommerceapp.dao.OrderDao;
import com.finalproject.ecommerceapp.dao.OrderItemDao;
import com.finalproject.ecommerceapp.dao.PaymentDao;
import com.finalproject.ecommerceapp.dao.UserAccountBeanDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CartItemBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.OrderBean;
import com.finalproject.ecommerceapp.pojos.OrderItemBean;
import com.finalproject.ecommerceapp.pojos.PaymentBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;

@Controller
@RequestMapping("/checkOut.htm")
public class CartCheckOutController{
	
    @RequestMapping(method = RequestMethod.GET)
    public String showForm(ModelMap model,HttpSession session){
   
    	CustomerBean customerBean = (CustomerBean) session.getAttribute("customer");
    	if(customerBean.getCartItems().isEmpty()){
    		return "customerHome";
    	}
    	PaymentBean paymentBean = new PaymentBean();
    	model.addAttribute("paymentBean",paymentBean);
    	float totalPrice = 0;
    	for(CartItemBean cartItemBean : customerBean.getCartItems()){
    		totalPrice = totalPrice + cartItemBean.getPrice();
    	}
    	float tax = 0.14f * totalPrice;
    	float bill = totalPrice + tax; 
    	model.addAttribute("price", totalPrice);
    	model.addAttribute("tax", tax);
    	model.addAttribute("totalPrice", bill);
    	session.setAttribute("customer", customerBean);
    	return "checkOutPage";
    }
    
    
   @RequestMapping(method = RequestMethod.POST)
    protected String doSubmitAction(@ModelAttribute("paymentBean") PaymentBean paymentBean,HttpSession session, BindingResult result,SessionStatus status) throws Exception
    {
	   try{
        	status.setComplete();
        	UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    		UserAccountBeanDao uabd = new UserAccountBeanDao();
    		UserAccountBean uab = uabd.get(userDetails.getUsername());
    		CustomerBean customerBean = uabd.getCustomerbyUserAccountID(uab.getUseraccountid());
	    	OrderBean orderBean = new OrderBean();
	    	orderBean.setCustomerBean(customerBean);
	    	orderBean.setOrderDate(new Date());
	    	
	    	OrderItemDao orderItemDAO = new OrderItemDao();
	    	Set<CartItemBean> itemList = new HashSet<CartItemBean>();
	    	
	    	for(CartItemBean c : customerBean.getCartItems()){
	    		
	    		OrderItemBean o = new OrderItemBean();
	    		o.setprice(c.getPrice());
	    		o.setProduct(c.getProductBean());
	    		o.setQuantity(c.getQuantity());
	    		orderItemDAO.addOrderItem(o);
	    		itemList.add(c);
	    		orderBean.createAndAddOrderItem(o);
	    	}
	    	

	    	orderBean.setTotalPrice(orderBean.totalPrice());
	    	orderBean.generateInvoice(0.06f);
	    	
	    	InvoiceDao invoiceDAO = new InvoiceDao();
	    	invoiceDAO.addInvoice(orderBean.getInvoiceBean());
	    	
	    	PaymentDao paymentDao = new PaymentDao();
	    	paymentBean.setInvoiceBean(orderBean.getInvoiceBean());
	    	
	    	paymentDao.addPayment(paymentBean);
	    	OrderDao orderDao = new OrderDao();
	    	orderDao.addOrder(orderBean);
	    	
	    	CartDao cartDao = new CartDao();
	    	customerBean = cartDao.clearShoppingCart(customerBean);
	    	
	    	CartItemDao cartItemDAO = new CartItemDao();
	    	for(CartItemBean c : itemList){
	    		itemList.add(c);
	    		cartItemDAO.deleteCartItem(c);
	    	}
	    	
	    	DAO.close();
	    	session.setAttribute("customerBean",customerBean);
	    	session.setAttribute("orderBean",orderBean);
	    	return "getInvoice";
			} catch (AdException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "checkOutPage";
			}
    }
}
