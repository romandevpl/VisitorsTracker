package com.company;

public class TimeConverter {
    public static int convertToNumber(String time) {
        return Integer.parseInt(time.substring(0, 2) + time.substring(3, 5));
    }

    public static String convertToTime(int number) {
        return "" + number / 100 + ":" + number % 100;
    }

}
