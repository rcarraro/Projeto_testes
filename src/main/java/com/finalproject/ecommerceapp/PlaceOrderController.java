package com.finalproject.ecommerceapp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.finalproject.ecommerceapp.dao.CartDao;
import com.finalproject.ecommerceapp.dao.CartItemDao;
import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.InvoiceDao;
import com.finalproject.ecommerceapp.dao.OrderDao;
import com.finalproject.ecommerceapp.dao.OrderItemDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CartItemBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.OrderBean;
import com.finalproject.ecommerceapp.pojos.OrderItemBean;

@Controller
@RequestMapping("placeOrder.htm")
public class PlaceOrderController {
	@RequestMapping(method = RequestMethod.GET)
	public String placedOrder(ModelMap model,HttpSession session) throws AdException{
		try {
			CustomerBean customerBean = (CustomerBean) session.getAttribute("customer");
			OrderBean orderBean = new OrderBean();
			orderBean.setCustomerBean(customerBean);
			orderBean.setOrderDate(new Date());

			OrderItemDao orderItemDao = new OrderItemDao();
			Set<CartItemBean> cartItems = new HashSet<CartItemBean>();

			for(CartItemBean cartItemBean : customerBean.getCartItems()){

				OrderItemBean orderItemBean = new OrderItemBean();
				orderItemBean.setprice(cartItemBean.getPrice());
				orderItemBean.setProduct(cartItemBean.getProductBean());
				orderItemBean.setQuantity(cartItemBean.getQuantity());
				orderItemDao.addOrderItem(orderItemBean);
				cartItems.add(cartItemBean);
				orderBean.createAndAddOrderItem(orderItemBean);
			}


			orderBean.setTotalPrice(orderBean.totalPrice());
			//order.setItems(itemList);
			orderBean.generateInvoice(0.06f);

			InvoiceDao invoiceDao = new InvoiceDao();
			invoiceDao.addInvoice(orderBean.getInvoiceBean());

			OrderDao orderDao = new OrderDao();
			orderDao.addOrder(orderBean);

			CartDao cartDao = new CartDao();
			customerBean = cartDao.clearShoppingCart(customerBean);

			CartItemDao cartItemDao = new CartItemDao();
			for(CartItemBean cartItemBean : cartItems){
				cartItems.add(cartItemBean);
				cartItemDao.deleteCartItem(cartItemBean);
			}
			DAO.close();
			session.setAttribute("customer",customerBean);
			session.setAttribute("order",orderBean);
			return "generatedInvoice";
		} catch (AdException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "checkOutPage";
		}
	}

}
