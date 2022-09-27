package edu.java.file10;

import java.io.File;

public class FileMain10 {

    public static void main(String[] args) {
        // 파일, 폴더(디렉토리) 생성, 삭제 , 관리
        
        
        // System.getProperty(key): Java Runtime이 실행 중인 컴퓨터의 여러가지 시스템 정보들을 리턴.
        // user.dir: 현재 작업 디렉토리(Current Working Directory)
        // 프로그램이 실행되는 위치.
        String cwd = System.getProperty("user.dir");
        System.out.println(cwd);

        
        // 절대 경로(absolute path) :
        // 시스텀의 루트(C:\, D:\) 부터 시작해서 파일(폴더)가 있는 위치를 찾아가는 경로.
        // (에) E:\study\lab-java\lab13-file\src\edu\java\file10\FileMain10.java
        
        // 상대 경로(relative path):
        // 현재 작업 디렉토리를 기준으로 파일(폴더)가 있는 위치를 찾아가는 경로
        // (예) src\edu\java\file10\FileMain10.java
        // . : 현재 폴더(디렉토리)
        //     (예) .\src\edu\java\file10\FileMain10.java
        // .. : 상위 폴더(디렉토리)
        //     (예) ..\lab12\src
        
        System.out.println("data\\test.txt");
        
        // 파일 구분자 (file separator):
        // 상위 폴더와 하위 폴더, 폴더와 파일을 구분하는 문자.
        // MS-Window: \
        // MS Windows 를 제외한 다른 OS : /
        
        String path = "data" + File.separator + "test.txt";
        System.out.println(path);
        
        // File 클래스: 파일(txt, mp4, pptx, ...)과 폴더 관련한 메서드(기능) 을 가지고 있는 클래스.
        File file = new File(path); // File 타입 객체 생성.
        System.out.println("path= " + file.getPath());
        // => getPath 메서드는 File 객체가 상대 경로로 생성된 경우, getPatj() 메서드는 상대 경로를 리턴.
        
        
        File file2 = new File("E:\\study\\lab-java\\lab13-file");
        System.out.println("path= " + file2.getPath());
        // File 객체가 생성될 때 절대 경로로 생성된 경우, getPath() 메서드는 절대 경로를 리턴.
        
        
        System.out.println("절대경로 = " + file.getAbsolutePath());
        System.out.println("파일이름 = " + file.getName());
        System.out.println("폴더이름 = " + file2.getName());
        System.out.println("파일?" + file.isFile());
        System.out.println("폴더?" + file.isDirectory());
        System.out.println("존재?" + file.exists());
        System.out.println("파일크기 = " + file.length());  // 바이트 단위
        
     // data 폴더의 내용(하위 폴더, 파일)을 출력
        File dataDir = new File("data"); // 상대경로
        File[] files = dataDir.listFiles();
        System.out.println(files);
        for(File f : files) {
            String fileName = f.getName();  // f.getPath()
            String info = null;
            if(f.isFile()) { // 파일인경우
                info = fileName + "\t" + f.length() + "bytes";
            }else { // 파일이 아닌경우(폴더인경우)
                info = fileName + "\t" + "<DIR>";
            }
            System.out.println(info);
        }
        
        // 폴더(디렉토리) 생성, 삭제
            File newFolder = new File("data", "temp"); // 상위폴더, 하위폴더 (파일)
            if(newFolder.exists()) {
                System.out.println("폴더가 이미 존재합니다.");
            }else {
                newFolder.mkdir(); // make directory
                System.out.println("새 폴더 생성,,");
            }
            
        // 폴더 삭제
            if(newFolder.exists()) {
                newFolder.delete();
                System.out.println("폴더 삭제 성공..");
            }else {
                System.out.println("삭제할 폴더가 없음..");
            }
    }

}
