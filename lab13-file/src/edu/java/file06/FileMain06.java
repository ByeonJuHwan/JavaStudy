package edu.java.file06;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * JAVA 객체(object) 타입을 파일에 쓰거나 파일에서 읽는 방법: 
 * 
 * 프로그램 ==> ObjectOutputStream ==> FileOutputStream ==> 파일
 *  ObjectOutputStream : 자바의 객체를 파일에 write 할 수 있는 형태로 변환(serialize, 직렬화).
 *  
 * 프로그램 <== ObjectInputStream <== FileInputStream <== 파일
 *  ObjectInputStream : 파일에서 읽은 데이터를 자바 객체로 변환 (de-serialize, 역직렬화).
 *  
 * ObjcetInputStream, ObjectOutputStream 에서 사용하는 자바 클래스는 반드시 Serializable 인터페이스를 구현해야 함.
 *
 */

public class FileMain06 {

    public static void main(String[] args) {
        // Product 타입의 객체 선언, 생성.
        Product p = new Product(1, "아이폰", 100);
        System.out.println(p);
        
        String fileName = "data/product.dat";
        // Product 객체를 파일에 write
        try(
                FileOutputStream out = new FileOutputStream(fileName);
                ObjectOutputStream oout = new ObjectOutputStream(out);){
            oout.writeObject(p);
            System.out.println("파일 작성 성공");
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        // 파일에 작성된 내용을 자바 객체로 읽어오기 -> 역직렬화
        try (
                FileInputStream in = new FileInputStream(fileName);
                ObjectInputStream oin = new ObjectInputStream(in);)
        {
            Object obj =oin.readObject();
            if(obj instanceof Product) {
                Product p2 = (Product)obj;
                System.out.println(p2);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }

    }

}
