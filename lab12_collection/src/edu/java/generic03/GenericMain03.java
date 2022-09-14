package edu.java.generic03;

public class GenericMain03 {

    public static void main(String[] args) {
        // Integer를 저장하는 Box 객체를 생성
        Box<Integer> intBox = new Box<>();
        intBox.put(Integer.valueOf(0));
        System.out.println(intBox.get());
        
        // Box<int> box;
        // -> 타입 파라미터 자리에 기본 타입을 사용할 수 없음!
        
        
        // String 을 저장하는 Box 객체 생성
        Box<String> strBox = new Box<>();
        strBox.put("문자열");
        System.out.println(strBox.get());
        
        // Integer, String 을 타입 파라미터로 갖는 GenericCls 타입 객체를 생성
        GenericCls<Integer, String> test1 = new GenericCls<>(1, "문자열");
        System.out.println(test1.getItem1());
        System.out.println(test1.getItem2());
        
        // String, Box<String> 을 타입 파라미터로 갖는 GenericCls 타입 객체를 생성
        GenericCls<String,Box<String>>test2 = new GenericCls<>("테스트", strBox);
        System.out.println(test2.getItem1());
        System.out.println(test2.getItem2().get());
        
        
        
        
    }
}
