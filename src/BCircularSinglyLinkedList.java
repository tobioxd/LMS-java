import java.util.*;

public class BCircularSinglyLinkedList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseNumber = scanner.nextInt();
        int listSize = scanner.nextInt();
        SinglyLinkedList list = new SinglyLinkedList();

        for (int i = 0; i < listSize; i++) {
            list.addToTail(scanner.nextInt());
        }

        switch (caseNumber) {
            case 1:
                int valueToAddBeforeHead = scanner.nextInt();
                System.out.print("1. Add " + valueToAddBeforeHead + " before the head of " + listSize + "-element list: ");
                list.traverse();
                list.addToHead(valueToAddBeforeHead);
                list.traverse();
                break;

            case 2:
                int valueToAddAfterTail = scanner.nextInt();
                System.out.print("2. Add " + valueToAddAfterTail + " after the tail of " + listSize + "-element list: ");
                list.traverse();
                list.addToTail(valueToAddAfterTail);
                list.traverse();
                break;

            case 3:
                int valueToInsertAfter = scanner.nextInt();
                int valueToInsert = scanner.nextInt();
                Node nodeToInsertAfter = list.search(valueToInsertAfter);
                System.out.print("3. Insert an element " + valueToInsert + " after the element " + valueToInsertAfter + " in the " + listSize + "-element list ");
                list.traverse();
                list.addAfter(nodeToInsertAfter, valueToInsert);
                list.traverse();
                break;

            case 4:
                System.out.print("4. Traverse the " + listSize + "-element list: ");
                list.traverse();
                list.traverse();
                break;

            case 5:
                System.out.print("5. Delete the head of the " + listSize + "-element list: ");
                list.traverse();
                list.deleteFromHead();
                list.traverse();
                break;

            case 6:
                System.out.print("6. Delete the tail of the " + listSize + "-element list: ");
                list.traverse();
                list.deleteFromTail();
                list.traverse();
                break;

            case 7:
                int valueToDeleteAfter = scanner.nextInt();
                Node nodeToDeleteAfter = list.search(valueToDeleteAfter);
                System.out.print("7. Delete the element after the element " + valueToDeleteAfter + " of the " + listSize + "-element list: ");
                list.traverse();
                list.deleteAfter(nodeToDeleteAfter);
                list.traverse();
                break;

            case 8:
                int valueToDelete = scanner.nextInt();
                System.out.print("8. Delete the element " + valueToDelete + " in the " + listSize + "-element list: ");
                list.traverse();
                list.delete1(valueToDelete);
                list.traverse();
                break;

            case 9:
                int valueToSearch = scanner.nextInt();
                System.out.print("9. Search the element " + valueToSearch + " in the " + listSize + "-element list: ");
                list.traverse();
                Node foundNode = list.search(valueToSearch);
                System.out.print(foundNode != null ? foundNode.data : "Not found");
                break;

            case 10:
                System.out.print("10. Count the number of the elements of the " + listSize + "-element list: ");
                list.traverse();
                System.out.print(list.count());
                break;

            case 11:
                int indexToDelete = scanner.nextInt();
                System.out.print("11. Delete the " + indexToDelete + "rd element in the " + listSize + "-node list: ");
                list.traverse();
                list.delete2(indexToDelete-1);
                list.traverse();
                break;

            case 12:
                System.out.print("12. Sort in accending order the " + listSize + "-node list: ");
                list.traverse();
                list.sort();
                list.traverse();
                break;

            case 13:
                int valueToDeleteSpecific = scanner.nextInt();
                Node nodeToDeleteSpecific = list.search(valueToDeleteSpecific);
                System.out.print("13. Delete the element " + valueToDeleteSpecific + " in the " + listSize + "-node list: ");
                list.traverse();
                list.delete(nodeToDeleteSpecific);
                list.traverse();
                break;

            case 14:
                System.out.print("14. Create and return array containing info of all nodes in the " + listSize + "-node list.");
                int[] array = list.toArray();
                for (int value : array) {
                    System.out.print(value + " ");
                }
                System.out.println();
                break;

            case 15:
                int secondListSize = scanner.nextInt();
                SinglyLinkedList secondList = new SinglyLinkedList();
                for (int i = 0; i < secondListSize; i++) {
                    secondList.addToTail(scanner.nextInt());
                }
                System.out.println("15. Merge two ordered circular singly linked lists of integers into one ordered list: " + listSize + "-node list = " + list.toString() + "; " + secondListSize + "-node list: " + secondList.toString());
                SinglyLinkedList mergedList = SinglyLinkedList.merge(list, secondList);
                mergedList.traverse();
                break;

            case 16:
                int valueToAddBefore = scanner.nextInt();
                int valueToAddBeforeNode = scanner.nextInt();
                Node nodeToAddBefore = list.search(valueToAddBeforeNode);
                System.out.print("16. Add a node with value " + valueToAddBefore + " before the node " + valueToAddBeforeNode + " in the " + listSize + "-node list: ");
                 list.traverse();
                list.addBefore(nodeToAddBefore, valueToAddBefore);
                list.traverse();
                break;

            case 17:
                int attachListSize = scanner.nextInt();
                SinglyLinkedList attachList = new SinglyLinkedList();
                for (int i = 0; i < attachListSize; i++) {
                    attachList.addToTail(scanner.nextInt());
                }
                System.out.print("17. Attach a circular singly linked list of " + attachListSize + " elements " + attachList + " to the end of another circular singly linked list of " + listSize + " nodes: ");
                 list.traverse();
                list.attach(attachList);
                list.traverse();
                break;

            case 18:
                System.out.print("18. Find and return the maximum value in the " + listSize + "-node list: ");
                 list.traverse();
                System.out.print(list.max());
                break;

            case 19:
                System.out.print("19. Find and return the minimum value in the " + listSize + "-node list: ");
                 list.traverse();
                System.out.print(list.min());
                break;

            case 20:
                System.out.print("20. Return the sum of all values in the " + listSize + "-node list: ");
                 list.traverse();
                System.out.print(list.sum());
                break;

            case 21:
                System.out.print("21. Return the average of all values in the " + listSize + "-node list: ");
                list.traverse();
                System.out.print(list.avg()); 
                break;

            case 22:
                System.out.println("22. check and return true if the " + listSize + "-node list " + list.toString() + " is sorted, return false if the list is not sorted.");
                System.out.println(list.sorted());
                break;

            case 23:
                int valueToInsertSorted = scanner.nextInt();
                System.out.println("23. Sort the " + listSize + "-node list: " + list + " then insert a node with value " + valueToInsertSorted + " into the sorted list so that the new list is a sorted list");
                list.sort();
                list.traverse();
                list.insert(valueToInsertSorted);
                list.traverse();
                break;

            case 24:
                System.out.println("24. Reverse the circular singly linked list of " + listSize + " nodes: " + list);
                list.reverse();
                list.traverse();
                break;

            case 25:
                int secondListSizeForComparison = scanner.nextInt();
                SinglyLinkedList secondListForComparison = new SinglyLinkedList();
                for (int i = 0; i < secondListSizeForComparison; i++) {
                    secondListForComparison.addToTail(scanner.nextInt());
                }
                System.out.println("25. Check whether two circular singly linked list have the same contents: 1st list of " + listSize + " elements: " + list + "; 2nd list of " + secondListSizeForComparison + " elements: " + secondListForComparison);
                System.out.println(list.equals(secondListForComparison) ? "no" : "yes");
                break;

            default:
                System.out.println("Invalid case number");
        }

        scanner.close();
    }
}

