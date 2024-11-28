package Lecture4_interfaces_abstract_classes;

@SuppressWarnings("serial")
public class InsufficientFundsException extends Exception {

    // Constructor to pass a custom error message
    public InsufficientFundsException(String message) {
        super(message);
    }
}
