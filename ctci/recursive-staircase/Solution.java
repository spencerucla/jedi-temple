// https://www.hackerrank.com/challenges/ctci-recursive-staircase

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static int numWays(int cur, int size, Map<Integer, Integer> mem) {
        if (cur == size) {
            return 1;
        } else if (cur > size) {
            return 0;
        }
        if (mem.containsKey(cur)) {
            return mem.get(cur);
        }
        int r1 = numWays(cur+1, size, mem);
        int r2 = numWays(cur+2, size, mem);
        int r3 = numWays(cur+3, size, mem);
        int tot = r1 + r2 + r3;
        mem.put(cur, tot);
        return tot;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        for(int a0 = 0; a0 < s; a0++){
            int n = in.nextInt();
            HashMap<Integer, Integer> mem = new HashMap<Integer, Integer>();
            System.out.println(numWays(0, n, mem));
        }
    }
}

