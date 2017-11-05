int[] sortByHeight(int[] a) {
    ArrayList<Integer> treePositions = new ArrayList<Integer>();
    ArrayList<Integer> heights = new ArrayList<Integer>();
    for (int i = 0; i < a.length; i++) {
        if (a[i] == -1) {
            treePositions.add(i);
        } else {
            heights.add(a[i]);
        }
    }

    Collections.sort(heights);
    for (int pos : treePositions) {
        heights.add(pos, -1);
    }

    int[] arr = new int[heights.size()];
    Iterator<Integer> iterator = heights.iterator();
    for (int i = 0; i < arr.length; i++)
    {
        arr[i] = iterator.next().intValue();
    }
    return arr;
}

