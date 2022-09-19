package edu.java.file01;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/*
 * 입/출력 스트림(Input/Output Stream): 프로그램이 값 (데이터)를 입력받거나 출력하는 통로.
 * 프로그램 <== InputStream <== 입력 장치(키보드, 마우스, 펜, 파일, ...)
 * 프로그램 ==> OutputStream ==> 출력장치(모니터, 프린터, 스크린, 파일, ...)
 * 
 * 프로그램 <== FileInputStream <== 파일 
 * 프로그램 ==> FileOutputStream ==> 파일
 * 
 * java.io.InputStream : 데이터를 읽어오는 통로
 * |__ FileInputStream : 파일에서 데이터를 읽어오는 통로
 * 
 * java.io.InputStream : 데이터를 쓰는 (Write) 통로
 * |__ FileOutputStream : 파일에 데이터를 쓰는 통로
 * 
 * 
 */ 

public class FileMain01 {

    public static void main(String[] args) {
        FileInputStream in = null;
        FileOutputStream out = null;
        
        try {
            // data 폴더에 있는 test.txt파일을 읽기 위한 스트림 객체 생성
            in = new FileInputStream("data/test.txt");
            
            // data 폴데어 text_copy.txt 파일을 쓰기 위한 스트림 객체 생성
            out = new FileOutputStream("data/test_copy.txt");
            
            while(true) {
                int read = in.read();
                System.out.println(read);
                if(read==-1) {
                    break;
                }
                
                out.write(read);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                
                e.printStackTrace();
            } 
        }

    }

}
