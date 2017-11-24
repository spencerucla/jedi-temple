boolean isCryptSolution(String[] crypt, char[][] solution) {
    for (int i = 0; i < crypt.length; i++) {
        for (char[] stupid : solution) {
            crypt[i] = crypt[i].replaceAll("" + stupid[0], "" + stupid[1]);
        }
    }
    long[] nums = new long[3];
    for (int i = 0; i < crypt.length; i++) {
        nums[i] = Long.parseLong(crypt[i]);
        if (crypt[i].startsWith("0") && (nums[i] != 0 || crypt[i].length() > 1))
            return false;
    }
    return (nums[0] + nums[1] == nums[2]);
}

