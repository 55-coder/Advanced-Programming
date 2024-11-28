package Lecture4_interfaces_abstract_classes;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

public class DepositTransaction extends BaseTransaction {

    public DepositTransaction(int amount, @NotNull Calendar date) {
        super(amount, date);
    }

    @Override
    public void apply(BankAccount ba) {
        if (getAmount() <= 0) {
            System.out.println("Invalid deposit amount: $" + getAmount());
            return;
        }

        double currBalance = ba.getBalance();
        double newBalance = currBalance + getAmount();
        ba.setBalance(newBalance);

        System.out.println("Deposit of $" + getAmount() + " applied to account " + ba.getAccountID());
        System.out.println("Previous Balance: $" + currBalance);
        System.out.println("New Balance: $" + newBalance);
    }
}
