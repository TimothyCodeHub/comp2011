package comp2011.lec9;

public class HeapTester {
    static class Student {
        int id;
        String name;

        public Student(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Heap<Student> heap = new Heap<Student>(20);
        heap.insert(214, new Student(214, "Chan Eason"));
        heap.insert(562, new Student(562, "Cheung Jacky"));
        heap.insert( 83, new Student( 83, "Ho Denise"));
        heap.insert(115, new Student(115, "Lam Carrie"));
        heap.insert( 97, new Student( 97, "Leung CY"));
        heap.insert(722, new Student(722, "Leung Gigi"));
        heap.insert(398, new Student(398, "Tang Gloria"));
        heap.insert(798, new Student(798, "Tong Timothy"));
        heap.insert(408, new Student(408, "Tsang Donald"));
        heap.insert(199, new Student(199, "Tse Kay"));
        heap.insert(337, new Student(337, "Tung Chee-hwa"));
        System.out.print(heap);
        heap.deleteMax();
        System.out.println("=====================");
        System.out.print(heap);
    }
}
