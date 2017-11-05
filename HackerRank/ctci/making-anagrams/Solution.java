// https://www.hackerrank.com/challenges/ctci-making-anagrams

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class Solution {
    
    public static int numberNeeded(String first, String second) {
        int[] letters = new int[26];
        for (int i = 0; i < first.length(); i++) {
            char c = first.charAt(i);
            letters[c-'a']++;
        }
        for (int i = 0; i < second.length(); i++) {
            char c = second.charAt(i);
            letters[c-'a']--;
        }
        int count = 0;
        for (int v : letters) {
            count += Math.abs(v);
        }
        return count;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }
}
