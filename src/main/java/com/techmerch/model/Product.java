package com.techmerch.model;



import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
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
    @ManyToOne
    @JoinColumn(name = "subcategoryId")
    private SubCategory productSubCategory;

    private String productImgurl;

    private Boolean productAvailability;
    @Column(columnDefinition = "double(2,1) default '0.0'")
    private Double productRate;
    @Column(columnDefinition = "int(3) default '0'")
    @Min(0)
    @Max(100)
    private int productDiscount;

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

    public SubCategory getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(SubCategory productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public void setProductImgurl(String productImgurl) {
        this.productImgurl = productImgurl;
    }

    public Boolean getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(Boolean productAvailability) {
        this.productAvailability = productAvailability;
    }

    public Double getProductRate() {
        return productRate;
    }

    public void setProductRate(Double productRate) {
        this.productRate = productRate;
    }

    public int getProductDiscount() {
        return productDiscount;
    }

    public void setProductDiscount(int productDiscount) {
        this.productDiscount = productDiscount;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productPrice=" + productPrice +
                ", productDescription='" + productDescription + '\'' +
                ", productCategory=" + productCategory +
                ", productSubCategory=" + productSubCategory +
                ", productImgurl='" + productImgurl + '\'' +
                ", productAvailability=" + productAvailability +
                ", productRate=" + productRate +
                ", productDiscount=" + productDiscount +
                '}';
    }
}
