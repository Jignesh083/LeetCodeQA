package com.main.java;

public class MergeStrings {
    public static String mergeAlternately(String word1, String word2) {
        StringBuilder mergedString = new StringBuilder();
        int i = 0, j = 0;
        
        // Iterate through both strings and add letters alternately
        while (i < word1.length() && j < word2.length()) {
            mergedString.append(word1.charAt(i));
            mergedString.append(word2.charAt(j));
            i++;
            j++;
        }
        
        // Add remaining letters from the longer string
        while (i < word1.length()) {
            mergedString.append(word1.charAt(i));
            i++;
        }
        
        while (j < word2.length()) {
            mergedString.append(word2.charAt(j));
            j++;
        }
        
        return mergedString.toString();
    }

    public static void main(String[] args) {
        String word1 = "abcd";
        String word2 = "pq";
        String result = mergeAlternately(word1, word2);
        System.out.println(result); 
    }
}
