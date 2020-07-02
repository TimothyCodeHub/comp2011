package comp2011.lec6;

public class LinkedList<T> {
    static class Node<T> {
        T element;
        Node<T> next;

        public Node(T a) {
            element = a;
            next = null;
        }
    }

    Node<T> head, tail;

    public LinkedList() {
        head = tail = null;
    }

    public void insertFirst(T a) {
        Node<T> newNode = new Node<T>(a);
        newNode.next = head;
        head = newNode;
    }

    public void insertLast(T a) {
        if (head == null) {
            insertFirst(a);
            return;
        }

        Node<T> cur = head;
        while (cur.next != null)
            cur = cur.next;
        Node<T> newNode = new Node<T>(a);
        newNode.next = null;
        cur.next = newNode;
    }

    public void insertAfter(Node<T> node, T a) {
    }

    public T removeFirst() {
        if (head == null) {
            System.out.println("downflow");
            return null;
        }
        Node<T> temp = head;
        head = head.next;
        temp.next = null;
        return temp.element;
    }

    public T removeLast() {
        // if (head == null) {System.out.println("downflow"); return null;}
        // if (head.next == null) {
        // Node temp = head;
        // head = null;
        // return temp.element;
        // }

        if (head == null || head.next == null)
            return removeFirst();

        Node<T> secondToLast = head;
        while (secondToLast.next.next != null)
            secondToLast = secondToLast.next;
        Node<T> temp = secondToLast.next;
        secondToLast.next = null;
        return temp.element;
    }

    public Node<T> reverse(Node<T> node) {
        if (node == null || node.next == null)
            return node;
        Node<T> second = node.next;
        node.next = null;
        Node<T> newHead = reverse(second);
        second.next = node;
        return newHead;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node<T> cur = head;
        while (cur != null) {
            sb.append(cur.element);
            if (cur.next != null)
                sb.append(" -> ");
            cur = cur.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkedList<String> list = new LinkedList<String>();
        list.insertFirst("Shenzhen");
        list.insertFirst("Hong Kong");
        list.insertLast("Guangzhou");
        System.out.println(list);
        list.insertLast("Changsha");
        list.insertLast("Wuhan");
        list.insertLast("Zhengzhou");
        list.insertLast("Beijing");
        list.insertLast("Shenyang");
        System.out.println(list);
        System.out.println("delete the last, which is " + list.removeLast());
        System.out.println(list);
        list.head = list.reverse(list.head);
        System.out.println("after reversion, it becomes " + list);
    }
}
