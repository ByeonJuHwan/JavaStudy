package edu.java.file03;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileMain03 {

    public static void main(String[] args) {
        // data/ratings.data 파일을 읽고 ratings_cpy.data복사
        // read(), write(int b)를 사용했을때
        // read(byte[] b), write(byte[] b, int off, int len)을 사용했을때
        // 복사 시간의 차이를 비교
        FileInputStream in = null;
        FileOutputStream out = null;
        
        try {
            in = new FileInputStream("data/ratings.dat");
            out = new FileOutputStream("data/ratings_copy.dat");
            long startTime1 = System.currentTimeMillis();
            while(true) {
                    int read = in.read();
                    if(read == -1) {
                        break;
                    }
                    out.write(read);
                }
            long endTime1 = System.currentTimeMillis();
            long elapsedTime1 = endTime1-startTime1;
            System.out.println("read(), write(int b)를 사용했을때 : " + elapsedTime1 + "ms");
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        
        
        
        try {
            in = new FileInputStream("data/ratings.dat");
            out = new FileOutputStream("data/ratings_copy.tat");
            long startTime2 = System.currentTimeMillis();
            while(true) {
                byte[] buffer = new byte[4000];
                int result = in.read(buffer);
                if(result == -1) {
                    break;
                }
                
                out.write(buffer,0,result);
                
            }
            long endTime2 = System.currentTimeMillis();
            long elapsedTime2 = endTime2 - startTime2;
            System.out.println("read(byte[] b), write(byte[] b, int off, int len)을 사용했을때 : " + elapsedTime2 + "ms");
            
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            try {
                in.close();
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
   
    
    
    
    }
}
