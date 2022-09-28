package edu.java.swing10;

// MVC Model 클래스 - 데이터를 정의하는 클래스. VO(Value Object)
public class Score{
    private int korean;
    private int english;
    private int math;
    
    public Score() {}

    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    public int getKorean() {
        return korean;
    }

    public int getEnglish() {
        return english;
    }

    public int getMath() {
        return math;
    }
    
    // 합계
    public int sum() {
        return korean+english+math;
    }
    // 평균
    public double average() {
        return (double)sum() / 3;
    }
    
    @Override
    public String toString() {
         return String.format("Score(korak=%d, engish=%s, math=%d, sum=%d, average=%.2f)", korean,english,math,sum(),average());
    }
    
}
