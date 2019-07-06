package com.dekapx.datastructures.fundamentals;

import java.util.Scanner;

public class TimeConversion {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        final String time = scanner.next();
        int hours = Integer.parseInt(time.substring(0,2));
        if(time.charAt(8) == 'A') {
            if(hours == 12)
                System.out.print("00");
            else
                System.out.print(time.substring(0,2));
        }
        else if (hours == 12)
            System.out.print(hours);
        else
            System.out.print(hours + 12);
        System.out.println(time.substring(2,8));
    }
}
