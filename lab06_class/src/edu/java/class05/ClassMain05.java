package edu.java.class05;

public class ClassMain05 {

    public static void main(String[] args) {
        // Score 타입의 객체 생성, 메서드들을 테스트.
        Score score1 = new Score();
        
        score1.printScore();
        
        int sum = score1.sum();
        System.out.println("총점은 = " + sum);
        
        double avg = score1.avg();
        System.out.println("평균은 = " + avg);
        
        System.out.println("-------------");
        
        Score score2 = new Score(55,65,75);
        score2.printScore();
        
        sum = score2.sum();
        System.out.println("총점은 = " + sum);
        
        avg = score2.avg();
        System.out.println("평균은 = " + avg);
        
        System.out.println();
        
        // Student 타입의 객체 생성, 메서드를 테스트.
        Student student1 = new Student();
        //student1.score = score1;
        student1.printInfo();
        
        System.out.println();
        Student student2 = new Student(10,"변주환",score2);
        student2.printInfo();
        
        System.out.println();
        Student student3 = new Student(10,"변주환",10,20,30);
        student3.printInfo();
        
        
        
        
        
        

    }

}
