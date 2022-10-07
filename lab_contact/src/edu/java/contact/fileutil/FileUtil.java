package edu.java.contact.fileutil;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
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
        List<Contact> list = null;  // 리턴하게될 리스트
    
        File file = new File(DATA_DIR, DATA_FILE); 
        
        if(file.exists()) { // 데이터 파일이 존재하면
            list = readDataFromFile(file);
        }else { // 데이터 파일이 존재하지 않으면
            list = new ArrayList<>(); // 빈리스트 생성
        }
        
        return list;
    }

    
    /**
     * argument로 전달된 파일 객체를 사용해서, 파일에 저장된 연락처 정보를 읽고
     * 그 결과를 List 객체로 리턴.
     * @param file 연락처 정보가 저장된 파일 경로가 설정된 File 타입 객체.
     * @return Contact를 저장하는 ArrayList.
     */
    private static List<Contact> readDataFromFile(File file) {
        List<Contact> list = null;
        
        FileInputStream in = null;
        BufferedInputStream bin = null;
        ObjectInputStream oin = null;
        
        try {
            in = new FileInputStream(file); 
            bin = new BufferedInputStream(in);
            oin = new ObjectInputStream(bin);
            
            list = (List<Contact>) oin.readObject();
            
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                oin.close();
                // OIS close -> BIS close -> FIS close
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        return list;
    }
    /**
     * arguments로 전달된 데이터를 파일에 write. 
     * @param data 파일에 쓸 데이터. Contact 타입을 저장하는 리스트.
     * @param file 파일 정보를 가지고 있는 File 타입 객체.
     */
    public static void writeDataToFile(List<Contact> data, File file) {
        try(
                FileOutputStream out  = new FileOutputStream(file);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);
                )
        {
            oout.writeObject(data);
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
    }
}
