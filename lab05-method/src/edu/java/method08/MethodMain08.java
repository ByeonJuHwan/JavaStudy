package edu.java.method08;

public class MethodMain08 {

    public static void main(String[] args) {
        // main 메서드의 arguments
        System.out.println("args length = "+args.length);
        String [] a = new String [0]; // null;
        for(String arg : args) {
            System.out.println(arg);
        }
    }

}
