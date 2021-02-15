//add your own package to start.

import java.util.Scanner;

/**
 * The type Rpn calculator.
 */
public class RPNCalculator {
    /**
     * The constant MIN_STACK_SIZE.
     */
    public static final int MIN_STACK_SIZE = 2;
    /**
     * The Stack.
     */
    private Stack stack;

    /**
     * Instantiates a new Rpn calculator.
     *
     * @param stackSize the stack size
     */
    public RPNCalculator(int stackSize) {
        if (stackSize < MIN_STACK_SIZE) {
            throw new IllegalArgumentException();
        } else {
            stack = new Stack(stackSize);
        }
    }

    /**
     * Process formula int and produce the result
     * for the calculations.
     *
     * @param formula the formula
     * @return the int
     * @throws StackOverflowException        the stack overflow exception
     * @throws InvalidOperationTypeException the invalid operation
     * type exception
     * @throws StackUnderflowException       the stack underflow exception
     */
    public int processFormula(final String formula)
            throws StackOverflowException,
            InvalidOperationTypeException,
            StackUnderflowException {
        if (formula == null) {
            throw new IllegalArgumentException();
        } else if (formula.length() == 0) {
            throw new StackUnderflowException("Cannot have empty argument.");
        } else {
            Scanner scan = new Scanner(formula);
            while (scan.hasNext()) {
                if (scan.hasNextInt()) {
                    int operand = scan.nextInt();
                    push(operand);
                } else {
                    char operator = scan.next().charAt(0);
                    Operation operation = getOperation(operator);
                    perform(operation);
                }
            }
        }
        return getResult();
    }

    /** Do calculations base on the operation.
     * @param operation type of Operation
     */
    void perform(final Operation operation)
            throws StackUnderflowException, StackOverflowException {
        if (operation == null) {
            throw new IllegalArgumentException("Operation cannot be null!");
        } else {
            int firstOp = stack.pop();
            int secondOp = stack.pop();
            int result = operation.perform(firstOp, secondOp);
            stack.push(result);
        }
    }

    /**
     * Adds operand to the stack if the stack is not full.
     * @param operand an integer
     * @throws StackOverflowException when stack is full
     */
    public void push(int operand) throws StackOverflowException {
        if (stack.unused() <= 0) {
            throw new StackOverflowException("This stack is full!");
        } else {
            stack.push(operand);
        }
    }

    /** Returns the value on top of the stack.
     * @return the operand on top of the stack
     * @throws StackUnderflowException when there are no operands
     * in the stack
     */
    public int getResult() throws StackUnderflowException {
        if (stack.size() <= 0) {
            throw new StackUnderflowException("There are no operands");
        }
        return stack.peek();
    }

    /**
     * Checks which operator it is to construct the operation.
     * @param operator the operator
     * @return the correct Operation
     */
    private Operation getOperation(final char operator)
            throws InvalidOperationTypeException {
        switch (operator) {
            case '+':
                return new AdditionOperation();
            case '-':
                return new SubtractionOperation();
            case '*':
                return new MultiplicationOperation();
            case '/':
                return new DivisionOperation();
            default:
                throw new InvalidOperationTypeException(operator);
        }
    }

    /**
     * Drives the program by evaluating the RPN calculation provided as
     * a command line argument.
     * <p>
     * Example usage: RPNCalculator 10 "1 2 +"
     * <p>
     * Note that the formula MUST be placed inside of double quotes.
     *
     * @param argv - the command line arguments are the size of the Stack
     *             to be created followed by the expression to evaluate.
     */
    public static void main(final String[] argv) {
        // Checks for correct number of command line arguments.
        if (argv.length != 2) {
            System.err.println("Usage: Main <stack size> <formula>");
            System.exit(1);
        }
        // Initializes stack and RPNCalculator.
        final int stackSize = Integer.parseInt(argv[0]);
        final RPNCalculator calculator = new RPNCalculator(stackSize);
        try {
            System.out.println("[" + argv[1] + "] = "
                    + calculator.processFormula(argv[1]));
        } catch (final InvalidOperationTypeException ex) {
            System.err.println("formula can"
                    + "only contain integers, +, -, *, and /");
        } catch (final StackOverflowException ex) {
            System.err.println("too many operands"
                    + "in the formula, increase the stack size");
        } catch (final StackUnderflowException ex) {
            System.err.println("too few operands in the formula");
        }
    }
}
