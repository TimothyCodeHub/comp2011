package comp2011.lec6;

public class Student implements Comparable<Student>{
    String name;
    String id;
    String major;
    String email;
    String phone;

    public int compareTo(Student s2) {
        return id.compareTo(s2.id);
    }
    Student[] students;
}
