package bai11_map_tree.thuchanh.comparable_comparator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Student student = new Student("p",18,"da nang");
        Student student1 = new Student("h",16,"da nang");
        Student student2 = new Student("i",15,"da nang");
        Student student3 = new Student("n",17,"da nang");
        List<Student> students = new ArrayList<>();
        students.add(student);
        students.add(student1);
        students.add(student2);
        students.add(student3);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
        AgeComparator ageComparator = new AgeComparator();
        Collections.sort(students,ageComparator);
        for (int i = 0; i < students.size(); i++) {
            System.out.println(students.get(i));
        }
    }
}
