package bai3_array_methods.thuchanh;

public class MinArrayUseMethod {
    public static int getMin(int[] arr){
        int min = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (min > arr[i]){
                min = arr[i];

            }
        }
        return min;
    }
    public static void main(String[] args) {
        int []arr = {4, 12, 7, 8, 1, 6, 9};
        int min = getMin(arr);
        System.out.println("The smallest element in the array is: " + min);
    }
}
