class Solution {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 1) {
            return stuff(digits.charAt(0));
        }
        List<String> tail = new ArrayList<String>(); tail.add("");
        if (digits.length() > 1)
            tail = letterCombinations(digits.substring(1));
        List<String> head = new ArrayList<String>(); head.add("");
        if (digits.length() > 0)
            head = stuff(digits.charAt(0));
        List<String> ret = new ArrayList<String>();
        for (String h : head) {
            for (String t : tail) {
                ret.add("" + h + t);
            }
        }
        ret.remove("");
        return ret;
    }

    private List<String> stuff(char c) {
        List<String> list = new ArrayList<String>();
        switch (c) {
            case '2':
                list.add("a"); list.add("b"); list.add("c"); return list;
            case '3':
                list.add("d"); list.add("e"); list.add("f"); return list;
            case '4':
                list.add("g"); list.add("h"); list.add("i"); return list;
            case '5':
                list.add("j"); list.add("k"); list.add("l"); return list;
            case '6':
                list.add("m"); list.add("n"); list.add("o"); return list;
            case '7':
                list.add("p"); list.add("q"); list.add("r"); list.add("s"); return list;
            case '8':
                list.add("t"); list.add("u"); list.add("v"); return list;
            case '9':
                list.add("w"); list.add("x"); list.add("y"); list.add("z"); return list;
            default:
                list.add(""); return list;
        }
    }
}
