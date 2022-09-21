package threadname;

public class ThreadB extends Thread{
		
	@Override
		public void run() {
			for(int i=0; i<2; i++) {
				System.out.println(getName()+" 이 출력한 내용");
			}
		
		}
}
