package blocking;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class NoResultExample {

	public static void main(String[] args) {
		ExecutorService executorService = Executors.newFixedThreadPool(
				Runtime.getRuntime().availableProcessors() // 내 컴퓨터의 코어 수만큼 스레드를 생성.
				); // 스레드풀 생성
		System.out.println("[작업 처리 요청]");
		Runnable runnable = new Runnable() {
			
			@Override
			public void run() {
				int sum =0;
				for(int i=0; i<10; i++) {
					sum+=i;
				}
				System.out.println("[처리 결과] "+sum);
			}
		};
		
		Future future =executorService.submit(runnable); // future는 스레드가 작업이 끝날때까지 블로킹 즉 막아준다.
		
		try {
			future.get();
			System.out.println("[작업 처리 완료]");
		} catch (InterruptedException e) { 
			System.out.println("예외발생 " + e.getMessage());
		} catch (ExecutionException e) {}
		
		executorService.shutdown();
	}
}
