package edu.java.contact.ver04;

// 패키지의 클래스가 가지고 있는 static으로 선언된 모든 멤버(필드, 메서드) 이름을 import
import static edu.java.contact.fileutil.FileUtil.DATA_DIR;
import static edu.java.contact.fileutil.FileUtil.DATA_FILE;
import static edu.java.contact.fileutil.FileUtil.initData;
import static edu.java.contact.fileutil.FileUtil.initDataDir;
import static edu.java.contact.fileutil.FileUtil.writeDataToFile;

import java.io.File;
import java.util.List;
import java.util.Scanner;

// MVC 아키텍쳐에서 Controller를 구현하는 클래스.
public class ContactDaoImpl implements ContactDao {
    private List<Contact> contactList; // 연락처 데이터
    private File dataDir; // 연락처 데이터 파일을 저장하는 폴더
    private File dataFile; //연락처 데이터 파일
    
    Scanner scanner = new Scanner(System.in);
    
    // singleton
    private static ContactDaoImpl instance = null;
    
    private ContactDaoImpl() {
        dataDir = initDataDir();  // 데이터 폴더 초기화
        dataFile = new File(DATA_DIR, DATA_FILE); // 데이터 파일 객체
        contactList = initData(); // 데이터 초기화
    }
    
    public static ContactDaoImpl getInstance() {
        if(instance == null) {
            instance = new ContactDaoImpl();
        }
        return instance;
    }

    @Override
    public List<Contact> read() {
        return contactList;
    }

    @Override
    public Contact read(int index) {
        if(isValidindex(index)) {
            return contactList.get(index);
        }
        return null;
    }

   
    @Override
    public int create(Contact contact) {
        contactList.add(contact);
        
        // 새로운 데이터가 추가된 후, 파일과 동기화 하기 위해서 파일에 데이터를 저장.
        writeDataToFile(contactList, dataFile);
        
        return 1;
    }

    @Override
    public int upate(int index, String command) {
        
        if(isValidindex(index)) {
            if(command != null && command.equals("이름")) {
                System.out.print("변경하고싶은 이름을 입력해주세요>> ");
                String name = scanner.nextLine();
                contactList.get(index).setName(name);
                writeDataToFile(contactList, dataFile);
                return 1;
            }else if(command != null && command.equals("번호")) {
                System.out.print("변경하고싶은 번호를 입력해주세요>> ");
                String phone = scanner.nextLine();
                contactList.get(index).setPhone(phone);
                writeDataToFile(contactList, dataFile);
                return 1;
            }else if(command != null && command.equals("이메일")) {
                System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
                String email = scanner.nextLine();
                contactList.get(index).setEmail(email);
                writeDataToFile(contactList, dataFile);
                return 1;
            }else if (command != null && (command.equals("이름 번호") ||command.equals("번호 이름"))){
                System.out.print("변경하고싶은 이름을 입력해주세요>> ");
                String name = scanner.nextLine();
                contactList.get(index).setName(name);
                System.out.print("변경하고싶은 번호를 입력해주세요>> ");
                String phone = scanner.nextLine();
                contactList.get(index).setPhone(phone);
                writeDataToFile(contactList, dataFile);
                return 1;
            }else if(command != null && (command.equals("이름 이메일") ||command.equals("이메일 이름"))) {
                System.out.print("변경하고싶은 이름을 입력해주세요>> ");
                String name = scanner.nextLine();
                contactList.get(index).setName(name);
                System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
                String email = scanner.nextLine();
                contactList.get(index).setEmail(email);
                writeDataToFile(contactList, dataFile);
                return 1;
            }else if (command != null && (command.equals("번호 이메일") ||command.equals("이메일 번호"))) {
                System.out.print("변경하고싶은 번호를 입력해주세요>> ");
                String phone = scanner.nextLine();
                contactList.get(index).setPhone(phone);
                System.out.print("변경하고싶은 이메일을 입력해주세요>> ");
                String email = scanner.nextLine();
                contactList.get(index).setEmail(email);
                writeDataToFile(contactList, dataFile);
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
                writeDataToFile(contactList, dataFile);
                
                return 1;
            }
            
        }
        
        return 0;
    }

    @Override
    public int delete(int index) {
        if(!isValidindex(index)) {
            return 0;
        }
        contactList.remove(index);
        writeDataToFile(contactList, dataFile);
        
        return 1;
    }

    private boolean isValidindex(int index) {
        return (index>=0) && (index<contactList.size()) ;
        
    }
    
    public int getSize() {
        return contactList.size();
    }
}
