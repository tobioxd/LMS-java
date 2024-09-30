import java.util.*;

public class App {
    public static void main(String[] args) {
        BSTree myBSTree = new BSTree();
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            myBSTree.insert(sc.nextInt());
        }

        System.out.println("Breadth-first traversal of the original BST:");
        myBSTree.breadth(myBSTree.root);

        int x = sc.nextInt();
        System.out.println("Breadth-first traversal after deleting node " + x + ":");
        myBSTree.deleteByCopy(x);
        myBSTree.breadth(myBSTree.root);
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

    void deleteByCopy(int x){
        Node f, p;
        f = null;
        p = root;
        while (p != null){
            if (p.info == x) break;
            f = p;
            if (x < p.info) p = p.left;
            else p = p.right;
        }
        if (p == null){
            System.out.println("The key " + x + " does not exist, no deletion");
            return;
        }
        if (p.left == null && p.right == null){
            if (f == null) root = null;
            else if (p == f.left) f.left = null;
            else f.right = null;
            return;
        }
        if (p.left != null && p.right == null){
            if (f == null) root = p.left;
            else if (p == f.left) f.left = p.left;
            else f.right = p.left;
            return;
        }
        if (p.left == null && p.right != null){
            if (f == null) root = p.right;
            else if (p == f.left) f.left = p.right;
            else f.right = p.right;
            return;
        }
        if (p.left != null && p.right != null){
            Node q, fr;
            fr = null;
            q = p.left;
            while (q.right != null){
                fr = q;
                q = q.right;
            }
            p.info = q.info;
            if (fr == null) p.left = q.left;
            else fr.right = q.left;
        }
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
