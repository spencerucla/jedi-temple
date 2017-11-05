int commonCharacterCount(String s1, String s2) {
    int NUM_LETTERS = 26;
    int[] s1count = new int[NUM_LETTERS];
    Arrays.fill(s1count, 0);
    int[] s2count = new int[NUM_LETTERS];
    Arrays.fill(s2count, 0);
    for (int i = 0; i < s1.length(); i++) {
        s1count[s1.charAt(i) - 'a']++;
    }
    for (int i = 0; i < s2.length(); i++) {
        s2count[s2.charAt(i) - 'a']++;
    }
    int count = 0;
    for (int i = 0; i < NUM_LETTERS; i++) {
        count += Math.min(s1count[i], s2count[i]);
    }
    return count;
}

