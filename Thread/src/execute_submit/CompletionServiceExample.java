package execute_submit;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CompletionServiceExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors() // 내 컴퓨터의 코어 수만큼 스레드를 생성.
				);
		
		CompletionService<Integer> completionService = new ExecutorCompletionService<>(executorService);
		
		System.out.println("[작업 처리 요청]");
		for(int i=1; i<4; i++) {
			completionService.submit(new Callable<Integer>() {

				@Override
				public Integer call() throws Exception {
					int sum =0;
					for(int i=1; i<11; i++) {
						sum+=i;
					}
					return sum;
				}});
		}
		
		System.out.println("[처리 완료된 작업 확인] ");
		executorService.submit(new Runnable() {

			@Override
			public void run() {
				while(true) {
					try {
						Future<Integer>future = completionService.take();
						int value = future.get();
						System.out.println("[처리결과] " + value);
					} catch (Exception e) {
						break;
					}
				}	
			}});
		
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {}
		
		executorService.shutdownNow();

	} // end main

} // end class
