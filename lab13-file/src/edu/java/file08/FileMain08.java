package edu.java.file08;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class FileMain08 {

    public static void main(String[] args) {
        // Student를 저장하는 ArrayList를 선언, 생성.
        List<Student>students = new ArrayList<>();
        // ArrayList에 Student 객체 5개를 저장.
        for(int i=1; i<6; i++) {
            Student stu = new Student(i, "name"+i , new Score(10+i, 10+i, 10+i));
            students.add(stu);
        }
        
        // ArrayList를 파일에 write.
        try(
                FileOutputStream out = new FileOutputStream("data/Score.dat");
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);)
        {
            oout.writeObject(students);
            System.out.println("파일 복제 성공");
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        
        // 파일에서 ArrayList 객체를 read.
       try(
               FileInputStream in = new FileInputStream("data/Score.dat");
               BufferedInputStream bin = new BufferedInputStream(in);
               ObjectInputStream oin = new ObjectInputStream(bin);)
       {
           ArrayList<Student>list = (ArrayList<Student>) oin.readObject();
           
           System.out.println("파일 읽기 성공");
           
           // ArrayList의 원소들을 한 줄씩 출력.
           for(Student s : list) {
               System.out.println(s);
           }
           
           
       }catch(Exception e){
           e.printStackTrace();
       }
        
        

    }

}
