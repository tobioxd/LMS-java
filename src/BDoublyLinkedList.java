import java.util.*;

public class BDoublyLinkedList {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int caseNumber = scanner.nextInt();
        int listSize = scanner.nextInt();
        DoublyLinkedList list = new DoublyLinkedList();

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
                DoublyNode nodeToInsertAfter = list.search(valueToInsertAfter);
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
                DoublyNode nodeToDeleteAfter = list.search(valueToDeleteAfter);
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
                DoublyNode foundNode = list.search(valueToSearch);
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
                DoublyNode nodeToDeleteSpecific = list.search(valueToDeleteSpecific);
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
                DoublyLinkedList secondList = new DoublyLinkedList();
                for (int i = 0; i < secondListSize; i++) {
                    secondList.addToTail(scanner.nextInt());
                }
                System.out.println("15. Merge two ordered doubly linked lists of integers into one ordered list: " + listSize + "-node list = " + list.toString() + "; " + secondListSize + "-node list: " + secondList.toString());
                DoublyLinkedList mergedList = DoublyLinkedList.merge(list, secondList);
                mergedList.traverse();
                break;

            case 16:
                int valueToAddBefore = scanner.nextInt();
                int valueToAddBeforeNode = scanner.nextInt();
                DoublyNode nodeToAddBefore = list.search(valueToAddBeforeNode);
                System.out.print("16. Add a node with value " + valueToAddBefore + " before the node " + valueToAddBeforeNode + " in the " + listSize + "-node list: ");
                 list.traverse();
                list.addBefore(nodeToAddBefore, valueToAddBefore);
                list.traverse();
                break;

            case 17:
                int attachListSize = scanner.nextInt();
                DoublyLinkedList attachList = new DoublyLinkedList();
                for (int i = 0; i < attachListSize; i++) {
                    attachList.addToTail(scanner.nextInt());
                }
                System.out.print("17. Attach a doubly linked list of " + attachListSize + " elements " + attachList + " to the end of another doubly linked list of " + listSize + " nodes: ");
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
                System.out.println("24. Reverse the doubly linked list of " + listSize + " nodes: " + list);
                list.reverse();
                list.traverse();
                break;

            case 25:
                int secondListSizeForComparison = scanner.nextInt();
                DoublyLinkedList secondListForComparison = new DoublyLinkedList();
                for (int i = 0; i < secondListSizeForComparison; i++) {
                    secondListForComparison.addToTail(scanner.nextInt());
                }
                System.out.println("25. Check whether two doubly linked list have the same contents: 1st list of " + listSize + " elements: " + list + "; 2nd list of " + secondListSizeForComparison + " elements: " + secondListForComparison);
                System.out.println(list.equals(secondListForComparison) ? "no" : "yes");
                break;

            default:
                System.out.println("Invalid case number");
        }

        scanner.close();
    }
}

class DoublyNode {
    int data;
    DoublyNode next;
    DoublyNode prev;

