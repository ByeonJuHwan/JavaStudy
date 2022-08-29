package kdai;

public class KadaiClassMain {

    public static void main(String[] args) {
        KadaiClass01 account = new KadaiClass01(73225786, 10000);
        KadaiClass01 account1 = new KadaiClass01(41085786,10000);
        
        double balance = account.deposit(10000);
        System.out.println("입급후 잔액은 = " + balance);
        
        System.out.println("-----------");
        
        balance = account.withdraw(5000);
        System.out.println("출금후 잔액은 = " + balance);
        
        System.out.println("-----------");
        
        boolean success = account.transfer(account1, 5000);
        if(success ==true) {
            
            System.out.println("이체완료했습니다.");
            System.out.println("잔액  = " + account.balance);
        }
        System.out.println("-----------");
        
        account.printAccountInfo();
        System.out.println("-----------");
        account1.printAccountInfo();

    }

}
