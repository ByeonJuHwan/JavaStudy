package edu.java.class02;

// 클래스의 멤버들 : 
// 1. 필드 (field) - 클래스의 객체들이 가질 수 있는 속성들(데이터). 변수.
// 2. 생성자 (constructor) - 객체를 생성하고 초기화.
// 3. 메서드(method) - 클래스의 객체들이 갖는 기능 (함수).

public class Product {

    // field
    int productId; // 상품 아이디
    String productName; // 상품 이름
    int price; // 상품 가격 
    
    // constructor
    public Product (int productId, String productName, int price) {
        this.price = price;
        this.productId = productId;
        this.productName = productName;
    }
    // 이렇게도 가능
//    public Product (int id, String name, int price) {
//        productId=id;
//        productName=name;
//        this.price = price;
//    }
    
    //method
    public void setPrice(int price) {
        this.price = price;
    }
}
