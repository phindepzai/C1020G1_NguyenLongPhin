public class test {
    public static boolean isPositive(String numString){
        String regex = "\\d+[.]\\d+";
        Double number = 0.0;
        if (numString.matches(regex)){
            number = Double.parseDouble(numString);
            return number > 0;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isPositive("10"));
    }
}
