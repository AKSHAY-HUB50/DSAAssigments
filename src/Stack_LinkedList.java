import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class StackLL {
    Node top = null;

    public boolean isEmpty() {
        return top == null;
    }

    public void push1(int no) {
        Node newNode = new Node(no);
        newNode.next = top;
        top = newNode;
        System.out.println(no + " Added");
    }

    public void pop1() {
        if (isEmpty()) {
            System.out.println("Stack UnderFlow");
        } else {
            System.out.println(top.data + " removed");
            top = top.next;
        }
    }

    public void peek1() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
        } else {
            System.out.println("peek value is : " + top.data);
        }
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("Stack is empty");
            return;
        }

        Node temp = top;
        System.out.print("Stack elements: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public void delete() {
        top = null;
        System.out.println("Stack is deleted");
    }
}

public class Stack_LinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StackLL stack = new StackLL();

        while (true) {
            System.out.println(" 1.Push \n 2.Pop \n 3.Peek \n 4.Display \n 5.Delete \n 6.Exit");
            System.out.print("Enter your choice: ");
            int n = sc.nextInt();

            switch (n) {
                case 1 -> {
                    System.out.print("Enter Number: ");
                    int no = sc.nextInt();
                    stack.push1(no);
                }
                case 2 -> stack.pop1();
                case 3 -> stack.peek1();
                case 4 -> stack.display();
                case 5 -> stack.delete();
                case 6 -> {
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
