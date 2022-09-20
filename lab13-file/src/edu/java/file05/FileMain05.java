package edu.java.file05;

import java.io.FileInputStream;
import java.io.FileOutputStream;

/*
 * try-with-resource 문장
 * 
 * FileInputStram, FileOutputStream과 같은 클래스의 객체를 생성하고 사용한 후에는
 * 반드시 그 객체의 close() 메서드를 호출해서 리소스를 해제해야 함.
 * 기존의 try-catch-finally 문장을 사용하게 되면, 생상자 호출(객체 생성)은 try 블록에서 작성,
 * 리소스 해제(close 호출)는 finally 블록에서 작성하게 됨.
 * close 메서드를 자동으로 호출하는 try-with-resource 문장이 생기게 됨.
 * 
 * try (리소스 생성;) {
 *      정상적인 경우에 실행할 문장들;
 *  } catch (예외클래스 변수 선언) {
 *      예외 상황일 때 실행할 문장들;
 *  }
 *  
 *  try{
 *      리소스 생성;
 *      실행 코드;
 *  } catch (예외클래스 변수 선언) {
 *      예외 상황 코드;
 *  } finally {
 *      try{
 *      리소스 해제;
 *      }catch(){
 *      ........
 *      }
 *  }
 *  
 *  
 * 
 */


public class FileMain05 {

    public static void main(String[] args) {
        // try-with-resource 문장을 사용한 data/test.txt 파일을 test_copy3.txt로 복사
        try(
                FileInputStream in = new FileInputStream("data/test.txt");
                FileOutputStream out = new FileOutputStream("data/test_copy3.txt");
        ){
            while(true) {
                int read = in.read();
                if(read == -1) {
                    break;
                }
                out.write(read);
            }
            System.out.println("파일복사 종료");
            
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        

    }

}
