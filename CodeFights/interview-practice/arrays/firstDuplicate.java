int firstDuplicate(int[] a) {
    HashMap<Integer, Object> hash = new HashMap<Integer, Object>();
    for (int i = 0; i < a.length; i++) {
        if (hash.containsKey(a[i])) {
            return a[i];
        } else {
            hash.put(a[i], null);
        }
    }
    return -1;
}

