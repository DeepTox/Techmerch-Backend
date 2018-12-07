package com.techmerch.model;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name="orders")
public class Order implements Serializable {

    private static final long serialVersionUID = -3216025183968635660L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Date orderEtaDate;
    private String orderStatus;
    private String orderReference;
    private String orderShippingAddress;
    private Double orderAmount;
    @Column(nullable = false, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @CreatedDate
    private Date orderCreationDate;
    private String orderClientId;
    @Column(nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    @LastModifiedDate
    private Date orderUpdateDate;
    private String orderProducts;
    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Date getOrderEtaDate() {
        return orderEtaDate;
    }

    public void setOrderEtaDate(Date orderEtaDate) {
        this.orderEtaDate = orderEtaDate;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Date getOrderCreationDate() {
        return orderCreationDate;
    }

    public void setOrderCreationDate(Date orderCreationDate) {
        this.orderCreationDate = orderCreationDate;
    }

    public String getOrderClientId() {
        return orderClientId;
    }

    public void setOrderClientId(String orderClientId) {
        this.orderClientId = orderClientId;
    }

    public Date getOrderUpdateDate() {
        return orderUpdateDate;
    }

    public void setOrderUpdateDate(Date orderUpdateDate) {
        this.orderUpdateDate = orderUpdateDate;
    }

    public String getOrderReference() {
        return orderReference;
    }
    public void setOrderReference(String orderReference) {
        this.orderReference = orderReference;
    }

    public String getOrderProducts() {
        return orderProducts;
    }

    public void setOrderProducts(String orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getOrderShippingAddress() {
        return orderShippingAddress;
    }

    public void setOrderShippingAddress(String orderShippingAddress) {
        this.orderShippingAddress = orderShippingAddress;
    }

    public Double getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Double orderAmount) {
        this.orderAmount = orderAmount;
    }
}
