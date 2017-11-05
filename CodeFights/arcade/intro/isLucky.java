boolean isLucky(int n) {
    int size = (int) Math.log10(n) + 1;
    int firstHalf = 0;
    int secondHalf = 0;
    for (int i = 0; i < size / 2; i++) {
        secondHalf += (n / Math.pow(10, i)) % 10;
    }
    for (int i = size / 2; i < size; i++) {
        firstHalf += (n / Math.pow(10, i)) % 10;
    }
    return firstHalf == secondHalf;
}

