package bai17_string_regex.baitap;

public class ValidatePhoneNumber {
    public static void main(String[] args) {
        String regex = "\\([0-9]{2}\\)-\\(0[0-9]{9}\\)";
        System.out.println("(84)-(0978489648)".matches(regex));
        System.out.println("(a8)-(22222222)".matches(regex));
    }
}
