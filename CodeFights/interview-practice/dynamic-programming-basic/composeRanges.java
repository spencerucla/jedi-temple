String[] composeRanges(int[] nums) {
    if (nums.length == 0) {
        return new String[0];
    }
    int start = nums[0];
    ArrayList<String> ranges = new ArrayList<String>();
    for (int i = 1; i < nums.length; i++) {
        if (nums[i-1] + 1 != nums[i]) {
            ranges.add(format(start, nums[i-1]));
            start = nums[i];
        }
    }
    ranges.add(format(start, nums[nums.length-1]));
    return ranges.toArray(new String[ranges.size()]);
}

String format(int start, int end) {
    return (start != end ? start + "->" : "") + end;
}
