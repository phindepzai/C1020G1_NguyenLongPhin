package bai8_cleancode.thuchanh;

public class FizzBuzz {
    public static String fizzBuzz(int number){
        boolean isFizzBuzz = number % 3 == 0 && number % 5 == 0;
        if(isFizzBuzz)
            return "FizzBuzz";

        boolean isFizz = number % 3 == 0;
        if(isFizz)
            return "Fizz";

        boolean isBuzz = number % 5 == 0;
        if(isBuzz)
            return "Buzz";

        return number + "";
    }
}
