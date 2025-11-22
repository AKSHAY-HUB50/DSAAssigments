import java.util.ArrayList;
import java.util.ArrayList;

class MyStack {
    private ArrayList<Integer> list = new ArrayList<>();

    // Push element into stack
    public void push(int data) {
        list.add(data);
        System.out.println(data + " pushed");
    }

    // Pop element from stack
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return list.remove(list.size() - 1);
    }

    // Peek top element
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty!");
        }
        return list.get(list.size() - 1);
    }

    // Check if empty
    public boolean isEmpty() {
        return list.isEmpty();
    }

    // Stack size
    public int size() {
        return list.size();
    }

    // Display the stack
    public void display() {
        System.out.println(list);
    }
}
public class Stack_ArrayList {
    public static void main(String[] args) {
        MyStack stack = new MyStack();

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());

        System.out.println("Popped: " + stack.pop());
        System.out.println("Popped: " + stack.pop());

        stack.display();
    }
}
