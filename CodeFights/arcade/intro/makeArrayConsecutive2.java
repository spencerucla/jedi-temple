int makeArrayConsecutive2(int[] statues) {
    int min = Integer.MAX_VALUE;
    int max = 0;
    for (int i = 0; i < statues.length; i++) {
        min = Math.min(min, statues[i]);
        max = Math.max(max, statues[i]);
    }
    return (max - min + 1) - statues.length;
}

