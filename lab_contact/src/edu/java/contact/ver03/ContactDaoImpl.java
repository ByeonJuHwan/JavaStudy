package edu.java.contact.ver03;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import edu.java.contact.ver03.ContactDaoImpl;

public class ContactDaoImpl implements ContactDao{
    Scanner scanner = new Scanner(System.in);
    
    private List<Contact> contactList = new ArrayList<>();
    
    // 싱글톤
    private static ContactDaoImpl instance = null;
    private ContactDaoImpl() {}
    public static ContactDaoImpl getInstance() {
        if(instance ==null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }
    
    public int getSize() {
        return contactList.size();
    }
    
    @Override
    public List<Contact> read() {
        
        return contactList;
    }

    @Override
    public Contact read(int index) {
        if(index>=0 && index<contactList.size()) {
            return contactList.get(index);
        }
        return null;
    }

    @Override
    public int create(Contact contact) {
        if(contact != null) {
        contactList.add(contact);
        return 1;
        }else {
            return 0;
        }
    }

    @Override
    public int upate(int index, String command) {
        
    
        if(command != null && command.equals("이름")) {
            System.out.print("변경하고싶은 이름을 입력해주세요>> ");
            String name = scanner.nextLine();
            contactList.get(index).setName(name);
            return 1;
        }else if(command != null && command.equals("번호")) {
            System.out.print("변경하고싶은 번호를 입력해주세요>> ");
            String phone = scanner.nextLine();
            contactList.get(index).setPhone(phone);
            return 1;
        }else if(command != null && command.equals("이메일")) {
            System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
            String email = scanner.nextLine();
            contactList.get(index).setEmail(email);
            return 1;
        }else if (command != null && (command.equals("이름 번호") ||command.equals("번호 이름"))){
            System.out.print("변경하고싶은 이름을 입력해주세요>> ");
            String name = scanner.nextLine();
            contactList.get(index).setName(name);
            System.out.print("변경하고싶은 번호를 입력해주세요>> ");
            String phone = scanner.nextLine();
            contactList.get(index).setPhone(phone);
            return 1;
        }else if(command != null && (command.equals("이름 이메일") ||command.equals("이메일 이름"))) {
            System.out.print("변경하고싶은 이름을 입력해주세요>> ");
            String name = scanner.nextLine();
            contactList.get(index).setName(name);
            System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
            String email = scanner.nextLine();
            contactList.get(index).setEmail(email);
            return 1;
        }else if (command != null && (command.equals("번호 이메일") ||command.equals("이메일 번호"))) {
            System.out.print("변경하고싶은 번호를 입력해주세요>> ");
            String phone = scanner.nextLine();
            contactList.get(index).setPhone(phone);
            System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
            String email = scanner.nextLine();
            contactList.get(index).setEmail(email);
            return 1;
        }else if(command != null && (command.equals("이름 번호 이메일") ||command.equals("이름 이메일 번호" )
                ||command.equals("번호 이름 이메일")|| command.equals("번호 이메일 이름")
                ||command.equals("이메일 이름 번호")||command.equals("이메일 번호 이름"))) {
            System.out.print("변경하고싶은 이름을 입력해주세요>> ");
            String name = scanner.nextLine();
            contactList.get(index).setName(name);
            System.out.print("변경하고싶은 번호를 입력해주세요>> ");
            String phone = scanner.nextLine();
            contactList.get(index).setPhone(phone);
            System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
            String email = scanner.nextLine();
            contactList.get(index).setEmail(email);
            
            return 1;
        }
    

    return 0;
    }

    @Override
    public int delete(int index) {
        if(index>=0 && index<contactList.size()) {
            contactList.remove(index);
            return 1;
        }
        return 0;
    }

}
