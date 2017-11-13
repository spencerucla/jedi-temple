int houseRobber(int[] nums) {
    int sumWithPrev = 0;
    int sumWithoutPrev = 0;
    for (int num : nums) {
        int tmp = Math.max(sumWithPrev, sumWithoutPrev);
        sumWithPrev = num + sumWithoutPrev;
        sumWithoutPrev = tmp;
    }
    return Math.max(sumWithPrev, sumWithoutPrev);
}

