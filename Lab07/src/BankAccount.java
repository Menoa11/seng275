/* BankAccount

 * A bank account has a balance and an interest rate.
 * (note - in real life, NEVER use floating point numbers
 * to represent currency - use a specialized data type like
 * Java's BigDecimal instead.
 *
 * The rules of bank accounts:
 *
 *  Interest rates and balances can never be negative
 *  Accounts are either open or closed - if they're open,
 *  they can be closed if they have < 1 cent left in them.
 *  Attempting to close an account with >= 1 cent should
 *  throw an IllegalStateException.
 *
 */

public class BankAccount {

    private float balance;
    private float interestRate;
    private boolean open;

    public BankAccount() {
        this(0, 0);
    }

    public BankAccount(float balance, float interestRate) {
        assert balance >= 0 : "Balance cannot be negative";
        assert interestRate >= 0 : "Interest rate cannot be negative";
        this.balance = balance;
        this.interestRate = interestRate;
        this.open = true;
        assert(invariant());
    }

    public float getBalance() {
        assert(invariant());
        return this.balance;
    }

    public void setBalance(float newBalance) {
        assert newBalance >= 0 : "Balance must be positive";
        this.balance = newBalance;
        assert(invariant());
    }

    public float getInterestRate() {
        assert(invariant());
        return this.interestRate;
    }

    public void setInterestRate(float newInterestRate) {
        assert newInterestRate >= 0 : "Interest rate must be positive";
        this.interestRate = newInterestRate;
        assert(invariant());
    }

    public void applyInterest() {
        assert(invariant());
        float oldBalance = this.balance;
        float newInterest = this.calculateInterest();
        this.setBalance(oldBalance + newInterest);
        assert(invariant());
    }

    private float calculateInterest() {
        assert(invariant());
        return this.balance * this.interestRate;
    }

    public void close() {
        if (!this.open) return;
        if (this.balance >= 0.01f) {
            throw new IllegalStateException("There is still >= 1 cent left in your account");
        }
        this.open = false;
        assert(invariant());
    }

    private boolean invariant() {
        return balance >= 0 && interestRate >= 0 && !(!open && balance >= 0.01f);
    }

}