package com.finalproject.ecommerceapp.pojos;

public enum RoleBean { 
	    Customer, Admin, Supplier;  
	    public static String getRoleName(RoleBean role){  
		  switch (role){  
		   case Customer : return "Customer";  
		   case Admin : return "Admin";  
		   case Supplier:return "Supplier";
		   default : return null;  
		  }  
		 }  
}
