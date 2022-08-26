package edu.java.class02;

public class ClassMain02 {

    public static void main(String[] args) {
        // Product 타입의 객체를 생성.
        Product prod1 = new Product(1234567, "신라면", 900);
        System.out.println(prod1.productName + " : " + prod1.price);
        
        // 신라면의 가격을 변경
        prod1.setPrice(1000);
        System.out.println(prod1.productName + " : " + prod1.price);
    }

}
