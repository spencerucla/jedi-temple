class Solution {
    public String getHint(String secret, String guess) {
        int bullCount = 0;
        int cowCount = 0;
        int[] digitCounts = new int[10];
        for (int i = 0; i < secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) {
                bullCount++;
            } else {
                if (digitCounts[guess.charAt(i) - '0'] > 0) cowCount++;
                if (digitCounts[secret.charAt(i) - '0'] < 0) cowCount++;
                digitCounts[secret.charAt(i) - '0']++;
                digitCounts[guess.charAt(i) - '0']--;
            }
        }
      	return "" + bullCount + "A" + cowCount + "B";
    }
}

