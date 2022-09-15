package edu.java.set02;

import java.util.HashSet;
import java.util.Iterator;

public class SetMain02 {

    public static void main(String[] args) {
        // Score 타입을 원소로 갖는 HashSet을 선언 , 생성
        HashSet<Score> set = new HashSet<>();
        
        Score score1 = new Score();
        set.add(score1);
        System.out.println(set);
        
        Score score2 = new Score(100,90);
        set.add(score2);
        System.out.println(set);
        
        Score score3 = new Score(100,90);
        set.add(score3);
        System.out.println(set);
        
        // for - each 문장
        for(Score s : set) {
            System.out.print(s + ", ");
        }
        System.out.println();
        
        
        // Iterator<E>
        Iterator<Score> Itr = set.iterator();
        while(Itr.hasNext()) {
            System.out.print(Itr.next() + ", ");
        }
    }

}
