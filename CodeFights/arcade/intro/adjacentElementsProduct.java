int adjacentElementsProduct(int[] inputArray) {
    int max = Integer.MIN_VALUE;
    for (int i = 1; i < inputArray.length; i++) {
        int prod = inputArray[i-1] * inputArray[i];
        if (prod > max) {
            max = prod;
        }
    }
    return max;
}

