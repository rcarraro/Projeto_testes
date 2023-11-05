package com.finalproject.ecommerceapp;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.finalproject.ecommerceapp.pojos.CustomerBean;
import com.finalproject.ecommerceapp.pojos.OrderBean;
import com.finalproject.ecommerceapp.pojos.OrderItemBean;
import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Table;
import com.lowagie.text.pdf.PdfWriter;



public class InvoicePDF extends AbstractPdfView
{

	@SuppressWarnings("unused")
	@Override
	protected void buildPdfDocument(Map<String, Object> map, Document document,
			PdfWriter arg2, HttpServletRequest arg3, HttpServletResponse arg4)
			throws Exception {
		
		OrderBean orderBean = (OrderBean) map.get("orderBean");
		CustomerBean customerBean = (CustomerBean) map.get("customer");
		
		Paragraph h1 = new Paragraph("Final Details of your order # " + orderBean.getOrderID());
		Paragraph h2 = new Paragraph("Order Date : " + orderBean.getInvoiceBean().getDate());
		Paragraph h3 = new Paragraph("Invoice Number : " + orderBean.getInvoiceBean().getInvoiceid());
		Paragraph h4 = new Paragraph("Order Total : $" + orderBean.getInvoiceBean().getTotalAmount());
		
		
		
		Table table = new Table(5);
		table.addCell("Sl. No.");
		table.addCell("Product Name");
		table.addCell("Quantity");
		table.addCell("Unit Price");
		table.addCell("Price");
		
		int counter = 1;
		for (OrderItemBean orderItemBean : orderBean.getOrderItems()) {
			table.addCell(String.valueOf(counter));
			table.addCell(orderItemBean.getProduct().getName());
			table.addCell(String.valueOf(orderItemBean.getQuantity()));
			table.addCell("$" + String.valueOf(orderItemBean.getProduct().getPrice()));
			table.addCell("$" + String.valueOf(orderItemBean.getprice()));
			counter++;
        }
 
		Paragraph l1 = new Paragraph("\n \n Cost of Items : $" + orderBean.getInvoiceBean().getCostOfOrder());
		Paragraph l2 = new Paragraph("\n Tax : $" + orderBean.getInvoiceBean().getTaxDue());
		Paragraph l3 = new Paragraph("\n Total : $" + orderBean.getInvoiceBean().getTotalAmount());
		
		Paragraph l4 = new Paragraph("\n \n MY ECOMMERCE SITE \n 15 shepherd ave, \n Boston \n MA-02215\n");
		
		h1.setAlignment("center");
		l1.setAlignment("right");
		l2.setAlignment("right");
		l3.setAlignment("right");
		l4.setAlignment("right");
		
		document.add(h1);		
		document.add(h2);
		document.add(h3);
		document.add(h4);

		document.add(table);
		
		document.add(l1);		
		document.add(l2);
		document.add(l3);
		document.add(l4);
		document.close();
		System.out.println("file created");
	}

}
