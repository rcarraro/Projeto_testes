package com.finalproject.ecommerceapp;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.finalproject.ecommerceapp.dao.DAO;
import com.finalproject.ecommerceapp.dao.CategoryDao;
import com.finalproject.ecommerceapp.dao.ProductDao;
import com.finalproject.ecommerceapp.dao.UserAccountBeanDao;
import com.finalproject.ecommerceapp.exception.AdException;
import com.finalproject.ecommerceapp.pojos.CategoryBean;
import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.ProductBean;
import com.finalproject.ecommerceapp.pojos.UserAccountBean;

@Controller
public class CustomerStoreController {

	@RequestMapping(value = "/storeHome.htm" ,method = RequestMethod.GET)
	public String showForm(ModelMap model) throws AdException{
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		UserAccountBeanDao uabd = new UserAccountBeanDao();
		UserAccountBean uab = uabd.get(userDetails.getUsername());
		CustomerBean customerBean = uabd.getCustomerbyUserAccountID(uab.getUseraccountid());
		model.addAttribute("customer", customerBean);
		ProductDao productDao = new ProductDao();
		List<ProductBean> productList = productDao.list();
		model.addAttribute("products", productList);
		CategoryDao categorydao = new CategoryDao();
		List<CategoryBean> categoryList = categorydao.list();
		model.addAttribute("categories", categoryList);
		DAO.close();
		return "customerHome";
	}

	@RequestMapping(value = "/searchResults.htm" ,method = RequestMethod.GET)
	public String search(@RequestParam(value = "searchKey", required = false) String search,ModelMap model) throws AdException{
		model.addAttribute("searchKey",search);
		ProductDao productDao = new ProductDao();
		List<ProductBean> searchList = productDao.getSearchList(search);
		model.addAttribute("searchList",searchList);
		DAO.close();
		return "searchResults";
	}	
	
	@RequestMapping(value="/categoryOption.htm", method = RequestMethod.GET)
	public String getEmployees(@RequestParam(value = "categoryChoice", required = false) String categoryChoice, ModelMap model) throws AdException {
		model.addAttribute("categoryChoice",categoryChoice);
		String selectedCategory=categoryChoice;
		ProductDao productDao=new ProductDao();
		List<ProductBean> productListByCategory = productDao.getProductByCategory(categoryChoice);
		model.addAttribute("searchList", productListByCategory);
		model.addAttribute("selectedCategory",selectedCategory);
		DAO.close();
		return "searchResults";
	}

	@RequestMapping(value="/customerHome.htm", method = RequestMethod.GET)
	public String getEmployees(@RequestParam(value = "page", required = false) Long page, ModelMap model) throws AdException {
		int startpage = 1;
	    int endpage = startpage + 10;
	    CategoryDao categorydao = new CategoryDao();
		List<CategoryBean> categoryList = categorydao.list();
		model.addAttribute("categories", categoryList);
		ProductDao productDao=new ProductDao();
		model.addAttribute("productsperPage", productDao.pageList(page));
		model.addAttribute("startpage", startpage);
		model.addAttribute("endage", endpage);
		DAO.close();
		return "customerHome";
	}
	
	@RequestMapping(value = "/getProducts.htm", method = RequestMethod.GET)
	public @ResponseBody
	List<ProductBean> getProducts(@RequestParam String productName) throws AdException {
		System.out.println("in response");
		return simulateSearchResult(productName);
 
	}
 
	private List<ProductBean> simulateSearchResult(String productName) throws AdException {
		ProductDao productDao=new ProductDao();
		List<ProductBean> searchResult=new ArrayList<ProductBean>();
		for (ProductBean product : productDao.list()) {
			if (product.getName().contains(productName)) {
				searchResult.add(product);
			}
		}
		DAO.close();
		return searchResult;
	}
 
}
