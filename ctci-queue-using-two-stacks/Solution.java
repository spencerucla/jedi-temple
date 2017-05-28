// https://www.hackerrank.com/challenges/ctci-queue-using-two-stacks

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static class MyQueue<T> {
        private Stack<T> inbox = new Stack<T>();
        private Stack<T> outbox = new Stack<T>();
        
        public void enqueue(T v) {
            inbox.push(v);
        }
        
        private void move() {
            if (outbox.empty()) {
                while (!inbox.empty()) {
                    outbox.push(inbox.pop());
                }
            }
        }
        
        public void dequeue() {
            move();
            outbox.pop();
        }
        
        public T peek() {
            move();
            return outbox.peek();
        }
    }
    
    public static void main(String[] args) {
        MyQueue<Integer> queue = new MyQueue<Integer>();

        Scanner scan = new Scanner(System.in);
        int n = scan.nextInt();

        for (int i = 0; i < n; i++) {
            int operation = scan.nextInt();
            if (operation == 1) { // enqueue
              queue.enqueue(scan.nextInt());
            } else if (operation == 2) { // dequeue
              queue.dequeue();
            } else if (operation == 3) { // print/peek
              System.out.println(queue.peek());
            }
        }
        scan.close();
    }
}
\