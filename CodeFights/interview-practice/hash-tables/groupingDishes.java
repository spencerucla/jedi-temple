String[][] groupingDishes(String[][] dishes) {
    HashMap<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
    for (int i = 0; i < dishes.length; i++) {
        for (int j = 1; j < dishes[i].length; j++) {
            ArrayList<String> list = map.get(dishes[i][j]);
            if (list == null) {
                list = new ArrayList<String>();
                list.add(dishes[i][0]);
                map.put(dishes[i][j], list);
            } else {
                list.add(dishes[i][0]);
            }
        }
    }

    int count = 0;
    for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
        if (entry.getValue().size() >= 2) {
            count++;
        }
    }

    String[][] out = new String[count][];
    int num = 0;
    for (Map.Entry<String, ArrayList<String>> entry : map.entrySet()) {
        ArrayList<String> value = entry.getValue();
        if (value.size() >= 2) {
            Collections.sort(value);
            String[] arr = new String[value.size()+1];
            arr[0] = entry.getKey();
            for (int j = 0; j < value.size(); j++) {
                arr[j+1] = value.get(j);
            }
            out[num++] = arr;
        }
    }

    Arrays.sort(out, new Comparator<String[]>() {
        @Override
        public int compare(String[] o1, String[] o2) {
            return o1[0].compareTo(o2[0]);
        }
    });
    return out;
}

