// https://www.hackerrank.com/challenges/ctci-is-binary-search-tree

/* Hidden stub code will pass a root argument to the function below. Complete the function to solve the challenge. Hint: you may want to write one or more helper functions.  

The Node class is defined as follows:
    class Node {
        int data;
        Node left;
        Node right;
     }
*/

    boolean checkBST(Node node, int min, int max) {
        if (node.data <= min || node.data >= max) {
            return false;
        }
        boolean pass = true;
        if (node.left != null) {
            pass = pass && checkBST(node.left, min, node.data);
        }
        if (node.right != null) {
            pass = pass && checkBST(node.right, node.data, max);
        }
        return pass;
    }

    boolean checkBST(Node root) {
        return checkBST(root, 0, Integer.MAX_VALUE);
    }
