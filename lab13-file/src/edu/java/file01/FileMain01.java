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
 * |__ FileInputStream : 파일에서 데이터를 읽어오는 통로 (read)
 * 
 * (1) FileInputStream 객체 생성
 * (2) FIS 객체 read 관련 메서드 호출
 * (3) FIS 객체를 close.
 * 
 * java.io.InputStream : 데이터를 쓰는 (Write) 통로
 * |__ FileOutputStream : 파일에 데이터를 쓰는 통로 (Write)
 * 
 * (1) FileOutputStream 객체 생성
 * (2) FOS 객체 write 관련 메서드 호출
 * (3) FOS 객체를 close.
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
            
            // 파일 복사 시작 시간 측정.
            long startTime = System.currentTimeMillis();
            
            while(true) {
                int read = in.read();    // 읽기 - 파일에서 1 바이트씩 읽음.
                // System.out.println(read + ":" + (char)read);
                if(read==-1) {  // read() 메서드는 파일 끝 (EOF : end of file)에 도달했을 때 -1 리턴
                    break; // 무한 루프 종료.
                }
                
                out.write(read);         // 쓰기 - 파일에서 1바이트씩 쓰기(write)
            }
            
            // 파일 복사 종료 시간 측정.
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime-startTime; // 복사하는데 걸린 시간.
            
            System.out.println("파일 복사 성공!" + elapsedTime + "ms");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            // 예외가 발생하지 않아도, (try 블록이 정상적으로 끝났을 때)
            // 예외가 발생하더라도 (catch 블록이 실행됐을 때)
            // 열려져 있는 FIS, FOS 객체는 닫아야 함!
            try {
                in.close();  // FileInputStram 객체 close
                out.close(); // FileOutputStream 객체 close
            } catch (IOException e) {
                e.printStackTrace();
            } 
        }

    }

}
