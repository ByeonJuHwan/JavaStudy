package edu.java.inheritance09;

import java.util.Scanner;

import javax.swing.text.rtf.RTFEditorKit;

public class Square extends Rectangle{

    Scanner sc = new Scanner(System.in);
    
    private double width;
    
    protected Square(String type) {
        super(type);
        System.out.println("한변의 길이를 입력해주세요>>> ");
        
        
        
    }
    
    
    
}
