package Lecture2_adt_specification;

import org.jetbrains.annotations.NotNull;
import java.util.Calendar;

/**
 * Fully specified
 * Includes:
 * - State invariants
 * - Defensive programming for immutability
 * - Proper documentation of requires/pre-conditions and produces/post-conditions
 */
public class Transaction4 {
    private final int amount;     // Immutable amount of transaction
    private final Calendar date; // Immutable date of transaction

    /**
     * Constructor for Transaction4
     *
     * Requires:
     * - The `date` parameter must not be null.
     * - The `amount` parameter should be a valid integer (no specific restriction).
     *
     * Produces:
     * - A new Transaction4 object with the specified amount and date.
     * - The `amount` field will hold the provided amount.
     * - The `date` field will hold a clone of the provided `Calendar` object, ensuring immutability.
     *
     * @param amount the transaction amount (integer)
     * @param date   the transaction date (must be a non-null Calendar object)
     * @throws IllegalArgumentException if `date` is null
     */
    public Transaction4(int amount, @NotNull Calendar date) {
        if (date == null) {
            throw new IllegalArgumentException("Date cannot be null.");
        }
        this.amount = amount;          // Store the amount
        this.date = (Calendar) date.clone(); // Clone the date to ensure immutability
    }

    /**
     * Retrieves the transaction amount.
     *
     * Requires:
     * - The method can be called on any valid `Transaction4` object.
     *
     * Produces:
     * - Returns the integer value stored in the `amount` field.
     *
     * @return the transaction amount (integer)
     */
    public int getAmount() {
        return amount; // Return the stored amount
    }

    /**
     * Retrieves the transaction date.
     *
     * Requires:
     * - The method can be called on any valid `Transaction4` object.
     *
     * Produces:
     * - Returns a cloned `Calendar` object representing the transaction date.
     * - The returned `Calendar` object is independent of the internal state and cannot be used to modify the original date.
     *
     * @return a cloned Calendar object representing the transaction date
     */
    public Calendar getDate() {
        return (Calendar) date.clone(); // Return a clone of the date to ensure immutability
    }
}
