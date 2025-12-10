package org.example;

public class DebugTask4 {
    public static void main(String[] args) {
        System.out.println(isPalindrome(null));
    }
    public static boolean isPalindrome(String str) {
        //отсутствует проверка на null. Буду считать, что null всегда false
        if (str == null) return false;
        String reversed = new StringBuilder(str).reverse().toString();
        return str.equals(reversed);
    }
}