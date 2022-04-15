class Solution {
    public String getHint(String secret, String guess) {
        int bullCount = 0;
        int[] digitCounts = new int[10];
        String remainingGuess = "";

        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullCount++;
            } else {
                digitCounts[secret.charAt(i) - '0']++;
                remainingGuess += guess.charAt(i);
            }
        }

        int cowCount = 0;
        for (int i = 0; i < remainingGuess.length(); i++) {
            char c = remainingGuess.charAt(i);
            if (digitCounts[c - '0'] > 0) {
                cowCount++;
                digitCounts[c - '0']--;
            }
        }

      	return "" + bullCount + "B" + cowCount + "C";
   }
}
