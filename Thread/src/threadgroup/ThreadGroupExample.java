package threadgroup;

public class ThreadGroupExample {

	public static void main(String[] args) {
		ThreadGroup myGroup = new ThreadGroup("myGroup");
		WorkThread workThreadA = new WorkThread(myGroup, "workThreadA");
		WorkThread workThreadB = new WorkThread(myGroup, "workThreadB");
		
		workThreadA.start();
		workThreadB.start();
		
		System.out.println("메인 스레드 그룹의 list() 메소드 출력 내용");
		ThreadGroup mainGroup = Thread.currentThread().getThreadGroup();
		mainGroup.list(); // 메인그룹의 현재상태를 알려줌
		System.out.println();
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		System.out.println("mygroup 스레드 그룹의 interrupt() 메소드 호출");
		myGroup.interrupt();
		

	}

}
