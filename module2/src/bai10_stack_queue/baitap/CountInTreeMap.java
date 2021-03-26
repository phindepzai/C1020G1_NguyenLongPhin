package bai10_stack_queue.baitap;

import java.util.Scanner;
import java.util.TreeMap;

public class CountInTreeMap {
    public static void main(String[] args) {
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        System.out.println("Nhập vào chuỗi bất kì : ");
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] arr = str.split("");
        for (int i = 0; i < arr.length; i++) {
            if (!treeMap.containsKey(arr[i])) {
                treeMap.put(arr[i], 1);
            } else {
                treeMap.replace(arr[i], treeMap.get(arr[1]) + 1);
            }
        }
        System.out.println(treeMap);
    }
}
