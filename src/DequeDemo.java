class MyDeque<E> {
    private static class Node<E> {
        E item;
        Node<E> next;
        Node<E> prev;

        Node(E element, Node<E> prev, Node<E> next) {
            this.item = element;
            this.prev = prev;
            this.next = next;
        }
    }

    private Node<E> head;
    private Node<E> tail;
    private int size;

    public MyDeque() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    // --- Add Operations ---

    public void addFirst(E e) {
        final Node<E> oldHead = head;
        final Node<E> newNode = new Node<>(e, null, oldHead);
        head = newNode;
        if (oldHead == null) {
            tail = newNode;
        } else {
            oldHead.prev = newNode;
        }
        size++;
    }

    public void addLast(E e) {
        final Node<E> oldTail = tail;
        final Node<E> newNode = new Node<>(e, oldTail, null);
        tail = newNode;
        if (oldTail == null) {
            head = newNode;
        } else {
            oldTail.next = newNode;
        }
        size++;
    }

    public E removeFirst() {
        if (head == null) {
            throw new java.util.NoSuchElementException();
        }
        final E element = head.item;
        final Node<E> next = head.next;
        head.item = null;
        head.next = null;
        head = next;
        if (next == null) {
            tail = null;
        } else {
            next.prev = null;
        }
        size--;
        return element;
    }

    public E removeLast() {
        if (tail == null) {
            throw new java.util.NoSuchElementException();
        }
        final E element = tail.item;
        final Node<E> prev = tail.prev;
        tail.item = null;
        tail.prev = null;
        tail = prev;
        if (prev == null) {
            head = null;
        } else {
            prev.next = null;
        }
        size--;
        return element;
    }


    public E peekFirst() {
        if (head == null) {
            return null;
        }
        return head.item;
    }

    public E peekLast() {
        if (tail == null) {
            return null;
        }
        return tail.item;
    }
    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
public class DequeDemo {
    public static void main(String[] args) {
        MyDeque<String> deque = new MyDeque<>();

        deque.addFirst("B");
        deque.addLast("C");
        deque.addFirst("A");

        System.out.println("Front Element: " + deque.peekFirst());
        System.out.println("Rear Element: " + deque.peekLast());

        String first = deque.removeFirst();
        System.out.println("Removed First: " + first);

        String last = deque.removeLast();
        System.out.println("Removed Last: " + last);

        deque.addLast("D");
        System.out.println("Current Size: " + deque.size());
    }
}