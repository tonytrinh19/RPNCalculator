package ca.bcit.cst.comp2522.a3;

public class InvalidOperationTypeException
        extends Exception {
    /**
     * Instantiates a new invalid operation type exception.
     */
    public InvalidOperationTypeException() {
    }
    /**
     * Instantiates a new invalid operation type exception.
     * @param operator the incorrect operator
     */
    public InvalidOperationTypeException(final char operator) {
        super("'" + operator + "' is not a valid operator!");
    }
}
