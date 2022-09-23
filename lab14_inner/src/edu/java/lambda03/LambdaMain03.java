package edu.java.lambda03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class LambdaMain03 {

    public static void main(String[] args) {
        // 정수들을 저장하는 리스트
        List<Integer>numbers = Arrays.asList(1,2,3,4,5,6,7);
        System.out.println(numbers);
        
        List<Integer>evens; //numbers에서 짝수들만 선택해서 저장한 리스트.
        evens = new ArrayList<>();
        for(Integer i : numbers) { // 리스트의 모든 원소를 차례로 반복하면서
            if(i%2==0) { // 짝수들을 필터링
                evens.add(i);
            }
        }
        
        List<Integer>evens2 = numbers.stream()
                .filter(x->x%2 ==0)
                .collect(Collectors.toList());
        System.out.println(evens2);
        
        
        System.out.println(evens);
        List<Integer>odds; // numbers에서 홀수들만 선택해서 저장한 리스트.
        odds = new ArrayList<>();
        for(Integer i : numbers) {
            if(i%2==1) {
                odds.add(i);
            }
        }
        System.out.println(odds);

        List<Integer>odds2 = numbers.stream()
                .filter(x->x%2 == 1)
                .collect(Collectors.toList());
        System.out.println(odds2);
        
        
        // numbers에서 짝수들의 제곰을 저장하는 리스트.
        List<Integer> result = new ArrayList<>();
        for(Integer i : evens) {
            result.add(i*i);
        }
        System.out.println(result);
        
        result = numbers.stream()
                .filter(x->x%2==0)
                .map(x->x*x)
                .collect(Collectors.toList());
        System.out.println(result);
        
        
        List<String> langs = Arrays.asList("Java","SQL","HTML","JavaScript","Python");
        System.out.println(langs);
        
        List<String> result2 = new ArrayList<>();
        result2 = langs.stream()
                .filter(x->x.length()>=5)
                .map(String::toLowerCase) // .map(x->x.toLowerCase())
                .collect(Collectors.toList());
        
        System.out.println(result2);
        
        List<String> result3 = new ArrayList<>();
        for(String s : langs) {
            if(s.length()>=5) {
                s=s.toLowerCase();
                result3.add(s);
            }
        }
        System.out.println(result3);
        
        // langs에서 5글자 이상의 문자열들의 소문자로 변환한 리스트.
        
    
    }

}
