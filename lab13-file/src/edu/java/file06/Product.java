package edu.java.file06;

import java.io.Serializable;

// ObjcetInputStream, ObjectOutputSteram에서 사용되는 클래스는 Serializable을 구현해야함.
// 재정의(oberride) 해야 하는 메서드는 없음.
public class Product implements Serializable{
    // field
    private int productId;
    private String productName;
    private int productPrice;
    
    // 생성자
    public Product() {}

    public Product(int productId, String productName, int productPrice) {
        this.productId = productId;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    // getters/setters
    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(int productPrice) {
        this.productPrice = productPrice;
    }
    
    @Override
    public String toString() {
        
        return String.format("Product(productId=%d, productName=%s, productPrice=%d)", productId,productName,productPrice);
    }
    
    
}
