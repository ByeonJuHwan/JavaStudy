package edu.java.file09;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

/*
 * IO Stream : 바이트 스트림(byte stream). 읽기 / 쓰기의 기본 단위는 byte단위.
 *      모든 파일 형식(txt, mp4, mp3, docx, pptx, ...) 에서 사용 가능.
 * InputStream, OutputStream
 * |__ FileInputStream, BufferedInputStream, ObjectInputStream
 * OutputStream
 * |__ FileOutputStream, BufferedOutputSteram, ObjectOutputStream
 * 
 * Reader/Writer : 문자 스트림(character stream). 읽기/ 쓰기의 기본 단위는 "문자(character)" 단위.
 *   텍스트 파일 형식(txt, csv, dat, ...) 에서 사용.
 *   
 * Reader
 * |__ InputStreamReader, BufferedReader
 *    |__ FileReader
 *  
 * Writer
 * |__ OutputStreamWriter, BufferedWriter
 *    |__ FileWriter
 *    
 *    
 * Java 11 이전 버전까지는 FileReader / FileWriter 에서 인코딩 방식을 설정할 수 없었음.
 * 대신에 InputStreamReader / OutputStreamWriter는 인코딩 방식을 설정할 수 있음.
 * Java 11 버전부터는 FileReader / FileWriter에서도 인코딩 방식을 설정할 수 있도록 업데이트됨.
 *    
 *      
 *  운영 체제(OS : Operating System)의 기본 인코딩 방식
 *      - 한글 MS-Windows: EUC-KR(MS949, CP949), 영문 MS-Windows: CP1252
 *      - MacOS, Linux: UTF-8
 */


public class FileMain09 {

    public static void main(String[] args) {
        String ansiFile = "data/ansi.txt";
        String utf8File = "data/utf8.txt";
        
        // 1. Java 8 버전에서의 문자 스트림 사용 방법 :
        try(
                FileInputStream in = new FileInputStream(ansiFile);
                InputStreamReader reader = new InputStreamReader(in, "EUC_KR");
                BufferedReader br = new BufferedReader(reader);
        ) {
            while(true) {
                int read = br.read();
                if(read == -1) {
                    break;
                }
                System.out.print((char)read);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        System.out.println("----------");
        
        try(
                FileInputStream in = new FileInputStream(utf8File);
                InputStreamReader reader = new InputStreamReader(in, "UTF-8");
                BufferedReader br = new BufferedReader(reader);
        ){
            while(true) {
                // br.readLine();
                int read = br.read();
                if(read==-1) {
                    break;
                }
                System.out.print((char)read);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        
        System.out.println("----------");
        
        // 2. Java 11 버전부터 바뀐 FileReader 사용 방법 :
        try(
                FileReader reader = new FileReader(ansiFile, Charset.forName("EUC-KR"));
                BufferedReader br = new BufferedReader(reader);
                ){
            while(true){
                String line =br.readLine();
                if(line ==null) {
                    break;
                }
                System.out.println(line);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        

    }

}
