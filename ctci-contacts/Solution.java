// https://www.hackerrank.com/challenges/ctci-contacts

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    private static class Trie {
        private Node mRoot = new Node();

        private static class Node {
            public Map<Character, Node> kids = new HashMap<Character, Node>();
            public int numDescendants;
            public String toString() { return "(" + numDescendants + " " + kids.toString() + ")"; }
        }

        public void add(String name) {
            add(mRoot, name);
        }

        public void add(Node par, String name) {
            par.numDescendants++;
            if (name.length() == 0) {
                return;
            }
            char c = name.charAt(0);
            Node node;
            if (par.kids.containsKey(c)) {
                node = par.kids.get(c);
            } else {
                node = new Node();
                par.kids.put(c, node);
            }
            add(node, name.substring(1));
        }

        public int find(String name) {
            return find(mRoot, name);
        }

        public int find(Node par, String name) {
            if (name.length() == 0) {
                return par.numDescendants;
            } else if (par.kids.containsKey(name.charAt(0))) {
                return find(par.kids.get(name.charAt(0)), name.substring(1));
            } else {
                return 0;
            }
        }

        public String toString() { return mRoot.toString(); }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        Trie contacts = new Trie();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if (op.equals("add")) {
                contacts.add(contact);
            } else if (op.equals("find")) {
                System.out.println(contacts.find(contact));
            }
        }
    }
}

