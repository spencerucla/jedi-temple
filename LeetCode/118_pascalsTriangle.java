class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (numRows == 0)
            return ret;
        ret.add(new ArrayList<Integer>(Arrays.asList(1)));
        for (int i = 1; i < numRows; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int prev = 0;
            for (int num : ret.get(i-1)) {
                list.add(prev + num);
                prev = num;
            }
            list.add(1);
            ret.add(list);
        }
        return ret;
    }
}
