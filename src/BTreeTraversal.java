import java.util.*;

public class BTreeTraversal {
    public static void main(String[] args) {
        BSTree myBSTree = new BSTree();
        Scanner sc = new Scanner(System.in);

        int option = sc.nextInt();
        sc.nextLine(); // Consume newline

        switch (option) {
            case 1: {
                // Them n phan tu vao cay nhi phan
                int n = sc.nextInt();
                for (int i = 1; i <= n; i++) {
                    myBSTree.insert(sc.nextInt());
                }
                System.out.println("1. Test breadth-first traversal:");
                myBSTree.breadth(myBSTree.root);
                break;
            }
            case 2: {
                // Them n phan tu vao cay nhi phan
                int n = sc.nextInt();
                for (int i = 1; i <= n; i++) {
                    myBSTree.insert(sc.nextInt());
                }
                System.out.print("2. Test pre-order traversal: ");
                myBSTree.preOrder(myBSTree.root);
                System.out.println();
                break;
            }
            case 3: {
                // Them n phan tu vao cay nhi phan
                int n = sc.nextInt();
                for (int i = 1; i <= n; i++) {
                    myBSTree.insert(sc.nextInt());
                }
                System.out.print("3. Test in-order traversal: ");
                myBSTree.inOrder(myBSTree.root);
                System.out.println();
                break;
            }
            case 4: {
                // Them n phan tu vao cay nhi phan
                int n = sc.nextInt();
                for (int i = 1; i <= n; i++) {
                    myBSTree.insert(sc.nextInt());
                }
                System.out.print("4. Test post-order traversal: ");
                myBSTree.postOrder(myBSTree.root);
                System.out.println();
                break;
            }
            default: {
                System.out.println("Invalid option. Exiting.");
                break;
            }
        }
        sc.close();
    }
}

class Node {
    int info;
    Node left, right;

    Node() {}

    Node(int x) {
        info = x;
        left = right = null;
    }
}

class BSTree {
    Node root;

    BSTree() {
        root = null;
    }

    void clear() {
        root = null;
    }

    boolean isEmpty() {
        return (root == null);
    }

    Node search(Node p, int x) {
        if (p == null) return null;
        if (p.info == x) return p;
        if (x < p.info)
            return search(p.left, x);
        else
            return search(p.right, x);
    }

    void insert(int x) {
        if (isEmpty()) {
            root = new Node(x);
            return;
        }
        Node f, p;
        f = null;
        p = root;
        while (p != null) {
            if (p.info == x) {
                System.out.println("The key " + x + " already exists, no insertion");
                return;
            }
            f = p;
            if (x < p.info)
                p = p.left;
            else
                p = p.right;
        }
        if (x < f.info)
            f.left = new Node(x);
        else
            f.right = new Node(x);
    }

    void insertMany(int[] a) {
        for (int i = 0; i < a.length; i++) insert(a[i]);
    }

    void visit(Node p) {
        System.out.print(p.info + "  ");
    }

    void breadth(Node p) {
        if (p == null) return;
        MyQueue q = new MyQueue();
        q.enqueue(p);
        Node r;
        while (!q.isEmpty()) {
            r = q.dequeue();
            visit(r);
            if (r.left != null) q.enqueue(r.left);
            if (r.right != null) q.enqueue(r.right);
        }
        System.out.println();
    }

    void preOrder(Node p) {
        if (p == null) return;
        visit(p);
        preOrder(p.left);
        preOrder(p.right);
    }

    void inOrder(Node p) {
        if (p == null) return;
        inOrder(p.left);
        visit(p);
        inOrder(p.right);
    }

    void postOrder(Node p) {
        if (p == null) return;
        postOrder(p.left);
        postOrder(p.right);
        visit(p);
    }
}

class MyQueue {
    LinkedList<Node> t;

    MyQueue() {
        t = new LinkedList<Node>();
    }

    void clear() {
        t.clear();
    }

    boolean isEmpty() {
        return (t.isEmpty());
    }

    void enqueue(Node p) {
        t.addLast(p);
    }

    Node dequeue() {
        if (isEmpty()) return null;
        return (t.removeFirst());
    }

    Node front() {
        if (isEmpty()) return null;
        return (t.getFirst());
    }
}
