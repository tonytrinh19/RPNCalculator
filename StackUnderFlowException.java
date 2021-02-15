package ca.bcit.cst.comp2522.a3;

/**
 * The type Stack under flow exception.
 */
class StackUnderflowException extends Exception {
    /**
     * Instantiates a new Stack under flow exception.
     */
    StackUnderflowException() {
    }

    /**
     * Instantiates a new Stack under flow exception.
     *
     * @param msg the msg
     */
    StackUnderflowException(final String msg) {
        super(msg);
    }
}
