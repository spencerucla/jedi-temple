class Solution {
    private static final String[] KEYS = { "0", "1", "abc", "def", "ghi", "jkl",
                                           "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> tail = new ArrayList<String>(); tail.add("");
        if (digits.length() > 1)
            tail = letterCombinations(digits.substring(1));
        List<String> head = new ArrayList<String>(); head.add("");
        if (digits.length() > 0)
            head = getKeys(digits.charAt(0));
        List<String> ret = new ArrayList<String>();
        for (String h : head) {
            for (String t : tail) {
                ret.add("" + h + t);
            }
        }
        ret.remove("");
        return ret;
    }

    private List<String> getKeys(char c) {
        List<String> list = new ArrayList<String>();
        String arr = KEYS[c - '0'];
        for (int i = 0; i < arr.length(); i++) {
            list.add(arr.charAt(i);
        }
        return list;
    }
}
