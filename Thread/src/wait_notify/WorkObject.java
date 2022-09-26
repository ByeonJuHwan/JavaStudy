package wait_notify;

public class WorkObject {
	
	// notify(), wait()을 사용하려면 동기화 메소드, 블록이 되어야만 사용할 수 있다.
	// 동기화 처리를 해주지 않으면 Error가 발생한다.
	public synchronized void methodA() {
		System.out.println("ThreadA의 methodA() 작업 실행");
		notify(); // 현재 wait()된 다른 스레드를 실행 대기 (Runnable) 로 만들어 준다.
		try {
			wait();
		} catch (InterruptedException e) {}
	}
	
	public synchronized void methodB() {
		System.out.println("ThreadB의 methodB() 작업 실행");
		notify(); // 현재 wait()된 다른 스레드를 실행 대기 (Runnable) 로 만들어 준다.
		try {
			wait();
		} catch (InterruptedException e) {}
	}
}
