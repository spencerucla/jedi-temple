// https://www.hackerrank.com/challenges/fraudulent-activity-notifications

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    // TODO: clean up
    private static double median(int[] counts, int total) {
        int midCount = 0;
        for (int i = 0; i < counts.length; i++) {
            midCount += counts[i];
            if (total % 2 == 0 && midCount == total / 2) {
                // find next elem of count with a non-zero value
                int next = i+1;
                while (counts[next] == 0)
                    next++;
                return (i + next) / 2.0;
            } else if (midCount > total / 2) {
                return i;
            }
        }
        return 0;
    }
    
    static int activityNotifications(int[] expenditures, int d) {
        int[] counts = new int[201];
        int count = 0;
        for (int i = 0; i < expenditures.length; i++) {
            if (i - d >= 0) {
                if (expenditures[i] >= 2 * median(counts, d)) {
                    count++;
                }
                counts[expenditures[i-d]]--;
            }
            counts[expenditures[i]]++;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int d = in.nextInt();
        int[] expenditure = new int[n];
        for(int expenditure_i = 0; expenditure_i < n; expenditure_i++){
            expenditure[expenditure_i] = in.nextInt();
        }
        int result = activityNotifications(expenditure, d);
        System.out.println(result);
        in.close();
    }
}

