package edu.java.inner03;

public class BuilderExample {

    public static void main(String[] args) {
        // Book 타입 변수 선언, 객체 생성
        // 생성자를 사용한 객체 생성
        Book book1 = new Book("하얼빈", "장첸", "니 내 눈지 아니?");
        System.out.println(book1);
        
        Book book2 = new Book("김훈", "소설", "하얼빈");
        System.out.println(book2);
        
        // Builder/Factory 패턴을 사용한 객체 생성
        Book book3 = Book.builder()
                .author("김훈")
                .category("소설")
                .title("하얼빈")
                .build();
        System.out.println(book3);
        
        Book book4 = Book.builder()
                .title("하얼빈")
                .author("김훈")
                .category("소설")
                .build();
        System.out.println(book4);
    
    
        // 생성자 패턴
        Book book5 = new Book("우영우", null, null);
        System.out.println(book5);
        
        // Builder/Factory 패턴
        Book book6 = Book.builder().title("우영우").build();
        System.out.println(book6);
    
        
    }
}
