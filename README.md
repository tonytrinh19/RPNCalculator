# RPNCalculator
Reverse Polish Notation for removing parentheses in a simple calculation.
A sample input from terminal: "javac RPNCalculator.java "3 1 1 1 + +" would have a return value of 3. In the input, 3 represents total number that will be a part of the calculation. The three number 1s are the operands and the pluses are the operator.

RPN works like this, instead of using parentheses to indicate priorities in calculations: 1 + 1 * 2 = 3 and (1 + 1) * 2 = 4.
We can use RPN to get rid of the parentheses using solely on how we arrange operands and operators:
    1 + 1 * 2 now can be written as 1 1 2 * + and it would returns 3.
    Now here's the major difference:
    Instead of (1 + 1) * 2, we can write 1 1 + 2 *, the next step of RPN would be adding the first two operands and then 
    add the result of the addition to the last item on the stack (the item on top of the stack, which is the item furthest on the left) 2 2 * -> Final calculation would do multiplication on the two operands to achieve the result of 4. 