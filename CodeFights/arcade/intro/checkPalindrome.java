boolean checkPalindrome(String inputString) {
    for (int i = 0; i < inputString.length() / 2; i++) {
        if (inputString.charAt(i) != inputString.charAt(inputString.length() - 1 - i)) {
            return false;
        }
    }
    return true;
}

