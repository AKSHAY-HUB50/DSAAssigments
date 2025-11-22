import java.util.Arrays;
import java.util.Scanner;

class Stack<I extends Number> {
    int[] stackarr=new int[5];
    int top=-1;

    public boolean isEmpty(){
        return top==-1;
    }
    public boolean isFull(){
        return top==stackarr.length-1;
    }

    public void push1(int no){
        if(isFull())
            System.out.println("Stack Overflow");
        else {
            stackarr[++top]=no;
            System.out.println(no+" Added");
        }
    }

    public int Pop(){
        if (isEmpty())
            System.out.println("Stack UnderFlow");
        else {
             System.out.println(stackarr[top--]+" removed");
        }
        return 0;
    }

    public void Peek(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else
            System.out.println("peek value is :"+stackarr[top]);
    }

    public void display(){
        if(isEmpty()){
            System.out.println("Stack is empty");
        }
        else
            System.out.println(Arrays.toString(stackarr));
    }
    public void delete(){
        stackarr=null;
        System.out.println("Stack is deleted");
    }

}

public class Stack_using_Array {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Stack<Number> stack= new Stack<Number>();

        while (true){
            System.out.println(" 1.Push \n 2.Pop \n 3.Peek \n 4.Disply \n 5.Delete \n 6.exit");
            System.out.println("Enter your choice :");
            int n=sc.nextInt();

            switch (n){
                case 1 -> {
                    System.out.print("Enter Number: ");
                    int no = sc.nextInt();
                    stack.push1(no);
                }
                case 2 -> stack.Pop();
                case 3 -> stack.Peek();
                case 4 -> stack.display();
                case 5 -> stack.delete();
                case 6 -> {return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }

    }
}
