package edu.java.thread01;

/*
 * Thread 사용 방법 1:
 * (1) Thread 클래스를 상속하는 클래스를 정의
 * (2) 상속하는 클래스에서 run() 메소드를 재정의 (override) - 쓰레드가 할 일
 * (3) Thread 클래스의 객체를 생성.
 * (4) 생성된 객체에서 start() 메서드를 호출. - 쓰레드가 시작됨.
 * (주의) Thread 객체의 run() 메서드를 직접 호출하면 안됨.
 */



public class ThreadMain01 {

    public static void main(String[] args) {
        // (1) Thread 를 상속하는 클래스를 정의
        class MyThread extends Thread{
            // 필드
            private String name;
            
            //생성자
            public MyThread(String name) {
                this.name = name;
            }
            //(2) run 메서드 재정의
            @Override
            public void run() {
                for(int i=0;i<100;i++) {
                    System.out.println(i + " - " + name);
                    
                    try {
                        sleep(10); // 0.01(10/1000) 초
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
            }
            
        } // Thread end
        
        // (3) Thread 객체 생성
        MyThread th1 = new MyThread("스레드");
        MyThread th2 = new MyThread("변주환");
        // 익명 클래스를 사용한 Thread 객체 생성
        Thread th3 = new  Thread() {
            @Override
            public void run() {
                for(int i=0; i<100; i++) {
                    System.out.println(i+ " -THREAD");
                    
                    try {
                        sleep(10);
                    } catch (InterruptedException e) {
                       
                        e.printStackTrace();
                    }
                }
                
            }
        };
        
        
        // 쓰레드 시작 시간
        long start = System.currentTimeMillis();
        
        // (4) 쓰레드 시작
        th1.start();
        th2.start();
        th3.start();
        try {
            th1.join(); // main 쓰레드는 th1 쓰레드가 끝날 때 까지 기다림.
            th2.join();
            th3.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // 쓰레드 종료 시간 - 모든 쓰레드(th1,th2)가 종료된 시간.
        long end = System.currentTimeMillis();
        System.out.println("쓰레드 실행 시간 = " + (end-start) + " ms");
        
        System.out.println("\n-----------------");
        System.out.println("프로그램 종료");
        System.out.println("------------------\n");
        
        
    } // end main()

}
