package bai10_stack_queue.baitap;

import java.util.Arrays;
import java.util.Stack;

public class ReverseArrayByStack {


    public static String reverseStr(String str) {
        String[] arr = str.split("");
        str = "";
        reverseArr(arr);
        for (int i = 0; i < arr.length;i++) {
            str += arr[i];
        }
        return str;
    }

    public static <T> T[] reverseArr(T[] arr) {
        Stack<T> stack = new Stack<>();
        for (int i = 0; i < arr.length; i++) {
            stack.push(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            arr[i] = stack.pop();
        }
        return arr;
    }

    public static void main(String[] args) {
        Integer[] intArr = {1, 2, 3};
        String str = "aloalo";

        System.out.println(reverseStr(str));
        System.out.println(Arrays.toString(reverseArr(intArr)));
    }
}