    // Constructor
    public DoublyNode(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class DoublyLinkedList {
    private DoublyNode head;
    private DoublyNode tail;

    // Constructor
    public DoublyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    // Add a node with value x at the head of the list
    public void addToHead(int x) {
        DoublyNode newNode = new DoublyNode(x);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
    }

    // Add a node with value x at the tail of the list
    public void addToTail(int x) {
        DoublyNode newNode = new DoublyNode(x);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    // Add a node with value x after the node p
    public void addAfter(DoublyNode p, int x) {
        if (p == null) {
            System.out.println("The given previous node cannot be null");
            return;
        }
        DoublyNode newNode = new DoublyNode(x);
        newNode.next = p.next;
        newNode.prev = p;
        if (p.next != null) {
            p.next.prev = newNode;
        }
        p.next = newNode;
        if (p == tail) {
            tail = newNode;
        }
    }

    // Traverse from head to tail and display info of all nodes in the list
    public void traverse() {
        DoublyNode current = head;
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
        if (head != null) {
            head.prev = null;
        } else {
            tail = null;
        }
        return data;
    }

    // Delete the tail and return its info
    public int deleteFromTail() {
        if (tail == null) {
            throw new RuntimeException("List is empty");
        }
        int data = tail.data;
        tail = tail.prev;
        if (tail != null) {
            tail.next = null;
        } else {
            head = null;
        }
        return data;
    }

    // Delete the node after the node p and return its info
    public int deleteAfter(DoublyNode p) {
        if (p == null || p.next == null) {
            throw new RuntimeException("Invalid node or no node to delete after");
        }
        int data = p.next.data;
        p.next = p.next.next;
        if (p.next != null) {
            p.next.prev = p;
        } else {
            tail = p;
        }
        return data;
    }

    // Delete the first node whose info is equal to x
    public void delete1(int x) {
        DoublyNode current = head;
        while (current != null && current.data != x) {
            current = current.next;
        }
        if (current != null) {
            if (current == head) {
                deleteFromHead();
            } else if (current == tail) {
                deleteFromTail();
            } else {
                current.prev.next = current.next;
                current.next.prev = current.prev;
            }
        }
    }

    // Search and return the reference to the first node having info x
    public DoublyNode search(int x) {
        DoublyNode current = head;
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
        DoublyNode current = head;
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
            deleteFromHead();
            return;
        }
        DoublyNode current = head;
        for (int j = 0; j < i; j++) {
            if (current.next == null) {
                throw new RuntimeException("Index out of bounds");
            }
            current = current.next;
        }
        if (current == tail) {
            deleteFromTail();
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
    }

    // Sort the list in ascending order
    public void sort() {
        if (head == null || head.next == null) {
            return;
        }
        DoublyNode current = head;
        while (current != null) {
            DoublyNode index = current.next;
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
    public void delete(DoublyNode p) {
        if (head == null || p == null) {
            return;
        }
        if (p == head) {
            deleteFromHead();
        } else if (p == tail) {
            deleteFromTail();
        } else {
            p.prev.next = p.next;
            p.next.prev = p.prev;
        }
    }

    // Convert the list to an array
    public int[] toArray() {
        int[] array = new int[count()];
        DoublyNode current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    // Merge two ordered doubly linked lists into one ordered list
    public static DoublyLinkedList merge(DoublyLinkedList list1, DoublyLinkedList list2) {
        DoublyLinkedList mergedList = new DoublyLinkedList();
        DoublyNode current1 = list1.head;
        DoublyNode current2 = list2.head;
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
    public void addBefore(DoublyNode p, int x) {
        if (p == null) {
            System.out.println("The given node cannot be null");
            return;
        }
        if (head == p) {
            addToHead(x);
            return;
        }
        DoublyNode newNode = new DoublyNode(x);
        newNode.next = p;
        newNode.prev = p.prev;
        p.prev.next = newNode;
        p.prev = newNode;
    }

    // Attach one doubly linked list to the end of another
    public void attach(DoublyLinkedList list) {
        if (head == null) {
            head = list.head;
            tail = list.tail;
        } else {
            tail.next = list.head;
            if (list.head != null) {
                list.head.prev = tail;
            }
            tail = list.tail;
        }
    }

    // Find and return the maximum value in the list
    public int max() {
        if (head == null) {
            throw new RuntimeException("List is empty");
        }
        int max = head.data;
        DoublyNode current = head.next;
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
        DoublyNode current = head.next;
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
        DoublyNode current = head;
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
        DoublyNode current = head;
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
        DoublyNode newNode = new DoublyNode(x);
        if (head == null || head.data >= x) {
            newNode.next = head;
            if (head != null) {
                head.prev = newNode;
            }
            head = newNode;
            if (tail == null) {
                tail = newNode;
            }
            return;
        }
        DoublyNode current = head;
        while (current.next != null && current.next.data < x) {
            current = current.next;
        }
        newNode.next = current.next;
        if (current.next != null) {
            current.next.prev = newNode;
        } else {
            tail = newNode;
        }
        current.next = newNode;
        newNode.prev = current;
    }

    // Reverse a doubly linked list using only one pass through the list
    public void reverse() {
        DoublyNode current = head;
        DoublyNode temp = null;
        while (current != null) {
            temp = current.prev;
            current.prev = current.next;
            current.next = temp;
            current = current.prev;
        }
        if (temp != null) {
            head = temp.prev;
        }
    }

    // Check whether two doubly linked lists have the same contents
    public boolean equals(DoublyLinkedList other) {
        DoublyNode current1 = this.head;
        DoublyNode current2 = other.head;
        while (current1 != null && current2 != null) {
            if (current1.data != current2.data) {
                return false;
            }
            current1 = current1.next;
            current2 = current2.next;
        }
        return current1 == null && current2 == null;
    }

    // Method to return a string representation of the list
    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        DoublyNode current = head;
        while (current != null) {
            res.append(current.data).append(" ");
            current = current.next;
        }
        return res.toString().trim();
    }


}