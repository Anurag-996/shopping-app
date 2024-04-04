package Assignment.Entities;

import java.time.LocalDateTime;

public class CustomOrderResponse {
    private Long orderId;

    private double amount;

    private  LocalDateTime dateTime;

    private String coupon;

    private String transactionId;

    private int statusCode;

    private String name;

    private String emailId;

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public CustomOrderResponse(Long orderId, double amount, LocalDateTime dateTime, String coupon, String transactionId,
            int statusCode, String name, String emailId) {
        this.orderId = orderId;
        this.amount = amount;
        this.dateTime = dateTime;
        this.coupon = coupon;
        this.transactionId = transactionId;
        this.statusCode = statusCode;
        this.name = name;
        this.emailId = emailId;
    }

    
    
    
    
}
