package yield;

public class YieldEx {

	public static void main(String[] args) {
		ThreadA threadA = new ThreadA();
		ThreadB threadB = new ThreadB();
		
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		threadA.work=false;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		threadA.work=true;
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		// 스레드를 정지 시킬때 stop() 메서드는 절대 사용하지말 것!!! 
		threadA.stop=true;
		threadB.stop=true;
	}
}
