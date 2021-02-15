//add your own package to start.
/**
 * The type Stack.
 */
public class Stack {
    /**
     * The Stack values.
     */
    int[] stackValues;
    /**
     * The Count.
     */
    int count;

    /**
     * Instantiates a new Stack.
     *
     * @param stackSize size of array
     */
    public Stack(int stackSize) {
        if (stackSize < 1) {
            throw new IllegalArgumentException("Size of array"
                    + " cannot be less than 1.");
        } else {
            stackValues = new int[stackSize];
            count = 0;
        }
    }

    /**
     * Gets the capacity for the stack.
     *
     * @return the int
     */
    public int capacity() {
        return stackValues.length;
    }

    /**
     * Gets the current number of elements in the stack.
     *
     * @return the int
     */
    public int size() {
        return count;
    }

    /**
     * Displays number of items in the array that are not used.
     *
     * @return elements in the list that are not being used.
     */
    public int unused() {
        return stackValues.length - count;
    }

    /**
     * Push an item on top of the stack.
     *
     * @param value an integer
     * @throws StackOverflowException when the stack is full.
     */
    public void push(int value) throws StackOverflowException {
        if (unused() <= 0) { //Test with handling to see if it passes junit
            throw new StackOverflowException("This stack is full!");
        } else {
            stackValues[count] = value;
            count++;
        }
    }

    /**
     * Pop integer on top of the stack.
     *
     * @return the value of the item popped.
     * @throws StackUnderflowException when the array is empty.
     */
    public int pop() throws StackUnderflowException {
        if (stackValues.length == 0) {
            throw new StackUnderflowException("Cannot call"
                   + " Stack.pop() on an empty stack");
        } else {
            if (count == 0) {
                throw new StackUnderflowException();
            }
            int valuePopped = stackValues[count - 1];
            stackValues[count - 1] = 0; // sets popped array's element to zero.
            count--;
            return valuePopped;
        }
    }

    /**
     * Display the value on top of the stack.
     *
     * @return the int
     * @throws StackUnderflowException when array is empty
     */
    public int peek() throws StackUnderflowException {
        if (stackValues.length == 0) {
            throw new StackUnderflowException("Cannot call"
                    + "Stack.peek() on an empty stack");
        } else {
            return stackValues[count - 1];
        }
    }
}

