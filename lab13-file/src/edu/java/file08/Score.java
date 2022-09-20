package edu.java.file08;

import java.io.Serializable;

public class Score implements Serializable{
    // field
    private int korean;
    private int english;
    private int math;
    
    // 생성자: (1) 기본 생성자, (2) argument가 3개인 생성자
    public Score() {}

    public Score(int korean, int english, int math) {
        this.korean = korean;
        this.english = english;
        this.math = math;
    }

    // getters/setters
    public int getKorean() {
        return korean;
    }

    public void setKorean(int korean) {
        this.korean = korean;
    }

    public int getEnglish() {
        return english;
    }

    public void setEnglish(int english) {
        this.english = english;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }
    
    
    // toString
    @Override
    public String toString() {
        return String.format("국어성적 : %d점, 영어성적 : %d점, 수학성적 : %d점" , korean, english, math);
    }
    
}
