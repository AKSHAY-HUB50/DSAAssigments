import java.util.Stack;

class MinStack {
    private Stack<Integer> mainStack;
    private Stack<Integer> minStack;


    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }


    public void push(int val) {

        mainStack.push(val);


        if (minStack.isEmpty() || val <= minStack.peek()) {
            minStack.push(val);
        }
    }


    public void pop() {
        if (mainStack.isEmpty()) {
            throw new java.util.NoSuchElementException("Stack is empty.");
        }

        // 1. Get the element being popped from the main stack.
        int poppedElement = mainStack.pop();


        if (poppedElement == minStack.peek()) {
            minStack.pop();
        }
    }

    /**
     * Gets the top element of the stack.
     * @return The top element.
     */
    public int top() {
        if (mainStack.isEmpty()) {
            throw new java.util.NoSuchElementException("Stack is empty.");
        }
        return mainStack.peek();
    }

    /**
     * Gets the minimum element in the stack.
     * @return The minimum element.
     */
    public int getMin() {
        if (minStack.isEmpty()) {
            throw new java.util.NoSuchElementException("Stack is empty.");
        }
        // The current minimum is always the top of the minStack.
        return minStack.peek();
    }
}




public class Min_Stack {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();

        System.out.println("--- Pushing Elements ---");
        minStack.push(-2); // mainStack: [-2], minStack: [-2]
        minStack.push(0);  // mainStack: [-2, 0], minStack: [-2] (0 > -2)
        minStack.push(-3); // mainStack: [-2, 0, -3], minStack: [-2, -3] (-3 <= -2)

        System.out.println("Current Minimum: " + minStack.getMin()); // Output: -3
        System.out.println("Current Top: " + minStack.top());       // Output: -3

        System.out.println("\n--- Popping Element ---");
        minStack.pop(); // Pop -3. Since -3 == minStack.peek(), pop -3 from minStack.

        System.out.println("Current Minimum: " + minStack.getMin()); // Output: -2
        System.out.println("Current Top: " + minStack.top());       // Output: 0

        minStack.push(-2); // mainStack: [-2, 0, -2], minStack: [-2, -2]
        System.out.println("Current Minimum after push: " + minStack.getMin()); // Output: -2
    }
}