class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevRow = new ArrayList<Integer>(Arrays.asList(1));
        for (int i = 0; i < rowIndex; i++) {
            List<Integer> list = new ArrayList<Integer>();
            int prevNum = 0;
            for (int num : prevRow) {
                list.add(prevNum + num);
                prevNum = num;
            }
            list.add(1);
            prevRow = list;
        }
        return prevRow;
    }
}
