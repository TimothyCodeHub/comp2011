package comp2011.lec9;

import java.util.Scanner;
import comp2011.lec4.Queue;

class Student {
    int id;
    String name;
    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    
    public String toString() {return id + ", " + name;}
}

/*
 * Binary search trees
 */
public class BinarySearchTree<T> {
    private class Node<T> {
        // The explicit use of variable key is non-standard.
        // We use it here to avoid the use of Comparator:
        // http://docs.oracle.com/javase/8/docs/api/java/util/Comparator.html
        int key;
        T data;
        public Node<T> leftChild, rightChild;

        public Node(int key, T data) {
            this.key = key;
            this.data = data;
        }

        public String toString() {
            return data.toString();
        }
    }

    Node<T> root;

    public BinarySearchTree() {}

    // how to rewrite this with recursion?
    public Node<T> search(int key) {
        return null;
    }

    public Node<T> insert (Node<T> curRoot, int key, T data) {
        return null;
    }
    // starter for the recursive version.
    public void insert (int key, T data) {
        Node<T> newNode = insert(root, key, data);
        if (root == null) root = newNode; 
    }

    // you're suggested to finish search() before this.
    public void recInsert(int key, T data) { }
    
    public void preorder(Node<T> curRoot) {
        if (curRoot == null) return;
        System.out.println(curRoot.data);
        preorder(curRoot.leftChild);
        preorder(curRoot.rightChild);
    }

    public void inorder(Node<T> curRoot) {
        if (curRoot == null) return;
        inorder(curRoot.leftChild);
        System.out.println(curRoot.data);
        inorder(curRoot.rightChild);
    }
    
    // can you do it without recursion?
    public void postorder(Node<T> curRoot) {
        if (curRoot == null) return;
        postorder(curRoot.leftChild);
        postorder(curRoot.rightChild);
        System.out.println(curRoot.data);
    }

    public Node<T> findMin() {return null;}

    public Node<T> findMax() {return null;}

    public Node<T> predecessor(Node<T> x) { return null; }

    public Node<T> successor(Node<T> x) { return null; }

    public void display() { inorder(root); }

    public void levelDisplay() { 
        Queue<Node<T>> queue = new Queue<Node<T>>();
        queue.enqueue(root);
        while (! queue.isEmpty() ) {
            Node<T> cur = queue.dequeue();
            if (cur == null) continue;
            System.out.println(cur.data);
            queue.enqueue(cur.leftChild);
            queue.enqueue(cur.rightChild);
        }
    }

    public void levelDisplayV2() { 
        Queue<Node<T>> queue = new Queue<Node<T>>();
        if (root != null) queue.enqueue(root);
        while (! queue.isEmpty() ) {
            Node<T> cur = queue.dequeue();
            System.out.println(cur.data);
            if (cur.leftChild != null) queue.enqueue(cur.leftChild);
            if (cur.rightChild != null) queue.enqueue(cur.rightChild);
        }
    }
    
    // public boolean delete(int key) { return false; }
    public boolean delete(int key) {
        Node<T> parent = root, cur = root;
        // step 1: find the node
        while (cur.key != key) {
            parent = cur;
            cur = (key < cur.key) ? cur.leftChild : cur.rightChild;
            if (cur == null)
                return false;
        }
        // case 1: deleting a leaf
        if (cur.leftChild == null && cur.rightChild == null) {
            if (cur == root)
                root = null;
            else if (key < parent.key)
                parent.leftChild = null;
            else
                parent.rightChild = null;
            return true;
        }
        // case 2: deleting a node with only one child.
        if (cur.leftChild == null) {
            if (cur == root)
                root = cur.rightChild;
            else if (key < parent.key)
                parent.leftChild = cur.rightChild;
            else
                parent.rightChild = cur.rightChild;
            return true;
        }
        if (cur.rightChild == null) {
            if (cur == root)
                root = cur.leftChild;
            else if (key < parent.key)
                parent.leftChild = cur.leftChild;
            else
                parent.rightChild = cur.leftChild;
            return true;
        }
        // case 3: deleting a node with two children.
        // find the successor
        Node<T> successorParent = cur;
        Node<T> successor = cur.rightChild;
        while (successor.leftChild != null) {
            successorParent = successor;
            successor = successor.leftChild;
        }
        System.out.println(cur.leftChild + "?");
        // the above can be replaced by
        // TreeNode successor = findMin(cur.rightChild)
        // delete(successor);
        if (cur == root)
            root = successor;
        if (parent.leftChild == cur)
            parent.leftChild = successor;
        if (parent.rightChild == cur)
            parent.rightChild = successor;
        successor.leftChild = cur.leftChild;
        if (successorParent != cur) { // i.e., successor != cur.rightChild
            successorParent.leftChild = successor.rightChild;
            successor.rightChild = cur.rightChild;
        }
        return true;
    }
    
    public static void main(String[] args) {
        BinarySearchTree<Student> tree = new BinarySearchTree<Student>();
        tree.insert(214, new Student(214, "Chan Eason"));
        tree.insert(562, new Student(562, "Cheung Jacky"));
        tree.insert( 83, new Student( 83, "Ho Denise"));
        tree.insert(115, new Student(115, "Lam Carrie"));
        tree.insert( 97, new Student( 97, "Leung CY"));
        tree.insert(722, new Student(722, "Leung Gigi"));
        tree.insert(398, new Student(398, "Tang Gloria"));
        tree.insert(798, new Student(798, "Tong Timothy"));
        tree.insert(408, new Student(408, "Tsang Donald"));
        tree.insert(199, new Student(199, "Tse Kay"));
        tree.insert(337, new Student(337, "Tung Chee-hwa"));
        System.out.println("tree built.");
        //tree.levelDisplay();
        tree.inorder(tree.root);

        System.out.println("==========search=========");
        System.out.println("199: " + tree.search(199));
        System.out.println("336: " + tree.search(336));

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter a number to search");
        System.out.println(tree.search(keyboard.nextInt()));

        System.out.println("Press enter to start insertion");
        keyboard.nextLine();keyboard.nextLine();
        System.out.println("inserting two new students.");
        tree.insert(336, new Student(336, "Yung Joey"));
        System.out.println("==========after insertion=========");
        tree.display();
        System.out.println("336: " + tree.search(336));
        System.out.println("377: " + tree.search(377));
        System.out.println("Press enter to start deletion");
        keyboard.nextLine();
        tree.delete(798);
        System.out.println("==========after deleting 798=========");
        tree.levelDisplay();
        tree.delete(722);
        System.out.println("==========after deleting 722=========");
        tree.levelDisplay();
        System.out.println("Enter a number to search");
        System.out.println(tree.search(keyboard.nextInt()));
        keyboard.close();
    }
}
