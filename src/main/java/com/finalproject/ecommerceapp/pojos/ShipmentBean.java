package com.finalproject.ecommerceapp.pojos;

import java.util.ArrayList;


public class ShipmentBean {
    
    private long shipmentTrackingID;
    private static int count;
    private String shipmentstatus;
    private AddressBean address;
    private ArrayList<OrderItemBean> orderItem;
    java.util.Date date= new java.util.Date();
    private String shippedDate=String.valueOf(date);
    private String deliveredDate=String.valueOf(date);
    private String deliveryComments;
    
    public ShipmentBean(){
        count++;
        shipmentTrackingID=count;
    }

    public long getShipmentTrackingID() {
        return shipmentTrackingID;
    }

    public void setShipmentTrackingID(long shipmentTrackingID) {
        this.shipmentTrackingID = shipmentTrackingID;
    }

    public String getShipmentstatus() {
        return shipmentstatus;
    }

    public void setShipmentstatus(String shipmentstatus) {
        this.shipmentstatus = shipmentstatus;
    }

    public AddressBean getAddress() {
        return address;
    }

    public void setAddress(AddressBean address) {
        this.address = address;
    }

    public ArrayList<OrderItemBean> getOrderItem() {
        return orderItem;
    }

    public void setOrderItem(ArrayList<OrderItemBean> orderItem) {
        this.orderItem = orderItem;
    }

    public String getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(String shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getDeliveredDate() {
        return deliveredDate;
    }

    public void setDeliveredDate(String deliveredDate) {
        this.deliveredDate = deliveredDate;
    }

    public String getDeliveryComments() {
        return deliveryComments;
    }

    public void setDeliveryComments(String deliveryComments) {
        this.deliveryComments = deliveryComments;
    }
    
    
}
