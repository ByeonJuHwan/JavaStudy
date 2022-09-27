package wait_notify02;

public class DataBox {
    private String data;

    public String getData() {
        if(this.data == null) {
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        
        String returnValue = data;
        System.out.println("ConsumerThread가 읽은 데이터: " + returnValue);
        data = null;
        notify();
        
        return returnValue;
    }

    public void setData(String data) {
        this.data = data;
    }
}
