package execute_submit;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

public class ExecuteVsSubmitExample {

	public static void main(String[] args) throws Exception{
		ExecutorService executorService = Executors.newFixedThreadPool(2); // 두개만 사용할수 있도록 생성
		
		for(int i=0; i<10; i++) {
			Runnable runnable = new Runnable() { // return 값이 없다. 즉 결과 값을 없도록 정의
			
				@Override
				public void run() {
					ThreadPoolExecutor threadPoolExecutor = (ThreadPoolExecutor) executorService;
					int poolsize = threadPoolExecutor.getPoolSize();
					String threadName = Thread.currentThread().getName();
					System.out.println("[총 스레드 개수 : "+ poolsize +"]" + "작업 처리 : " + threadName);
					int value = Integer.parseInt("삼");
				}
			};
			//executorService.execute(runnable);
			executorService.submit(runnable);
			Thread.sleep(10);
		}
		executorService.shutdown(); // 작업큐에 있는 작업들을 다 처리하고 마지막으로 스레드풀 종료 메서드
	}

}
