//add your own package to start.

/**
 * The type Abstract operation.
 */
public abstract class AbstractOperation implements Operation {
    /**
     * The Operation type.
     */
    protected char operationType;

    /**
     * Instantiates a new Abstract operation.
     *
     * @param operator the operation type.
     */
    public AbstractOperation(final char operator) {
        operationType = operator;
    }

    @Override
    public final char getSymbol() {
        return operationType;
    }

    @Override
    public int perform(int operandA, int operandB) {
        switch (operationType) {
            case AdditionOperation.ADDITION_CODE:
                return operandA + operandB;
            case SubtractionOperation.SUBTRACTION_CODE:
                return operandB - operandA;
            case MultiplicationOperation.MULTIPLICATION_CODE:
                return operandA * operandB;
            case DivisionOperation.DIVISION_CODE:
                if (operandA == 0) {
                    throw new ArithmeticException();
                } else {
                    return operandB / operandA;
                }
            default:
                throw new IllegalArgumentException();
        }
    }
}
