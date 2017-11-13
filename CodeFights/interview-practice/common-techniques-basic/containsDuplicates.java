boolean containsDuplicates(int[] a) {
    HashSet<Integer> set = new HashSet<Integer>();
    for (int b : a) {
        if (set.contains(b)) {
            return true;
        } else {
            set.add(b);
        }
    }
    return false;
}
