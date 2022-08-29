package kdai;


/**
 * 은행 계좌 정보 클래스.
 * 계좌번호, 잔액을 필드로 갖고, 입금, 출금, 이체, 정보 출력 기능을 메서드로 갖음.
 */
public class KadaiClass01 {
 // field
    int accountNo; // 계좌번호
    double balance; // 잔고
    
    // constructor - argument 2개를 갖는 생성자.
    public KadaiClass01(int accountNo, double balance) {
        this.accountNo = accountNo;
        this.balance = balance;
    }
    /**
     * 입금(deposit)
     * 
     * @param amount 입금액
     * @return 입금 후 잔액을 리턴.
     */
    public double deposit(double amount) {
        balance += amount;
        return balance;
    }
    
    /**
     * 출금(withdraw)
     * 
     * @param amount 출금액
     * @return 출금 후 잔액을 리턴.
     */
    public double withdraw (double amount) {
        balance -= amount;
        return balance;
    }
    
    /**
     * 이체(transfer)
     * 
     * @param to 이체할 계좌 객체(Account 타입)
     * @param amount 이체할 금액
     * @return true(이체 성공).
     */
    public boolean transfer(KadaiClass01 to , double amount) {
        this.withdraw(amount);
        to.deposit(amount);
        
        return true;
    }
    
    /**
     * 계좌 정보 출력(printAccountInfo). 계좌 번호와 잔액을 출력.
     */
    public void printAccountInfo() {
        System.out.println("계좌번호 = " + accountNo);
        System.out.println("잔액 = " + balance);
    }

    
}
