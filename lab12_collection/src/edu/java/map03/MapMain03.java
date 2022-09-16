package edu.java.map03;

import java.util.HashMap;

public class MapMain03 {

    public static void main(String[] args) {
        // 단어 개수 세기 (word counting)
        String sentence = "하늘 바다 땅 하늘 땅 사람 사람 사람 사람 땅 땅 하늘 하늘";
        
        // 문자열 sentence에 등장하는 단어를 key로 하고
        String [] array = sentence.split(" ");
        
        // 그 단어가 문자열에 등장하는 횟수를 value로 하는 Map 객체를 만들고 출력.
        HashMap<String, Integer> map = new HashMap<>();
        
        for(int i=0; i<array.length; i++) {
            int count=1;
            if(map.get(array[i]) != null) {
               count = map.get(array[i]) +1;
               map.put(array[i], count);
           } else {
               map.put(array[i],count);
           }
        }
     
        // 결과 : {땅=2, 바다=1, 사람=1, 하늘=2}
        
        System.out.println(map);
    }

}
