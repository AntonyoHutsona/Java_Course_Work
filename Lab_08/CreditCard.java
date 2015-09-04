/**
 * CreditCard class that stores data about the Credit Card
 */
public class CreditCard {

    private Person owner;
    private Money balance;
    private Money creditLimit;

    /**
     * Constructor
     * @param newCardHolder
     * @param limit
     */
    public CreditCard(Person newCardHolder, Money limit) {
        this.owner = newCardHolder;
        this.creditLimit = limit;
        this.balance = new Money(0);
    }

    /**
     * Copy constructor
     * @param object2
     */
    public CreditCard(CreditCard object2) {
        this.balance = object2.balance;
        this.creditLimit = object2.creditLimit;
    }

    /**
     * Gets the balance
     * @return balance
     */
    public Money getBalance() {return new Money(balance);}

    /**
     * Gets the credit limit
     * @return creditLimit
     */
    public Money getCreditLimit() {return new Money(creditLimit);}

    /**
     * Gets information amount the Credit card owner
     * @return owner
     */
    public Person getPersonals() {return new Person(owner);}

    /**
     * Compares the balance and the credit card limit
     * @return int value -1, 1, 0
     */
    public int toCompare() {return balance.compareTo(creditLimit);}

    /**
     * Method to add amounts to the balance and subtract from credit limit
     * when a charge is made.
     * @param amount
     */
    public void charge(Money amount) {
        this.balance.add(amount);
        this.creditLimit = creditLimit.subtract(amount);
        if(toCompare() == 1) {
            System.out.println("Exceeds credit limit");
            this.balance.subtract(amount);
        } else {
            System.out.println("Charge " + amount);
        }

    }

    /**
     * Method to add to the credit limit and subtract from the balance
     * @param amount
     */
    public void payment(Money amount)    {
        this.balance.subtract(amount);
        this.creditLimit = creditLimit.add(amount);
        System.out.println("Payment: " + amount);

    }

}
