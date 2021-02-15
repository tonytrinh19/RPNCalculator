package ca.bcit.cst.comp2522.a3;

/**
 * The type Stack over flow exception.
 */
class StackOverflowException extends Exception {
    /**
     * Instantiates a new Stack over flow exception.
     */
    StackOverflowException() {
    }

    /**
     * Instantiates a new Stack over flow exception.
     *
     * @param msg the msg
     */
    StackOverflowException(final String msg) {
        super(msg);
    }
}
