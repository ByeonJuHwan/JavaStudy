package edu.java.list03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ListMain03 {

    public static void main(String[] args) {
        List<String> languages = Arrays.asList("Java", "SQL", "HTML","CSS","JavaScript","Servlet","JSP","Spring","Python"); // .asList 메서드는 값을 List에 넣을때 사용한다.
        System.out.println(languages);
        
        
        System.out.println();
        
        // 리스트 languages에서 5글자 이상은 문자열들만 저장하는 리스트를생성, 출력
        List<String> length =new ArrayList<String>();
        for(int i=0; i<languages.size(); i++) {
            int l = languages.get(i).length();
            if(l>=5) {
                length.add(languages.get(i));
            }
        }
        
        for(String s : length) {
            System.out.print(s + ", ");
        }
        System.out.println();
        
        // Iterator<E> 사용
        List<String> length1 =new ArrayList<String>();
        Iterator<String>itr = languages.iterator();
        while(itr.hasNext()) {
            String s = itr.next();
            if(s.length()>=5) {
                length1.add(s);
            }
        }
        System.out.println(length1);
        
        System.out.println();
        System.out.println();
        
        // 리스트 languages의 원소들의 글자수를 저장하는 리스트를 만들고 출력.
        List<Integer> letters = new ArrayList<>();
        
        for(int i=0; i<languages.size(); i++) {
            int number_of_characters = languages.get(i).length();
            letters.add(number_of_characters);
        }
        
        for(int a : letters) {
            System.out.print(a + ", ");
        }
        
        System.out.println();
        System.out.println();
        
        
        
        // 정수(1,2)들을 저장하는 리스트를 만들고 초기화.
        List<Integer> genderCodes = Arrays.asList(1,1,2,2,1,2,2);
        
        // 리스트 genderCodes의 원소가 1이면 "Male" , 2이면 "Female"을 저장하는 리스트를 만들고 출력
        List<String> gender = new ArrayList<>();
        
        
        for(int i=0; i<genderCodes.size(); i++) {
            if(genderCodes.get(i)==1) {
                gender.add("Male");
            }else {
                gender.add("Female");
            }
        }
        
        // gender.add((code==1) ? "Male" : "Female"); 삼항 연산자를 쓰는 방법도 있다.
        
        for(String g : gender) {
            System.out.print(g + ", ");
        }

    }

}
