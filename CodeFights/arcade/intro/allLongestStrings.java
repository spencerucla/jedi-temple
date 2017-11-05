String[] allLongestStrings(String[] inputArray) {
    int maxLen = 0;
    int count = 0;
    for (int i = 0; i < inputArray.length; i++) {
        if (inputArray[i].length() > maxLen) {
            maxLen = inputArray[i].length();
            count = 1;
        } else if (inputArray[i].length() == maxLen) {
            count++;
        }
    }
    String[] longestStrings = new String[count];
    int j = 0;
    for (int i = 0; i < inputArray.length; i++) {
        if (inputArray[i].length() == maxLen) {
            longestStrings[j++] = inputArray[i];
        }
    }
    return longestStrings;
}

