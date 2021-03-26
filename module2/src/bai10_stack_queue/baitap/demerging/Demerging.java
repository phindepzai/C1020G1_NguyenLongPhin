package bai10_stack_queue.baitap.demerging;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Demerging {
    public static void main(String[] args) {
        Queue<Employee> queue = new LinkedList<Employee>();
        queue.add(new Employee("john", "male", "12/03/1994"));
        queue.add(new Employee("Ann", "female", "12/01/1998"));
        queue.add(new Employee("Selena", "female", "12/01/1992"));
        queue.add(new Employee("Peter", "male", "12/02/1991"));
        queue.add(new Employee("Mark", "male", "12/03/1991"));
        List<Employee> male = new LinkedList<Employee>();
        List<Employee> female = new LinkedList<Employee>();
        for (Employee choose : queue) {
            if (choose.getSex().equals("male")) {
                male.add(choose);
            } else {
                female.add(choose);
            }
        }
        Collections.sort(female);
        Collections.sort(male);
        List<Employee> afterSort = new LinkedList<>();
        afterSort.addAll(female);
        afterSort.addAll(male);
        for (Employee queue1 : afterSort) {
            System.out.println(queue1);
        }
    }
}
