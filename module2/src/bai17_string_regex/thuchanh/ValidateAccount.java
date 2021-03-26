package bai17_string_regex.thuchanh;

public class ValidateAccount {
    public static void main(String[] args) {
        String regex = "[_a-z0-9]{6,}";
        String[] validAccount = new String[]{"123abc_", "_abc123", "______", "123456", "abcdefgh"};
        String[] invalidAccount = new String[]{".@", "12345", "1234_", "abcde"};
        for (String element : validAccount) {
            System.out.println(element + " : " + element.matches(regex));
        }
        for (String element : invalidAccount) {
            System.out.println(element + " : " + element.matches(regex));
        }
    }
}
