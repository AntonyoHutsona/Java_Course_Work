/**
 * Class for creating and handling checking accounts
 * Assignment:	Chapter 10 task 1
 */
public class CheckingAccount extends BankAccount {

    private final double FEE = .15;     // Fee for making withdrawals

    /**
     * Constructor for a checking account
     * @param name
     * @param amount
     */
    public CheckingAccount(String name, double amount) {
        super(name, amount);
        super.setAccountNumber(getAccountNumber() + -10);
    }

    /**
     * @param amount The amount to withdraw from.
     * @return the amount withdrawn with fee added
     */
    @Override
    public boolean withdraw(Double amount) {
        return super.withdraw(amount + FEE);
    }


}
