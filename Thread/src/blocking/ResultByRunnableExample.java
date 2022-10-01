package blocking;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByRunnableExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors() // 내 컴퓨터의 코어 수만큼 스레드를 생성.
				);
		System.out.println("[작업 처리 요청]");
		
		class Task implements Runnable{
			Result result;
			
			Task(Result result){
				this.result = result;
			}
			@Override
			public void run() {
				int sum =0;
				for(int i=1; i<11; i++) {
					sum+=i;
				}
				result.addValue(sum);
			}
			
		}// task end
		
		// 공유 객체 (외부 객체)
		Result result = new Result();
		// 두개의 작업을 정의
		Runnable task1 = new Task(result);
		Runnable task2 = new Task(result);
		
		Future<Result> future1 = executorService.submit(task1, result);
		Future<Result> future2 = executorService.submit(task2, result);
		
		try {
			result = future1.get();
			result = future2.get();
			System.out.println("[처리결과] : " + result.accumValue);
			System.out.println("[작업 처리 완료]");
		} catch (Exception e) {
			System.out.println("예외발생");
		} 
		executorService.shutdown();
	}

}

class Result{
	int accumValue;
	synchronized void addValue(int value) {
		accumValue +=value;
	}
}
