import java.util.*;

public class BBianaryTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            int option = sc.nextInt();
            switch (option) {
                case 1: {
                    BinarySearchTree bst = new BinarySearchTree();
                    System.out.println(bst.isEmpty());
                    break;
                }
                case 2: {
                    BinarySearchTree bst = new BinarySearchTree();
                    bst.clear();
                    break;
                }
                case 3: {
                    BinarySearchTree bst = new BinarySearchTree();
                    int x = sc.nextInt();
                    Node result = bst.search(x);
                    System.out.println(result != null ? result.data : "Not found");
                    break;
                }
                case 4: {
                    BinarySearchTree bst = new BinarySearchTree();
                    int x = sc.nextInt();
                    bst.insert(x);
                    break;
                }
                case 5: {
                    BinarySearchTree bst = new BinarySearchTree();
                    while (true) {
                        if (!sc.hasNextInt()) break;
                        int x = sc.nextInt();
                        bst.insert(x);
                    }
                    bst.breadth();
                    System.out.println();
                    break;
                }
                case 6: {
                    BinarySearchTree bst = new BinarySearchTree();
                    while (true) {
                        if (!sc.hasNextInt()) break;
                        int x = sc.nextInt();
                        bst.insert(x);
                    }
                    bst.preorder(bst.getRoot());
                    System.out.println();
                    break;
                }
                case 7: {
                    BinarySearchTree bst = new BinarySearchTree();
                    while (true) {
                        if (!sc.hasNextInt()) break;
                        int x = sc.nextInt();
                        bst.insert(x);
                    }
                    bst.inorder(bst.getRoot());
                    System.out.println();
                    break;  
                }
                case 8: {
                    BinarySearchTree bst = new BinarySearchTree();
                    while (true) {
                        if (!sc.hasNextInt()) break;
                        int x = sc.nextInt();
                        bst.insert(x);
                    }
                    bst.postorder(bst.getRoot());
                    System.out.println();
                    break;
                }
                case 9: {
                    BinarySearchTree bst = new BinarySearchTree();
                    while (true) {
                        if (!sc.hasNextInt()) break;
                        int x = sc.nextInt();
                        bst.insert(x);
                    }
                    System.out.println(bst.count());
                    break;
                }
                case 10: {
                    BinarySearchTree bst = new BinarySearchTree();
                    int x = sc.nextInt();
                    bst.dele(x);
                    break;
                }
                case 11: {
                    BinarySearchTree bst = new BinarySearchTree();
                    while (true) {
                        if (!sc.hasNextInt()) break;
                        int x = sc.nextInt();
                        bst.insert(x);
                    }
                    Node minNode = bst.min();
                    System.out.println(minNode != null ? minNode.data : "Tree is empty");
                    break;
                }
                case 12: {
                    BinarySearchTree bst = new BinarySearchTree();
                   while (true) {
                        if (!sc.hasNextInt()) break;
                        int x = sc.nextInt();
                        bst.insert(x);
                    }
                    Node maxNode = bst.max();
                    System.out.println(maxNode != null ? maxNode.data : "Tree is empty");
                    break;
                }
                case 13: {
                    BinarySearchTree bst = new BinarySearchTree();
                    System.out.println(bst.sum());
                    break;
                }
                case 14: {
                    BinarySearchTree bst = new BinarySearchTree();
                    System.out.println(bst.avg());
                    break;
                }
                case 15: {
                    BinarySearchTree bst = new BinarySearchTree();
                    System.out.println(bst.height());
                    break;
                }
                case 16: {
                    BinarySearchTree bst = new BinarySearchTree();
                    System.out.println(bst.maxPathSum());
                    break;
                }
                case 17: {
                    BinarySearchTree bst = new BinarySearchTree();
                    System.out.println(bst.isAVL());
                    break;
                }
                case 18: {
                    BinarySearchTree bst = new BinarySearchTree();
                    System.out.println(bst.mystery(bst.getRoot()));
                    break;
                }
                case 19: {
                    BinarySearchTree bst = new BinarySearchTree();
                    System.out.println(bst.isHeap());
                    break;
                }
                default: {
                    System.out.println("Invalid option. Exiting.");
                    return;
                }
            }
        }
    }
}

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    private Node root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void clear() {
        root = null;
    }

    public Node search(int x) {
        return searchRec(root, x);
    }

    private Node searchRec(Node root, int x) {
        if (root == null || root.data == x)
            return root;
        if (root.data > x)
            return searchRec(root.left, x);
        return searchRec(root.right, x);
    }

    public void insert(int x) {
        root = insertRec(root, x);
    }

    private Node insertRec(Node root, int x) {
        if (root == null) {
            root = new Node(x);
            return root;
        }
        if (x < root.data)
            root.left = insertRec(root.left, x);
        else if (x > root.data)
            root.right = insertRec(root.right, x);
        return root;
    }

    public void breadth() {
        if (root == null) return;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            if (tempNode.left != null)
                queue.add(tempNode.left);
            if (tempNode.right != null)
                queue.add(tempNode.right);
        }
        System.out.println();
    }

    public void preorder(Node p) {
        if (p != null) {
            System.out.print(p.data + " ");
            preorder(p.left);
            preorder(p.right);
        }
    }

    public void inorder(Node p) {
        if (p != null) {
            inorder(p.left);
            System.out.print(p.data + " ");
            inorder(p.right);
        }
    }

    public void postorder(Node p) {
        if (p != null) {
            postorder(p.left);
            postorder(p.right);
            System.out.print(p.data + " ");
        }
    }

    public int count() {
        return countRec(root);
    }

    private int countRec(Node root) {
        if (root == null) return 0;
        return 1 + countRec(root.left) + countRec(root.right);
    }

    public void dele(int x) {
        root = deleteRec(root, x);
    }

    private Node deleteRec(Node root, int x) {
        if (root == null) return root;
        if (x < root.data)
            root.left = deleteRec(root.left, x);
        else if (x > root.data)
            root.right = deleteRec(root.right, x);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }

    private int minValue(Node root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }

    public Node min() {
        return minRec(root);
    }

    private Node minRec(Node root) {
        if (root == null || root.left == null)
            return root;
        return minRec(root.left);
    }

    public Node max() {
        return maxRec(root);
    }

    private Node maxRec(Node root) {
        if (root == null || root.right == null)
            return root;
        return maxRec(root.right);
    }

    public int sum() {
        return sumRec(root);
    }

    private int sumRec(Node root) {
        if (root == null) return 0;
        return root.data + sumRec(root.left) + sumRec(root.right);
    }

    public int avg() {
        int totalSum = sum();
        int totalCount = count();
        return totalCount == 0 ? 0 : totalSum / totalCount;
    }

    public int height() {
        return heightRec(root);
    }

    private int heightRec(Node root) {
        if (root == null) return 0;
        return 1 + Math.max(heightRec(root.left), heightRec(root.right));
    }

    public int maxPathSum() {
        return maxPathSumRec(root);
    }

    private int maxPathSumRec(Node root) {
        if (root == null) return 0;
        return root.data + Math.max(maxPathSumRec(root.left), maxPathSumRec(root.right));
    }

    public boolean isAVL() {
        return isAVLRec(root);
    }

    private boolean isAVLRec(Node root) {
        if (root == null) return true;
        int leftHeight = heightRec(root.left);
        int rightHeight = heightRec(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1 && isAVLRec(root.left) && isAVLRec(root.right);
    }

    public boolean isHeap() {
        return isHeapRec(root);
    }

    private boolean isHeapRec(Node root) {
        if (root == null) return true;
        if (root.left != null && root.left.data > root.data) return false;
        if (root.right != null && root.right.data > root.data) return false;
        return isHeapRec(root.left) && isHeapRec(root.right);
    }

    public int mystery(Node x) {
        if (x == null)
            return 0;
        else
            return Math.max(mystery(x.left), mystery(x.right));
    }

    public Node getRoot() {
        return root;
    }
}