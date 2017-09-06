// https://www.hackerrank.com/challenges/ctci-coin-change

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static long makeChange(int[] coins, int money) {
        long[] mem = new long[money+1];
        Arrays.fill(mem, 0);
        mem[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            int coin = coins[i];
            for (int j = 0; j <= money - coin; j++)
                mem[coin + j] += mem[j];
        }
        return mem[money];
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int coins[] = new int[m];
        for(int coins_i=0; coins_i < m; coins_i++){
            coins[coins_i] = in.nextInt();
        }
        System.out.println(makeChange(coins, n));
    }
}
