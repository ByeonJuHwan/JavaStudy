package edu.java.lambda04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LambdaMain04 {

    public static void main(String[] args) {
        // Employee를 원소로 갖는 리스트 선언, 초기화
        List<Employee> employees = Arrays.asList(
                new Employee(100,"손흥민","개발자","개발1팀",300),
                new Employee(101,"봉준호","개발자","개발2팀",301),
                new Employee(201,"아이폰","개발자","개발2팀",302),
                new Employee(202,"김가영","디자이너","개발1팀",303),
                new Employee(301,"노진구","디자이너","개발2팀",400),
                new Employee(500,"나루토","부사장","인사팀",1000)
                );
        
        // Ex 1. 모든 직원들의 정보를 한 줄에 한 명씩 출력.
       
        for(Employee e : employees) {
            System.out.println(e);
        }
        System.out.println();
        
        
        employees.stream().forEach(x->System.out.println(x));
        System.out.println();
    
        // Ex 2. job이 "개발자"인 직원들의 급여 합계를 출력.
        
        Integer sum = 0; // 개발자 급여 합계
        for(Employee e : employees) {
            if(e.getJob().equals("개발자")) {
                sum+=e.getSalary();
            }
        }
        System.out.println("개발자들의 급여 합 = " + sum);
        
        
        
    
        sum=0;
        sum=employees.stream()
                .filter(x->x.getJob().equals("개발자"))
                .mapToInt(x->x.getSalary())
                .sum();
        
        System.out.println("개발자들의 급여 합 = " + sum);
        
        System.out.println();
        
        
        // Ex 3. dept가 "개발2팀"인 직원들의 급여 평균을 출력.
        
        double avg;
        double count=0;
        double sum3 =0;
        
        for(Employee e : employees) {
            if(e.getDept().equals("개발2팀")) {
                sum3+=e.getSalary();
                count++;
            }
            
        }
        avg=sum3/count;
        System.out.println("개발2팀의 직원들의 평균 급여 = " + avg);
        
        
        avg=employees.stream()
                .filter(x->x.getDept().equals("개발2팀"))
                .mapToInt(x->x.getSalary())
                .average()
                .getAsDouble();
                // .orElse(0); // Optional -> 정상적인 값 또는 비정상일 경우 기본값.
                // .orElseThrow(); // Optional -> 정상적인 값 또는 Exception
        System.out.println("개발2팀의 직원들의 평균 급여 = " + avg);
                
        
        System.out.println();
        
        
        
        // Ex 4. 급여가 400 이상인 직원들의 정보를 한 줄씩 출력.
        for(Employee e : employees) {
            if(e.getSalary()>=400){
                System.out.println(e);
            }
        }
        
        System.out.println();
        
        
         employees.stream()
                .filter(x->x.getSalary()>=400)
                .forEach(System.out::println);
        
       
        
    }

}
