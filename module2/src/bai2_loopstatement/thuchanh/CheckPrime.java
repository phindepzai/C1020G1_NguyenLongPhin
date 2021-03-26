package bai2_loopstatement.thuchanh;

import java.util.Scanner;

public class CheckPrime {
    public static boolean check(int num){
        int count = 0;
        for (int i = 1; i <= num; i++) {
            if (num % i == 0){
                count++;
            }
        }
        if (count == 2){
            return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int number;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập vào 1 số nguyên lớn hơn 0.");
            number = scanner.nextInt();
            if (number < 1){
                System.out.println("Số nhập vào không hợp lệ!");
            }else {
                break;
            }
        } while (true);
        System.out.println(check(number));;
    }
}
