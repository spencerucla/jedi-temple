// https://www.hackerrank.com/challenges/ctci-balanced-brackets

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static final HashMap<String, String> opMatch;
    static {
        opMatch = new HashMap<String, String>();
        opMatch.put("(", ")");
        opMatch.put("{", "}");
        opMatch.put("[", "]");
    }
    
    public static boolean isBalanced(String expression) {
        Stack<String> stack = new Stack<String>();
        for (int i = 0; i < expression.length(); i++) {
            String op = expression.substring(i, i+1);
            switch (op) {
                case "(":
                case "{":
                case "[":
                    stack.push(op);
                    break;
                case ")":
                case "}":
                case "]":
                    if (stack.empty() || !opMatch.get(stack.pop()).equals(op)) {
                        return false;
                    }
                    break;
            }
        }
        return stack.empty();
        
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}
