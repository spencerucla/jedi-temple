int insertBits(int n, int a, int b, int k) {
    int mask = ((1 << (b - a + 1)) - 1) << a;
    return (n & ~mask) | ((k << a));
}