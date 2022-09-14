package edu.java.generic01;

public class GenericMain01 {

    public static void main(String[] args) {
        // AppleBox 타입 객체 생성
        AppleBox appleBox = new AppleBox();
        
        // 사과 상자에 사과 객체를저장
        Apple apple= new Apple("대구사과");

        appleBox.put(apple);
        
        // 사과 상자에서 사과 객체를 꺼냄
        System.out.println(appleBox.get().getType());

        
        //Orange 타입의 개게 형성
        OrangeBox orangeBox = new OrangeBox();
        
        // OrangeBox에 Orange 타입 객체 저장
        orangeBox.put(new Orange(90));
        
        // OrangeBox에 저장된 Orange객체를 냄
        System.out.println(orangeBox.get().getSugar());
    }

}
