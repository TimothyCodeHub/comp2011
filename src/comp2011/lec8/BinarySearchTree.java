package comp2011.lec8;

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
            leftChild=null;
            rightChild = null;
        }

        public String toString() {
            return data.toString();
        }
    }

    Node<T> root;

    public BinarySearchTree() {
    	root = null;
    }

    // how to rewrite this with recursion?
    public Node<T> search(int key) {
    	Node cur = root;
    	while(cur != null) {
    		
    	if(cur.key == key) {
    		return cur;
    	}else if(key < cur.key) {
    		cur = cur.leftChild;
    	}else {
    		cur = cur.rightChild;
    	}
    	
    	}
        return null;
    }

    public Node<T> insert (Node<T> curRoot, int key, T data) {
    	curRoot = new Node(key,data);
        return curRoot;
    }
    // starter for the recursive version.
    public void insert (int key, T data) {
    	
        Node<T> newNode = insert(root, key, data);
        if (root == null) {root = newNode; return;} 
        
        Node cur = root;
        while(cur != null) {
        	Node parent = cur;
        	if(newNode.key < cur.key) {
        		cur = cur.leftChild;
        		if(cur == null) {parent.leftChild = newNode; return;}
        	}else {
        		cur = cur.rightChild;
        		if(cur == null) {parent.rightChild = newNode;return;}
        	}
        }
        
        
    }

    // you're suggested to finish search() before this.
    public void recInsert(int key, T data) { }
    
    public boolean delete(int key) { return false; }

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

    public Node<T> predecessor(Node<T> x) {
    	if(x==null) return null;
    	Node preNode = x;
    	if(x.leftChild !=null) {
    		preNode =x.leftChild;
    		while(preNode.rightChild !=null) {
    			preNode = preNode.rightChild;
    		}
    		return preNode;
    	}
    	
    	Node begin = root;
    	while(begin!=null) {
    		if(begin.key < x.key) {
    			preNode = begin;
    			begin = root.rightChild;
    		}else if(begin.key > x.key) {
    			begin = begin.leftChild;
    		}else {
    			break;
    		}
    	}
    	
    	
    	
    	return preNode;
    }   

    public Node<T> successor(Node<T> x) {
        if(x==null) return null;    	
    	
    	Node sNode = x;
    	if(x.rightChild != null) {
    		sNode = x.rightChild;
    		while(sNode.leftChild !=null) {
    			sNode = sNode.leftChild;
    		}
    		return sNode;
    	}
    	
    	Node begin = root;
    	while(begin != null) {
    		if(x.key < begin.key) {
    			sNode = begin;
    			begin = root.leftChild;
    		}else if(x.key > begin.key) {
				begin = begin.rightChild;
			}else {
			    break;
			}
    		
    	}
    	return sNode;

    }

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
        
        System.out.println("successor of root(214) are :" +tree.successor(tree.root));
        System.out.println("predecessor of root(214) are :" +tree.predecessor(tree.root));

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
