package com.techmerch.model;



import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="Products")
public class Product implements Serializable {
    private static final long serialVersionUID = 5556062608515567408L;

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long productId;

    private String productName;
    private Double productPrice;
    private String productDescription;

    @ManyToOne
    @JoinColumn(name = "categoryId")
    private Category productCategory;

    private String productImgurl;


    public Long getProductId() {
        return productId;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public Double getProductPrice() {
        return productPrice;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public Category getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(Category productCategory) {
        this.productCategory = productCategory;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setProductPrice(Double productPrice) {
        this.productPrice = productPrice;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }


    public String getProductImgurl() {
        return productImgurl;
    }

    public void setImgUrl(String imgurl) {
        this.productImgurl = imgurl;
    }
    @Override
    public String toString() {
        return "Product{" +
                "id=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice='" + productPrice + '\'' +
                ", productImgurl='" + productImgurl + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productCategory='" + productCategory + '\'' +
                '}';
    }
}
