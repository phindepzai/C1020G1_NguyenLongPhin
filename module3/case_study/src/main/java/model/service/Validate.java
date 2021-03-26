package model.service;


public class Validate {
    public static boolean checkIdCard(String idCard){
        String regex = "\\d{9}|\\d{12}";
        return idCard.matches(regex);
    }

    public static boolean checkPhoneNumber(String phone){
        String regex = "(0|84)9[01](\\d{7})";
        return phone.matches(regex);
    }

    public static boolean checkEmail(String email) {
        String regexEmail = "^[a-zA-z]\\w{6,20}[@][a-zA-Z]{2,10}([.][a-zA-Z]{2,5}){1,2}";
        return email.matches(regexEmail);
    }

    public static boolean checkDate(String date){
        String regexDate = "([0-9]{2}[-/]){2}[0-9]{4}";
        if (!date.matches(regexDate)){
            return false;
        }
        if (date.length() != 10){
            return false;
        }
        int month = Integer.parseInt(date.substring(3,5));
        int day = Integer.parseInt(date.substring(0,2));
        int year = Integer.parseInt(date.substring(6,10));
        int dayMax;
        switch (month){
            case 2:
                dayMax = 28;
                if (isLeapYear(year)){
                    dayMax = 29;
                }
                break;
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                dayMax = 31;
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                dayMax = 30;
                break;
            default:
                return false;
        }
        return day >= 1 && day <= dayMax;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0){
            if (year % 100 == 0){
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static boolean isPositive(String numString){
        String regex = "\\d+([.]\\d+)?";
        Double number = 0.0;
        if (numString.matches(regex)){
            number = Double.parseDouble(numString);
            return number > 0;
        }
        return false;
    }

    public static String changeDateToView(String date){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(date.substring(8,10)+"-");
        stringBuilder.append(date.substring(5,7)+"-");
        stringBuilder.append(date.substring(0,4));
        return stringBuilder.toString();
    }

    public static String changeDateToDB(String date){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(date.substring(6,10)+"-");
        stringBuilder.append(date.substring(3,5)+"-");
        stringBuilder.append(date.substring(0,2));
        return stringBuilder.toString();
    }
}
