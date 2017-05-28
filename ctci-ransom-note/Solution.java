// https://www.hackerrank.com/challenges/ctci-ransom-note

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    public static boolean fullyContains(String[] magazine, String[] ransom) {
        HashMap<String, Integer> hm = new HashMap<String, Integer>();
        for (int i = 0; i < magazine.length; i++) {
            if (hm.containsKey(magazine[i])) {
                int prev = hm.get(magazine[i]);
                hm.put(magazine[i], prev+1);
            } else {
                hm.put(magazine[i], 1);
            }
        }
        for (int i = 0; i < ransom.length; i++) {
            if (!hm.containsKey(ransom[i]) || hm.get(ransom[i]) <= 0) {
                return false;
            }
            int prev = hm.get(ransom[i]);
            hm.put(ransom[i], prev-1);
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazine[] = new String[m];
        for(int magazine_i=0; magazine_i < m; magazine_i++){
            magazine[magazine_i] = in.next();
        }
        String ransom[] = new String[n];
        for(int ransom_i=0; ransom_i < n; ransom_i++){
            ransom[ransom_i] = in.next();
        }
        System.out.println(fullyContains(magazine, ransom) ? "Yes" : "No");
    }
}
