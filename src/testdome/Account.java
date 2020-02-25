package testdome;
/*예금과 인출 방법은 마이너스 숫자를 받아들이지 않을 것이다.
회계는 당좌대월 한도를 초과할 수 없다.

당좌대월
-당좌대월을 받기 위해서는 사전에 은행과 대부한도를 정한 당좌대월 계약을 맺어야 하며, 이 경우 유가증권이나 정기예금 등을 근담보(根擔保)로 하는 것이 통상적이다. 이율은 딴 대부보다는 고율이지만 부도(不渡)를 막을 수 있다는 점 등에서 당좌예금거래자에게는 대단히 편리한 제도이며, 단기금융에 이용된다.

예금과 인출 방법은 각각 정확한 금액을 입금하거나 인출한다.
인출 및 입금 방법은 정확한 결과를 반환한다.*/
public class Account {
    private double balance;
    private double overdraftLimit;

    public Account(double overdraftLimit) {
        this.balance = 0;
        this.overdraftLimit = overdraftLimit > 0 ? overdraftLimit : 0;
    }

    public boolean deposit(double amount) {
        if(amount >= 0) {
            this.balance += amount;
            return true;
        }
        return false;
    }

    public boolean withdraw(double amount) {
        if(this.balance - amount >= -this.overdraftLimit && amount >= 0) {
            this.balance -= amount;
            return true;
        }
        return false;
    }

    public double getBalance() {
        return balance;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }
}