// https://www.hackerrank.com/challenges/ctci-find-the-running-median

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) {
        Median m = new Median();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            m.insert(a[a_i]);
            System.out.println(m.get());
        }
    }
    
    private static class Median {
        private static class DecreasingComparator implements Comparator<Integer> {
            public int compare(Integer o1, Integer o2) {
                return -1 * o1.compareTo(o2);
            }
        }

        private PriorityQueue<Integer> mTopMinHeap = new PriorityQueue<Integer>(50000);
        private PriorityQueue<Integer> mBotMaxHeap = new PriorityQueue<Integer>(50000, new DecreasingComparator());
        
        private void insert(int val) {
            if (mTopMinHeap.size() + mBotMaxHeap.size() < 2) {
                // just insert first 2 entries
                mTopMinHeap.add(val);
            } else if (val > mTopMinHeap.peek()) {
                mTopMinHeap.add(val);
            } else {
                mBotMaxHeap.add(val);
            }
            // rebalance
            if (mTopMinHeap.size() >= mBotMaxHeap.size() + 2) {
                mBotMaxHeap.add(mTopMinHeap.poll());
            } else if (mBotMaxHeap.size() >= mTopMinHeap.size() + 2) {
                mTopMinHeap.add(mBotMaxHeap.poll());
            }
        }

        private double get() {
            // TODO: handle null peek
            if (mTopMinHeap.size() > mBotMaxHeap.size()) {
                return mTopMinHeap.peek();
            } else if (mTopMinHeap.size() < mBotMaxHeap.size()) {
                return mBotMaxHeap.peek();
            } else {
                return (mTopMinHeap.peek() + mBotMaxHeap.peek()) / 2.0;
            }
        }
    }
}
