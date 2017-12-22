class Solution {
    public String countAndSay(int n) {
        String currLine = "1";
        while (n-- > 1) {
            String prevLine = currLine;
            // iterate over prev and update curr
            currLine = "";
            int count = 1;
            char prevChar = prevLine.charAt(0);
            for (int i = 1; i < prevLine.length(); i++) {
                char currChar = prevLine.charAt(i);
                if (currChar == prevChar) {
                    count++;
                } else {
                    currLine += count + "" + prevChar;
                    prevChar = currChar;
                    count = 1;
                }
            }
            currLine += count + "" + prevChar;
        }
        return currLine;
    }
}
