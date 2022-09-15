package edu.java.list04;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListMain04 {

    public static void main(String[] args) {
        // User 타입 객체를 선언, 생성 , 출력
        User user = new User();
        System.out.println(user);
        // User 객체 콘솔출력 값이 toString 메서드 override 전 / 후에 어떻게 달라지는 지 확인.
        
        // User 타입을 저장할 수 있는 ArrayList를 선언, 생성.
        List<User> userList = new ArrayList<>();
        
        // for 문장을 사용(3번 반복). Scanner를 사용.         
        // 콘솔창에서 입력받은 아이디와 비밀번호로 User 객체를 생성하고 리스트에 추가. 
        // 리스트를 출력
        
        Scanner sc = new Scanner(System.in);
        for(int i=0; i<3; i++) {
            
            System.out.print("아이디를 입력해주세요>> ");
            String id = sc.nextLine();
            System.out.print("비밀번호를 입력해주세요>> ");
            String pw = sc.nextLine();
            User user1 = new User(id,pw);
            userList.add(user1);
        }
        sc.close();
        
        System.out.println(userList);
        
        // 리스트 users에서 인덱스 1인 원소를 삭제, 리스트를 출력
        userList.remove(1);
        System.out.println(userList);
        
        // 리스트에서 userId가 "guest"인 User 객체를 삭제, 리스트를 출력
        // 1) userId가 "guest"인  User 객체의 인덱스를 찾아서 삭제
        for(int i =0; i<userList.size(); i++) {
            // 두 개의 문자열이 같은 지 비교할 때는 "반드시" equals() 메서드를 사용!
            if(userList.get(i).getUserID().equals("guest")) {
                userList.remove(i);
                break;
            }
        }
        
        System.out.println(userList);
        
        // 2) userId가 "guest"인 User 객체를 찾아서 삭제.
        for(User u : userList) {
            if (u.getUserID().equals("guest")) {
                userList.remove(u);   // remove(Object o)
                break;
            }
        }
        
        System.out.println(userList);
        
        
        
        
        
        
    }

}
