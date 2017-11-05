int shapeArea(int n) {
    // 1, 5, 13, 25, 41, etc.
    if (n == 1)
        return 1;
    return shapeArea(n-1) + 4*(n-1);
}

