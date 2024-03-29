class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
		}
        Arrays.sort(intervals, (i1, i2) -> Integer.compare(i1[0], i2[0]));
        List<int[]> ret = new ArrayList<>();
        int[] curr = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= curr[1]) {
                curr[1] = Math.max(curr[1], intervals[i][1]);
            } else {
                ret.add(curr);
                curr = intervals[i];
            }
        }
        ret.add(curr);
        return ret.toArray(new int[ret.size()][]);
    }
}
