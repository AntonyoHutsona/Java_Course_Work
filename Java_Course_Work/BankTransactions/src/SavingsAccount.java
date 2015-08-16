/**
 * Class for creating and handling saveings accounts
 * * Assignment:	Chapter 11
 */
public class SavingsAccount extends BankAccount{

    private final double RATE = 2.5/100;        // Annual interest rate
    private int savingsNumber = 0;              // To be used to divide sub accounts
    private String accountNumber;

    /**
     * Constructor for Saveings account.
     * @param name
     * @param amount
     */
    public SavingsAccount(String name, double amount) {
        super(name, amount);
        //super.setAccountNumber(getAccountNumber());
    }

    /**
     * Copy constructor.
     * @param account
     * @param amount
     */
    public SavingsAccount(SavingsAccount account, double amount) {
        super(account, amount);
        savingsNumber++;
    }

    /**
     * Deposits interest earned on the balance.
     */
    public void postInterest() {
        super.deposit(super.getBalance() * (RATE/(double)12));
    }

    /**
     * Method to get the account number.
     * @return account number
     */
    @Override
    public String getAccountNumber() {
        return setSavingsNumber();
    }

    /**
     * Sets the new sub account number based on original saveings account number.
     * @return the account number with an incremented sub account
     */
    public String setSavingsNumber() {
        this.accountNumber = super.getAccountNumber();
        return this.accountNumber + "-" + savingsNumber;

    }

}
