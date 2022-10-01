package blocking;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ResultByCallableExaple {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors() // 내 컴퓨터의 코어 수만큼 스레드를 생성.
				);
		System.out.println("[작업 처리 요청]");
		
		Callable<Integer> task = new Callable<>() { // 리턴 값이 없는경우 Runnable로 생성
			
			@Override
			public Integer call() throws Exception {
				int sum =0;
				for(int i=1; i<11; i++) {
					sum+=i;
				}
				return sum;
			}
		};
		
		Future<Integer> future =executorService.submit(task); 
		
		try {
			int sum =future.get();
			System.out.println("[처리결과]" + sum);
			System.out.println("[작업 처리 완료]");
		} catch (InterruptedException e) { 
			System.out.println("예외발생 " + e.getMessage());
		} catch (ExecutionException e) {}
		
		executorService.shutdown();
	}
}
