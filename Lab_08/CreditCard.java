/**
 * CreditCard class that stores data about the Credit Card
 */
class CreditCard {

    private final Person owner;
    private final Money balance;
    private Money creditLimit;

    /**
     * Constructor
     *
     * @param newCardHolder The Person object
     * @param limit The Money object
     */
    public CreditCard(Person newCardHolder, Money limit) {
        this.owner = newCardHolder;
        this.creditLimit = limit;
        this.balance = new Money(0);
    }


    /**
     * Gets the balance
     *
     * @return balance The new calculated balance
     */
    public Money getBalance() {
        return new Money(balance);
    }

    /**
     * Gets the credit limit
     *
     * @return creditLimit The new credit limit
     */
    public Money getCreditLimit() {
        return new Money(creditLimit);
    }

    /**
     * Gets information amount the Credit card owner
     *
     * @return owner The owner of the credit card
     */
    public Person getPersonals() {
        return new Person(owner);
    }

    /**
     * Compares the balance and the credit card limit
     *
     * @return int value -1, 1, 0
     */
    private int toCompare() {
        return balance.compareTo(creditLimit);
    }

    /**
     * Method to add amounts to the balance and subtract from credit limit when
     * a charge is made.
     *
     * @param amount The amount of a charge
     */
    public void charge(Money amount) {
        this.balance.add(amount);
        this.creditLimit = creditLimit.subtract(amount);
        if (toCompare() == 1) {
            System.out.println("Exceeds credit limit");
            this.balance.subtract(amount);
        } else {
            System.out.println("Charge " + amount);
        }
    }

    /**
     * Method to add to the credit limit and subtract from the balance
     *
     * @param amount The amount paid
     */
    public void payment(Money amount) {
        this.balance.subtract(amount);
        this.creditLimit = creditLimit.add(amount);
        System.out.println("Payment: " + amount);

    }

}
