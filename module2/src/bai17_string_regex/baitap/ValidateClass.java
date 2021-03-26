package bai17_string_regex.baitap;

public class ValidateClass {
    public static void main(String[] args) {
        String regex = "[CAP][0-9]{4}[GHIKLM][0-9]";
        System.out.println("C1020G1".matches(regex));
    }
}
