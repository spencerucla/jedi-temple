boolean areFollowingPatterns(String[] strings, String[] patterns) {
    HashMap<String, String> pmap = new HashMap<String, String>();
    HashMap<String, String> smap = new HashMap<String, String>();
    for (int i = 0; i < strings.length; i++) {
        if (!pmap.containsKey(patterns[i])) {
            pmap.put(patterns[i], strings[i]);
        } else if (!pmap.get(patterns[i]).equals(strings[i])) {
            return false;
        }

        if (!smap.containsKey(strings[i])) {
            smap.put(strings[i], patterns[i]);
        } else if (!smap.get(strings[i]).equals(patterns[i])) {
            return false;
        }
    }
    return true;
}

