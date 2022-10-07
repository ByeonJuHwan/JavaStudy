package edu.java.contact.ver03;

import java.util.List;
import java.util.Scanner;

import edu.java.contact.menu.MainMenu;

public class ContactMain03 {
        // field
        private Scanner scanner = new Scanner(System.in);
        private ContactDaoImpl dao = ContactDaoImpl.getInstance();
        
        public static void main(String[] args) {
            System.out.println("****연락처 프로그램 Version 0.3****");
            
            ContactMain03 app = new ContactMain03();
            
            boolean run = true;
            
            while(run) {
                // 메인 메뉴 보여주기
                
                int n = app.showMainMenu();
                
                MainMenu menu = MainMenu.getValue(n);
                switch(menu) {
                case QUIT:
                    run  = false;
                    break;
                case SELECT_ALL:
                     app.selectAllContacts();
                    break;
                case SELECT_BY_INDEX:
                    app.selectContactByIndex();
                    break;
                case CREATE:
                    app.insertNewContack();
                    break;
                case UPDATE:
                    app.updateContact();
                    break;
                case DELETE:
                    app.deleteContact();
                    break;
                default:
                        if(n== -1) {
                            System.out.println("0~5 사이의 정수를 입력해주세요.");
                        }else {
                        System.out.println("잘못된 메뉴를 선택하셨습니다.");
                        }
                }
            }
            System.out.println();
            System.out.println("***프로그램 종료***");
            
    } // end Main

        private int showMainMenu() {
            System.out.println();
            System.out.println("----------------------------------------------------------------------");
            System.out.println("[0] 종료 [1] 전체리스트 [2] 인덱스검색 [3] 새 연락처 [4] 수정 [5] 삭제");
            System.out.println("----------------------------------------------------------------------");
            System.out.print("메뉴 선택> ");
            try {
            int n = Integer.parseInt(scanner.nextLine());
                return n;
            }catch(NumberFormatException e) {
                return -1;
            }  
        }

        private void selectAllContacts() {
            List<Contact> contacts = dao.read();
            System.out.println("----연락처----");
            for(Contact c : contacts) {
                System.out.println(c);
            }
        }

        private void selectContactByIndex() {
           System.out.print("검색하고 싶은 인덱스를 입력해 주세요>> ");
           try {
               int index = Integer.parseInt(scanner.nextLine());
               Contact c = dao.read(index);
           
               if(index<0) {
                   System.out.println("0보다 큰 정수를 입력해주세요.");
               }else if(c==null) {
                   System.out.println("해당 인덱스에는 연락처가 없습니다.");
               }else {
                   System.out.println(c);
               }
            }catch(NumberFormatException e) {
                   System.out.println("0보다 큰 정수를 입력해주세요.");
            }
        }

        private void insertNewContack() {
            System.out.println("----새 연락처 추가----");
            System.out.print("이름을 입력해주세요>> ");
            String name = scanner.nextLine();
            System.out.print("번호를 입력해주세요>> ");
            String phone = scanner.nextLine();
            System.out.print("이메일을 입력해주세요>> ");
            String email = scanner.nextLine();
            
            Contact c = new Contact(name,phone,email);
            int result = dao.create(c);
            if(result == 1) {
                System.out.println("연락처를 등록했습니다.");
            }else {
                System.out.println("연락처를 등록하지못했습니다.");
            }
            
        }

        private void updateContact() {
            System.out.println("----연락처 수정----");
            System.out.print("수정하고 싶은 인덱스를 입력해주세요>> ");
            try {
                int index = Integer.parseInt(scanner.nextLine());
            
                if(index>=dao.getSize()) {
                    System.out.println("그 인덱스는 비어있습니다. 다시 입력해주세요.");
                    return;
                }else if(index<0) {
                System.out.println("0보다 큰 정수를 입력해주세요.");
                }else {
                    System.out.print("바꾸고 싶은 항목을 입력해주세요(2가지 항목 이상일경우 공백을 넣어주세요)>> ");
                    String command = scanner.nextLine();
            
                    int n = dao.upate(index, command);
            
                    if (n ==1 ) {
                        System.out.println("수정 성공하였습니다.");
                    }
                    else {
                        System.out.println("수정 실패하였습니다.");
                    }   
                }
            }catch(NumberFormatException e) {
                System.out.println("0보다큰 정수를 입력해주세요.");
            }
            
       }

        private void deleteContact() {
            System.out.println("----연락처 삭제----");
            System.out.print("삭제하고 싶은 인덱스를 입력해주세요>> ");
            try {
                int index = Integer.parseInt(scanner.nextLine());
                if(index>=dao.getSize()) {
                    System.out.println("그 인덱스는 비어있습니다. 다시 입력해주세요.");
                    return;
                }else if(index<0) {
                    System.out.println("0보다 큰 정수를 입력해주세요.");
                    return;
                }
            
                int result = dao.delete(index);
            
                if (result ==1 ) {
                    System.out.println("삭제 성공하였습니다.");
                }
                else {
                    System.out.println("삭제 실패하였습니다.");
                }
            }catch(NumberFormatException e) {
                System.out.println("0보다큰 정수를 입력해주세요.");
            }
        }
}


