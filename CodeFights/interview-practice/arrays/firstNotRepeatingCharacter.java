char firstNotRepeatingCharacter(String s) {
    int[] count = new int[26]; // rename
    for (int i = 0; i < count.length; i++) {
        count[i] = -1;
    }
    // -1 = starting val
    // 0 - s.length = first pos of instance
    // -2 = multiple found
    for (int i = 0; i < s.length(); i++) {
        int ltrNum = s.charAt(i) - 'a';
        if (count[ltrNum] == -1) {
            count[ltrNum] = i;
        } else if (count[ltrNum] >= 0) {
            count[ltrNum] = -2;
        }
    }
    int first = Integer.MAX_VALUE;
    for (int i = 0; i < count.length; i++) {
        if (count[i] != -1 && count[i] != -2 && count[i] < first) {
            first = count[i];
        }
    }
    return (first != Integer.MAX_VALUE) ? s.charAt(first) : '_';
}
