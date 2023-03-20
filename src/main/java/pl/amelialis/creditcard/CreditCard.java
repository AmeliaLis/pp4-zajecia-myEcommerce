package pl.amelialis.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private BigDecimal credit;

    public CreditCard(String cardNumber){
    }

    public void assignCredit(BigDecimal creditAmount) {
        if(isCreditAlreadyAssigned()){
            throw new ReassignCreditExceptions();
        }

        if (isCreditBelowThreshold(creditAmount)) {
            throw new CreditBelowThresholdException();
        }

        this.balance = creditAmount;
        this.credit = creditAmount;
    }

    private boolean isCreditAlreadyAssigned() {
        return credit != null;
    }
private boolean isCreditBelowThreshold(BigDecimal creditAmount){
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
}

    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal money) {
        this.balance = balance.subtract(money);
    }
}