class Node {
    int data;
    Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class SinglyLinkedList {
    private Node head;

    // Constructor
    public SinglyLinkedList() {
        this.head = null;
    }
    
    public String toString(){
        String res = "";
        Node current = head;
        while (current != null) {
            res+= current.data + " ";
            current = current.next;
        }
        return res;
    }

    // Add a node with value x at the head of the list
    public void addToHead(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
    }

    // Add a node with value x at the tail of the list
    public void addToTail(int x) {
        Node newNode = new Node(x);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Add a node with value x after the node p
    public void addAfter(Node p, int x) {
        if (p == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        Node newNode = new Node(x);
        newNode.next = p.next;
        p.next = newNode;
    }

    // Traverse from head to tail and display info of all nodes in the list
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Delete the head and return its info
    public int deleteFromHead() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        int data = head.data;
        head = head.next;
        return data;
    }

    // Delete the tail and return its info
    public int deleteFromTail() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        if (head.next == null) {
            int data = head.data;
            head = null;
            return data;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int data = current.next.data;
        current.next = null;
        return data;
    }

    // Delete the node after the node p and return its info
    public int deleteAfter(Node p) {
        if (p == null || p.next == null) {
            throw new RuntimeException("Invalid node or no node to delete after");
        }
        int data = p.next.data;
        p.next = p.next.next;
        return data;
    }

    // Delete the first node whose info is equal to x
    public void delete1(int x) {
        if (head == null) {
            return;
        }
        if (head.data == x) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data != x) {
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Search and return the reference to the first node having info x
    public Node search(int x) {
        Node current = head;
        while (current != null) {
            if (current.data == x) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    // Count and return the number of nodes in the list
    public int count() {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    // Delete the i-th node in the list
    public void delete2(int i) {
        if (i < 0 || head == null) {
            throw new RuntimeException("Invalid index or list is empty");
        }
        if (i == 0) {
            head = head.next;
            return;
        }
        Node current = head;
        for (int j = 0; j < i - 1; j++) {
            if (current.next == null) {
                throw new RuntimeException("Index out of bounds");
            }
            current = current.next;
        }
        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    // Sort the list in ascending order
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        Node current = head;
        while (current != null) {
            Node index = current.next;
            while (index != null) {
                if (current.data > index.data) {
                    int temp = current.data;
                    current.data = index.data;
                    index.data = temp;
                }
                index = index.next;
            }
            current = current.next;
        }
    }

    // Delete a specific node if it exists in the list
    public void delete(Node p) {
        if (head == null || p == null) {
            return;
        }
        if (head == p) {
            head = head.next;
            return;
        }
        Node current = head;
        while (current.next != null && current.next != p) {
            current = current.next;
        }
        if (current.next == p) {
            current.next = p.next;
        }
    }

    // Convert the list to an array
    public int[] toArray() {
        int[] array = new int[count()];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    // Merge two ordered singly linked lists into one ordered list
    public static SinglyLinkedList merge(SinglyLinkedList list1, SinglyLinkedList list2) {
        SinglyLinkedList mergedList = new SinglyLinkedList();
        Node current1 = list1.head;
        Node current2 = list2.head;
        while (current1 != null && current2 != null) {
            if (current1.data <= current2.data) {
                mergedList.addToTail(current1.data);
                current1 = current1.next;
            } else {
                mergedList.addToTail(current2.data);
                current2 = current2.next;
            }
        }
        while (current1 != null) {
            mergedList.addToTail(current1.data);
            current1 = current1.next;
        }
        while (current2 != null) {
            mergedList.addToTail(current2.data);
            current2 = current2.next;
        }
        return mergedList;
    }

    // Add a node with value x before the node p
    public void addBefore(Node p, int x) {
        if (p == null) {
            System.out.println("The given node cannot be null");
            return;
        }
        if (head == p) {
            addToHead(x);
            return;
        }
        Node current = head;
        while (current != null && current.next != p) {
            current = current.next;
        }
        if (current != null) {
            Node newNode = new Node(x);
            newNode.next = p;
            current.next = newNode;
        }
    }

    // Attach one singly linked list to the end of another
    public void attach(SinglyLinkedList list) {
        if (head == null) {
            head = list.head;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = list.head;
        }
    }

    // Find and return the maximum value in the list
    public int max() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        int max = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data > max) {
                max = current.data;
            }
            current = current.next;
        }
        return max;
    }

    // Find and return the minimum value in the list
    public int min() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        int min = head.data;
        Node current = head.next;
        while (current != null) {
            if (current.data < min) {
                min = current.data;
            }
            current = current.next;
        }
        return min;
    }

    // Return the sum of all values in the list
    public int sum() {
        int sum = 0;
        Node current = head;
        while (current != null) {
            sum += current.data;
            current = current.next;
        }
        return sum;
    }

    // Return the average of all values in the list as a double with 2 decimal places
    public double avg() {
        int sum = sum();
        int count = count();
        if (count == 0) {
            throw new RuntimeException("List is empty");
        }
        double average = (double) sum / count;
        return Math.round(average * 100.0) / 100.0;
    }

    // Check and return true if the list is sorted, return false if the list is not sorted
    public boolean sorted() {
        if (head == null || head.next == null) {
            return true;
        }
        Node current = head;
        while (current.next != null) {
            if (current.data > current.next.data) {
                return false;
            }
            current = current.next;
        }
        return true;
    }

    // Insert node with value x into sorted list so that the new list is sorted
    public void insert(int x) {
        Node newNode = new Node(x);
        if (head == null || head.data >= x) {
            newNode.next = head;
            head = newNode;
            return;
        }
        Node current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
    }

    // Reverse a singly linked list using only one pass through the list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    // Check whether two singly linked lists have the same contents
    public boolean equals(SinglyLinkedList other) {
        Node current1 = this.head;
        Node current2 = other.head;
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }

}