package com.furama.ulti;

import com.furama.entity.contract.Contract;
import com.furama.entity.customer.Customer;
import com.furama.entity.employee.Employee;

import java.util.Date;

public class Check {

    public static boolean checkDate(String date) {
        String regexDate = "[0-9]{4}([/-][0-9]{2}){2}";
        if (!date.matches(regexDate) || date.length() != 10) {
            return true;
        }
        int month = Integer.parseInt(date.substring(5, 7));
        int day = Integer.parseInt(date.substring(8, 10));
        int year = Integer.parseInt(date.substring(0, 4));
        Date now = new Date();
        int yearNow = now.getYear() + 1900;
        if (yearNow - year == 18) {
            if (month > now.getMonth() + 1) {
                return false;
            } else if (month == now.getMonth() + 1) {
                if (day > now.getDate()) {
                    return false;
                }
            }
        } else if (yearNow - year < 18 || year < 1900) {
            return false;
        }
        int dayMax;
        dayMax = getDayMax(month, year);
        return day >= 1 && day <= dayMax;
    }

    private static int getDayMax(int month, int year) {
        int dayMax;
        switch (month) {
            case 2:
                dayMax = 28;
                if (isLeapYear(year)) {
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
            default:
                dayMax = 30;
                break;
        }
        return dayMax;
    }

    public static boolean isLeapYear(int year) {
        if (year % 4 == 0) {
            if (year % 100 == 0) {
                return year % 400 == 0;
            } else {
                return true;
            }
        }
        return false;
    }

    public static String getDateYes() {
        Date date = new Date();
        int day;
        int month;
        int year;
        if (date.getDate() == 1) {
            day = getDayMax(date.getMonth(), date.getYear() + 1900);
            if (date.getMonth() == 1) {
                month = 12;
                year = date.getYear() + 1899;
            } else {
                month = date.getMonth();
                year = date.getYear() + 1900;
            }
        } else {
            day = date.getDate() - 1;
            month = date.getMonth() + 1;
            year = date.getYear() + 1900;
        }
        String dayStr;
        String monthStr;
        if (day < 10) {
            dayStr = "0" + day;
        } else {
            dayStr = "" + day;
        }
        if (month < 10) {
            monthStr = "0" + month;
        } else {
            monthStr = "" + month;
        }
        return year + "-" + monthStr + "-" + dayStr;
    }

    public static int getDate(String startDate, String endDate) {
        int day = 0;
        System.out.println(startDate);
        int dayStart = Integer.parseInt(startDate.substring(8, 10));
        int dayEnd = Integer.parseInt(endDate.substring(8, 10));
        int monthStart = Integer.parseInt(startDate.substring(5, 7));
        int monthEnd = Integer.parseInt(endDate.substring(5, 7));
        int yearStart = Integer.parseInt(startDate.substring(0, 4)) - 1;
        int yearEnd = Integer.parseInt(endDate.substring(0, 4)) - 1;
        int dayStartPlus = 0;
        for (int i = 1; i < monthStart; i++) {
            dayStartPlus += getDayMax(i, yearStart + 1);
        }
        int dayEndPlus = 0;
        for (int i = 1; i < monthEnd; i++) {
            dayEndPlus += getDayMax(i, yearEnd + 1);
        }
        day = (((yearEnd / 4) * 366) + ((yearEnd - (yearEnd / 4)) * 365) + dayEndPlus + dayEnd) -
                (((yearStart / 4) * 366) + ((yearStart - (yearStart / 4)) * 365) + dayStartPlus + dayStart);
        return day;
    }

    public static String getToday() {
        int day = Integer.parseInt(getDateYes().substring(8, 10)) + 1;
        String date = getDateYes().substring(0, 8);
        return date + day;
    }
}
