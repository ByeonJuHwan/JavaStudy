package edu.java.file07;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import edu.java.file06.Product;

public class FileMain07 {

    public static void main(String[] args) {
        // edu.java.file06.Product 타입의 객체를 1,000,000개 생성하고 ArrayList에 저장.
        // ArrayList의 내용을 Product_list.dat 파일에 write - 시간 측정.
        // product_list.dat 파일에서 데이터를 읽어서 ArrayList 타입으로 변환 - 시간 측정.
        String fileName = "data/product.dat";
        List<Product> productList = new ArrayList<>();
        for(int i=1; i<1000001; i++) {
            Product p = new Product(i, "name"+i, i);
            productList.add(p);
        }
        long startTime = System.currentTimeMillis();
        try(
                FileOutputStream out = new FileOutputStream(fileName);
                BufferedOutputStream bout = new BufferedOutputStream(out);
                ObjectOutputStream oout = new ObjectOutputStream(bout);
                )
        {
            
            
            oout.writeObject(productList);
            System.out.println("파일 작성 성공");
            
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        long elapsedTime = endTime - startTime;
        System.out.println("데이터를 복사하는 시간 " +  elapsedTime + "ms");
        
        
        
        long startTime2 = System.currentTimeMillis();
        try(
                FileInputStream in = new FileInputStream(fileName);
                BufferedInputStream bin = new BufferedInputStream(in);
                ObjectInputStream oin = new ObjectInputStream(bin);
                )
        {   
            Object obj = oin.readObject();
            if(obj instanceof Product) {
                Product p = (Product)obj;
                productList.add(p);
            }
            
        }catch(Exception e) {
            e.printStackTrace();
        }
        long endTime2 = System.currentTimeMillis();
        long elapsedTime2= endTime2 - startTime2;
        System.out.println("데이터를 읽어오는 시간 " +  elapsedTime2 + "ms");

    }

}
