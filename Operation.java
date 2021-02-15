//add your own package to start.

/**
 * The interface Operation.
 */
public interface Operation {

    /**
     * Gets the operator for the calculation.
     *
     * @return a char
     */
    char getSymbol();

    /** Does calculation bases on 2 operands and an operator.
     * @param operandA first Operand
     * @param operandB second Operand
     * @return an integer
     */
    int perform(int operandA, int operandB);
}
