package wait_notify02;

public class ConsumerThread extends Thread{
  private DataBox dataBox;
    
    public ConsumerThread(DataBox dataBox) {
        this.setName("ConsumerThread");
        this.dataBox = dataBox;
    }
    
    @Override
    public void run() {
        for(int i =1; i<4; i++) {
            String data = dataBox.getData();
        }
    }
}
