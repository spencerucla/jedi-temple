class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            List<String> list = map.containsKey(sorted) ? map.get(sorted) : new ArrayList<>();
            list.add(strs[i]);
            map.put(sorted, list);
        }
        List<List<String>> ret = new ArrayList<>();
        for (Map.Entry<String, List<String>> iter : map.entrySet()) {
            ret.add(iter.getValue());
        }
        return ret;
    }
}
