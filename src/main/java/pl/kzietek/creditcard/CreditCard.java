package pl.kzietek.creditcard;

import java.math.BigDecimal;

public class CreditCard {
    private BigDecimal balance;
    private Boolean isAssigned = false;

    public CreditCard(String cardNumber) {

    }

    public void assignCredit(BigDecimal creditAmount) {
        if (isBelowThreshold(creditAmount)) {
            throw new CreditLimitBelowThresholdException();
        }

        if (isAlreadyAssigned()) {
            throw new CreditAssignedTwiceException();
        }

        this.balance = creditAmount;
        this.isAssigned  = true;
    }

    private boolean isBelowThreshold(BigDecimal creditAmount) {
        return creditAmount.compareTo(BigDecimal.valueOf(100)) < 0;
    }

    private boolean isAlreadyAssigned() {
        return this.isAssigned == true;
    }


    public BigDecimal getBalance() {
        return balance;
    }

    public void withdraw(BigDecimal money) {
        this.balance = balance.subtract(money);
    }
}
