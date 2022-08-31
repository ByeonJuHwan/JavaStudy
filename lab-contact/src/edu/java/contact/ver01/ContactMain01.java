package edu.java.contact.ver01;

import java.util.Scanner;

public class ContactMain01 {
    private Scanner scanner;
    
    public ContactMain01() {
        scanner = new Scanner(System.in);
    }

    public static void main(String[] args) {
        boolean run = true;    // 프로그램을 계속 실행할 지, 종료할 지를 결정하기 위한 변수.
        // static이 아닌 메서드들을 호출하기 위해서 객체를 생성할 필요가 있음.
        ContactMain01 app = new ContactMain01();
        
        System.out.println("****연락처 프로그램 Version 0.1****");
        
        while(run) {
            // 메인 메뉴 보여 주기
            app.showMainMenu();
            //  메뉴 입력
            int menu = Integer.parseInt(app.scanner.nextLine());
            // TODO 3 : switch - case
            switch(menu) {
            case 0 : // 종료
                run = false;
                System.out.println();
                break;
            }
            // TODO 4 : run -> false;
        }
        System.out.println("***프로그램 종료***");
    } //end main
    
    private void showMainMenu() {
        System.out.println();
        System.out.println("-------------------------------------------------------------");
        System.out.println("[1] 전체리스트 [2] 인덱스검색 [3] 새 연락처 [4] 수정 [0] 종료");
        System.out.println("-------------------------------------------------------------");
        System.out.print("메뉴 선택> ");
    }
    
    
    
}// end class
