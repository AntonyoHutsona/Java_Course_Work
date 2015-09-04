/**
 * This class handel's monetary operations
 */
public class Money {
    private long dollars;
    private long cents;

    /**
     * Constructor
     *
     * @param amount The amount in decimal format.
     */
    public Money(double amount) {
        if (amount < 0) {
            System.out.println("Error: Negative amounts of money are not " +
                               "allowed.");
            System.exit(0);
        } else {
            long allCents = Math.round(amount * 100);
            dollars = allCents / 100;
            cents = allCents % 100;
        }
    }

    /**
     * Copy Constructor
     *
     * @param object2
     */
    public Money(Money object2) {
        dollars = object2.dollars;
        cents = object2.cents;
    }

    /**
     * The add method
     *
     * @param otherAmount The amount of money to add.
     *
     * @return The sum of the calling Money object and the parameter Money
     * object.
     */
    public Money add(Money otherAmount) {
        Money sum = new Money(0);
        sum.cents = this.cents + otherAmount.cents;
        long carryDollars = sum.cents / 100;
        sum.cents = sum.cents % 100;
        sum.dollars = this.dollars + otherAmount.dollars + carryDollars;
        this.dollars = sum.dollars;
        this.cents = sum.cents;
        return sum;
    }

    /**
     * The subtract method
     *
     * @param amount The amount of money to subtract.
     *
     * @return The difference between the calling Money object and the
     * parameter Money object.
     */
    public Money subtract(Money amount) {
        Money difference = new Money(0);
        if (this.cents < amount.cents) {
            this.dollars = this.dollars - 1;
            this.cents = this.cents + 100;
        }
        difference.dollars = this.dollars - amount.dollars;
        difference.cents = this.cents - amount.cents;
        this.dollars = difference.dollars;
        this.cents = difference.cents;
        return difference;
    }

    /**
     * The compareTo method
     *
     * @param amount The amount of money to compare against.
     *
     * @return 1 if the dollars and the cents of the calling object are more
     * than the dollars and the cents of the parameter object.
     */
    public int compareTo(Money amount) {
        int value;
        if (this.dollars < amount.dollars) {
            value = -1;
        } else if (this.dollars > amount.dollars) {
            value = 1;
        } else if (this.cents < amount.cents) {
            value = -1;
        } else if (this.cents > amount.cents) {
            value = 1;
        } else {
            value = 0;
        }
        return value;
    }

    /**
     * equals method test for equality between the dollars and the cents of the
     * calling object are less than the dollars and the cents of the parameter
     * object
     *
     * @param amount
     *
     * @return boolean true/false
     */
    public boolean equals(Money amount) {
        return (dollars == amount.dollars && cents == amount.cents);

    }

    /**
     * toString method returns a formatted amount
     *
     * @return str The formatted dollar amount
     */
    @Override
    public String toString() {
        String str = String.format("$%d.%02d", dollars, cents);
        return str;
    }

}
