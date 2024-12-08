package Lecture1_adt;

import java.util.Calendar;

/**
 * This Transaction1 Class adheres to ADT design principles:
 * 1. Representation Independence: 
 *    - The representation of data is hidden, and external code does not depend on it.
 * 2. Preservation of Invariants:
 *    - Fields are private and final to maintain integrity.
 *    - Defensive copying ensures no unintended modification of internal state.
 */
public class Transaction1 {
    private final int amount;  // Immutable integer amount
    private final Calendar date;  // Immutable due to defensive copying

    /**
     * Constructor for Transaction2.
     * @param amount The transaction amount.
     * @param date The transaction date (non-null, defensive copy applied).
     */
    public Transaction1(int amount, Calendar date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null");
        }
        this.amount = amount;
        this.date = (Calendar) date.clone();  // Defensive copying
    }

    /**
     * Getter for the transaction amount.
     * @return The transaction amount as an integer.
     */
    public int getAmount() {
        return amount;
    }

    /**
     * Getter for the transaction date.
     * @return A copy of the transaction date.
     */
    public Calendar getDate() {
        return (Calendar) date.clone();  // Defensive copying
    }
}
