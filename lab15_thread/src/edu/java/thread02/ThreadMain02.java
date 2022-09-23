package edu.java.thread02;


/*
 * 
 * 자바에서는 클래스 다중 상속을 지원하지 않는다.
 * 자바에서는 2개이상의 다른 클래스를 상속 할수 없음.
 * class A extends B,C {} -> 지원하지 않음.
 * 다른 클래스를 이미 상속하고 있는 클래스에서는 Thread를 상속 할 수 없음.
 * 자바에서는 인터페이스 다중 구현은 가능.
 * class A extends B implements C,D ... {} -> 가능
 * 
 * Thread 사용 방법 2:
 * (1) Runnable 인터페이스를 구현하는 클래스를 정의.
 * (2) Runnable 구현 클래스에서 run() 메서드를 재정의 - 쓰레드가 할일.
 * (3) Runnable 구현 클래스의 객체를 생성.
 * (4) Runnable을 argument로 갖는 Thread 생성자를 호출해서 Thread 객체를 생성
 * (5) Thread 객체의 start() 호출 - 쓰레드 시작.
 * 
 */

public class ThreadMain02 {

    public static void main(String[] args) {
        // (1) Runnable을 구현하는 클래스 정의
        class MyRunnable implements Runnable{
            
            private String name;
            
            public MyRunnable(String name) {
                this.name = name;
            }
            
            // (2) run 메서드 재정의 - 쓰레드가 할 일 정의.
            @Override
            public void run() {
                for(int i=0; i<100; i++) {
                    System.out.println(i+ " - " + name);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            
        } // end runnable
        
        // (3) MyRunnable 타입 객체 생성
        MyRunnable process1 = new MyRunnable("변주환");
        
        // (4) Thread 타입 객체 생성
        Thread th1 = new Thread(process1);
        Thread th2 = new Thread(new MyRunnable("프로틴"));
        
        // Runnable을 구현하는 익명 클래스를 이용한 Thread 객체 생성
        Thread th3 = new Thread(new Runnable() {
            
            @Override
            public void run() {
                for(int i=0; i<100; i++) {
                    System.out.println(i + "- Runnable anonymous inner");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
            }
        });
        
        // Lambda를 사용한 쓰레드 객체 생성 (void run(){})
        Thread th4 = new Thread(()->{
            for(int i=0; i<100; i++) {
                System.out.println(i+ " -Lambda");
                
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        
        // (5) 쓰레드 실행 
        th1.start();
        th2.start();
        th3.start();
        th4.start();
        
        try {
            th1.join();
            th2.join();
            th3.join();
            th4.join();
        } catch (InterruptedException e) {
            
            e.printStackTrace();
        }
        
        System.out.println("\n-----------------");
        System.out.println("프로그램 종료");
        System.out.println("------------------\n");

    }// end main

}
