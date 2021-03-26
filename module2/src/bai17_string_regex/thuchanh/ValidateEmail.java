package bai17_string_regex.thuchanh;

public class ValidateEmail {
    public static void main(String[] args) {
        String regex = "[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)";
        System.out.println("phindeptroai1@gmail.com".matches(regex));
    }
}
