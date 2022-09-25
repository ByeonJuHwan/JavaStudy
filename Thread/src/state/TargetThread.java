package state;

public class TargetThread extends Thread{

	@Override
	public void run() {
		for(long i=0; i<1000000000; i++) {} 
			
		// for 문 수행 후에 1.5초 동안 정지시킨다.
		try { 
			Thread.sleep(1500);
		} catch (InterruptedException e) {}
			
		for(long i=0; i<1000000000; i++) {}
	}
}
