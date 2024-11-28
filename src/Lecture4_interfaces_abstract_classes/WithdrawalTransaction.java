package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class WithdrawalTransaction extends BaseTransaction {

    // Reference to the bank account to enable reversal
    private BankAccount associatedAccount;

    public WithdrawalTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    @Override
    public void apply(BankAccount ba) {
        if (getAmount() <= 0) {
            System.out.println("Invalid withdrawal amount: $" + getAmount());
            return;
        }

        double currBalance = ba.getBalance();
        if (currBalance >= getAmount()) {
            double newBalance = currBalance - getAmount();
            ba.setBalance(newBalance);
            associatedAccount = ba; // Keep track of the associated account for reversal
            System.out.println("Withdrawal of $" + getAmount() + " applied to account " + ba.getAccountID());
            System.out.println("Previous Balance: $" + currBalance);
            System.out.println("New Balance: $" + newBalance);
        } else {
            System.out.println("Insufficient funds for withdrawal. Transaction ID: " + getTransactionID());
        }
    }

    /**
     * Reverses the withdrawal transaction, restoring the original balance.
     * @return true if the reversal is successful, false otherwise.
     */
    public boolean reverse() {
        if (associatedAccount == null) {
            System.out.println("This transaction has not been applied to any account yet.");
            return false;
        }

        double currentBalance = associatedAccount.getBalance();
        double restoredBalance = currentBalance + getAmount();
        associatedAccount.setBalance(restoredBalance);

        System.out.println("Reversal successful. $" + getAmount() + " restored to account " + associatedAccount.getAccountID());
        System.out.println("Restored Balance: $" + restoredBalance);
        return true;
    }
}

