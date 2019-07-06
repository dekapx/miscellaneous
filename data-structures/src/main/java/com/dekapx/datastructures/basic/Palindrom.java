package com.dekapx.datastructures.basic;

public class Palindrom {
    public static void main(String[] args) {
        final String inputStr = "abcda";
        System.out.println(isPalindrome(inputStr));
    }

    private static boolean isPalindrome(final String inputStr) {
        boolean flag = true;
        int j = inputStr.length() - 1;
        for(int i = 0; i < inputStr.length(); i++, j--) {
            if (inputStr.charAt(i) != inputStr.charAt(j)) {
                flag = false;
                break;
            }
        }

        return flag;
    }
}
