package wait_notify02;

public class ProducerThread extends Thread{
    
    private DataBox dataBox;
    
    public ProducerThread(DataBox dataBox) {
        this.setName("ProduberThread");
        this.dataBox = dataBox;
    }
    
    @Override
    public void run() {
        for(int i =1; i<4; i++) {
            String data = "Data-"+i;
            dataBox.setData(data);
        }
    }
}
