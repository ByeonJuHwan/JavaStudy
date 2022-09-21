package edu.java.contact.fileutil;

import java.io.File;
import java.util.List;

import edu.java.contact.ver04.Contact;

//도우미 클래스 - 다른 클래스에 파일 관련(read, write) 기능을 제공하기 위한 클래스.
public class FileUtil {
    // 상수 정의 - 데이터 폴더 이름, 데이터 파일 이름
    public static final String DATA_DIR = "data";
    public static final String DATA_FILE = "contacts.dat";
    
    // private 생성자 - 다른 클래스에서 객체 생성이 안 되도록 하기 위해서.
    // 모든 메서드들은 public static 으로 선언.
    private FileUtil() {}
    
    /**
     * 연락처 데이터 파일을 저장하는 폴더가 없으면 폴더를 생성하고 File 객체를 리턴.
     * 폴더가 생성되어져 있으면, 그 폴더의 File 객체를 리턴.
     * 
     * @return 데이터 파일을 저장할 폴더 객체
     */
    public static File initDataDir() {
        File dir = new File(DATA_DIR);
        
        if(!dir.exists()) {
            dir.mkdir();
            System.out.println("데이터 폴더 생성 성공");
        }else {
            System.out.println("데이터 폴더가 이미 존재합니다.");
        }
        return dir;
    }
    
    /**
     * 연락처 데이터 파일이 있으면, 파일의 내용을 읽어서 리스트를 만들고 리턴.
     * 연락처 데이터 파일이 없으면 ,빈 리스트를 리턴.
     * @return Contact 타입을 저장하는 ArrayList.
     */
    public static List<Contact> initData(){
        
        return null;
    }
}
