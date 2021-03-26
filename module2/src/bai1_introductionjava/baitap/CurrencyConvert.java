package bai1_introductionjava.baitap;

import java.util.Scanner;

public class CurrencyConvert {
    public static void main(String[] args) {
        boolean isContinue = true;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Nhập lựa chọn của bạn : \n1.Hiển thị tỉ giá\n2.Chuyển đổi USD qua VND");
            int choose = scanner.nextInt();
            switch (choose){
                case 1:
                    System.out.println("1 USD = 23000 VND.");
                    break;
                case 2:
                    System.out.println("Nhập vào số USD mà bạn muốn chuyển thành VND : ");
                    int usd = scanner.nextInt();
                    System.out.println(usd+" USD -> "+(usd*23000)+" VND");
                    isContinue = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
                    break;
            }
        } while (isContinue);
    }
}
