import java.util.*;

class Node {
    Object info;
    Node next;

    Node(Object x, Node p) {
        info = x;
        next = p;
    }

    Node(Object x) {
        this(x, null);
    }
}

class LinkedStack {
    Node head, tail;

    LinkedStack() {
        head = tail = null;
    }

    boolean isEmpty() {
        return (head == null);
    }

    void push(Object x) {
        if (tail == null)
            head = tail = new Node(x, null);
        else {
            tail.next = new Node(x, null);
            tail = tail.next;
        }
    }

    Object top() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        return (tail.info);
    }

    Object pop() throws EmptyStackException {
        if (isEmpty()) throw new EmptyStackException();
        Object x = tail.info;
        if (head == tail) {
            head = tail = null;
        } else {
            Node current = head;
            while (current.next != tail)
                current = current.next;
            tail = current;
            tail.next = null;
        }
        return (x);
    }

    void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.info + " ");
            current = current.next;
        }
        System.out.println();
    }

    int size() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }
}

public class BLinkedStack {
    public static void main(String[] args) {
        LinkedStack myStack = new LinkedStack();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                if (!sc.hasNextInt()) {
                    break;
                }
                int option = sc.nextInt();
                int n;
                switch (option) {
                    case 1: {
                        // Them 1 phan tu vao dinh ngan xep
                        if (!sc.hasNextInt()) {
                            System.out.println("Expected an integer for the number of elements.");
                            break;
                        }
                        n = sc.nextInt();
                        for (int i = 1; i <= n; i++) {
                            if (!sc.hasNextInt()) {
                                System.out.println("Expected an integer for stack elements.");
                                break;
                            }
                            myStack.push(sc.nextInt());
                        }
                        if (!sc.hasNextInt()) {
                            System.out.println("Expected an integer for the element to push.");
                            break;
                        }
                        int x = sc.nextInt();
                        System.out.print("1. Push " + x + " to the top of " + n + "-element stack: ");
                        myStack.traverse();
                        myStack.push(x);
                        System.out.print("Current stack: ");
                        myStack.traverse();
                        break;
                    }

                    case 2: {
                        // Xoa 1 phan tu o dinh ngan xep
                        if (!sc.hasNextInt()) {
                            System.out.println("Expected an integer for the number of elements.");
                            break;
                        }
                        n = sc.nextInt();
                        for (int i = 1; i <= n; i++) {
                            if (!sc.hasNextInt()) {
                                System.out.println("Expected an integer for stack elements.");
                                break;
                            }
                            myStack.push(sc.nextInt());
                        }
                        System.out.print("2. Pop the top element of " + n + "-element stack: ");
                        myStack.traverse();
                        try {
                            System.out.println(myStack.pop());
                        } catch (EmptyStackException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        System.out.print("Current stack: ");
                        myStack.traverse();
                        break;
                    }

                    case 3: {
                        // Pop from an empty stack
                        System.out.println("3. Pop empty stack");
                        try {
                            System.out.println(myStack.pop());
                        } catch (EmptyStackException e) {
                            System.out.println("Error: Stack is empty");
                        }
                        break;
                    }

                    case 4: {
                        // Push multiple elements and display the top element
                        if (!sc.hasNextInt()) {
                            System.out.println("Expected an integer for the number of elements.");
                            break;
                        }
                        n = sc.nextInt();
                        for (int i = 1; i <= n; i++) {
                            if (!sc.hasNextInt()) {
                                System.out.println("Expected an integer for stack elements.");
                                break;
                            }
                            myStack.push(sc.nextInt());
                        }
                        System.out.print("4. Top of " + n + "-element stack: ");
                        myStack.traverse();
                        try {
                            System.out.println(myStack.top());
                        } catch (EmptyStackException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        System.out.print("Current stack: ");
                        myStack.traverse();
                        break;
                    }

                    case 5: {
                        // Perform multiple operations on the stack
                        if (!sc.hasNextInt()) {
                            System.out.println("Expected an integer for the number of elements.");
                            break;
                        }
                        n = sc.nextInt();
                        for (int i = 1; i <= n; i++) {
                            if (!sc.hasNextInt()) {
                                System.out.println("Expected an integer for stack elements.");
                                break;
                            }
                            myStack.push(sc.nextInt());
                        }
                        int step = sc.nextInt();
                        System.out.print("5. After " + step + " operations on the " + n + "-element stack: ");
                        myStack.traverse();
                        sc.nextLine(); // Consume newline
                        for (int i = 0; i < 5; i++) {
                            if (!sc.hasNextLine()) {
                                System.out.println("Expected an operation.");
                                break;
                            }
                            String operation = sc.nextLine();
                            if (operation.equals("pop")) {
                                try {
                                    myStack.pop();
                                } catch (EmptyStackException e) {
                                    System.out.println("Error: " + e.getMessage());
                                }
                            } else if (operation.startsWith("add")) {
                                int x = Integer.parseInt(operation.split(" ")[1]);
                                myStack.push(x);
                            }
                        }
                        System.out.println("Current stack size: " + myStack.size());
                        System.out.print("Current stack: ");
                        myStack.traverse();
                        break;
                    }

                    default: {
                        System.out.println("Invalid option. Exiting.");
                        break;
                    }
                }
            } catch (NoSuchElementException e) {
                System.out.println("No more input available. Exiting.");
                break;
            }
        }
        sc.close();
    }
}