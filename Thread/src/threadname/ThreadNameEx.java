package threadname;

public class ThreadNameEx {

	public static void main(String[] args) {
		Thread thread = Thread.currentThread();
		System.out.println("프로그램 시작 스레드 이름 : " + thread.getName());
		
		
		Thread threadA = new ThreadA();
		threadA.start();
		
		Thread threadB = new ThreadB();
		threadB.start();

	}

}
