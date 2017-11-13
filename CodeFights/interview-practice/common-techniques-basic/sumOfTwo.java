boolean sumOfTwo(int[] a, int[] b, int v) {
    HashSet<Integer> aSet = new HashSet<Integer>();
    for (int x : a) {
        aSet.add(x);
    }
    for (int x : b) {
        if (aSet.contains(v - x)) {
            return true;
        }
    }
    return false;
}
