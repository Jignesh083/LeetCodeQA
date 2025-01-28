package com.main;

public class GCDOfStrings {
    public static void main(String[] args) {
        String str1 = "abcabc";
        String str2 = "abc";
        System.out.println(gcdOfStrings(str1, str2));  // Output: ""
    }

    public static String gcdOfStrings(String str1, String str2) {
        // Convert both strings to uppercase
        str1 = toUpperCase(str1);
        str2 = toUpperCase(str2);

        // Step 1: Concatenation Check
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        
        // Step 2: Find the greatest common divisor of lengths of str1 and str2
        int gcdLength = gcd(str1.length(), str2.length());
        
        // Step 3: Return the substring of str1 from the beginning to the gcd length
        return str1.substring(0, gcdLength);
    }

    // Function to convert a string to uppercase
    public static String toUpperCase(String str) {
        return str.toUpperCase();
    }

    // Helper method to find the greatest common divisor (GCD) of two integers
    public static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
