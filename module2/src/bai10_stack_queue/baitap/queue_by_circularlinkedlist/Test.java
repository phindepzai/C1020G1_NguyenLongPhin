package bai10_stack_queue.baitap.queue_by_circularlinkedlist;


import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

public class Test {
    public static class Student{
        private String name;
        private int age;

        public Student(String name,int age){
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
    public static void main(String[] args) {
        SortedSet<Student> treeSet = new TreeSet<>(Comparator.comparing(Student::getAge));
        treeSet.add(new Student("phin",16));
        treeSet.add(new Student("phong",15));
        treeSet.add(new Student("phen",14));
        System.out.println(treeSet);
    }
}
