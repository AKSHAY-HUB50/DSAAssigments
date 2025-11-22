public class CircularQueue {
    private int[] queue;
    private int front;
    private int rear;
    private int size;
    private int capacity;


    public CircularQueue(int capacity) {

        this.capacity = capacity + 1;
        this.queue = new int[this.capacity];
        this.front = 0;
        this.rear = 0;
        this.size = 0;
    }

    public boolean enqueue(int value) {
        if (isFull()) {
            System.out.println("Queue is Full. Cannot enqueue " + value);
            return false;
        }

        queue[rear] = value;

        rear = (rear + 1) % capacity;
        size++;
        System.out.println("Enqueued: " + value);
        return true;
    }


    public int dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty. Cannot dequeue.");
            return -1;
        }
        int value = queue[front];
        front = (front + 1) % capacity;
        size--;
        System.out.println("Dequeued: " + value);
        return value;
    }


    public int front() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return -1;
        }
        return queue[front];
    }


    public boolean isEmpty() {
          return size == 0;
    }

    /**
     * Checks if the queue is full.
     */
    public boolean isFull() {
          return size == (capacity - 1);
    }

    public int getSize() {
        return size;
    }

    public void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is Empty.");
            return;
        }

        System.out.print("Queue: [");
        int count = 0;
        int i = front;
        while (count < size) {
            System.out.print(queue[i]);
            i = (i + 1) % capacity;
            if (count < size - 1) {
                System.out.print(", ");
            }
            count++;
        }
        System.out.println("] (Front Index: " + front + ", Rear Index: " + rear + ")");
    }

    public static void main(String[] args) {

        CircularQueue cq = new CircularQueue(5);

        System.out.println("--- Initial State ---");
        cq.printQueue();

        // Enqueue 5 elements
        cq.enqueue(10);
        cq.enqueue(20);
        cq.enqueue(30);
        cq.enqueue(40);
        cq.enqueue(50);
        cq.printQueue();


        cq.enqueue(60);
        System.out.println("\n--- Dequeue Operations (Freeing Space) ---");

        cq.dequeue();
        cq.dequeue();
        cq.printQueue();

        System.out.println("\n--- Enqueue (Wrap Around) ---");

        cq.enqueue(60);
        cq.enqueue(70);
        cq.printQueue();


        System.out.println("Front element (Peek): " + cq.front());
    }
}