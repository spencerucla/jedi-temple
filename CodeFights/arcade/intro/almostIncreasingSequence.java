boolean almostIncreasingSequence(int[] sequence) {
    boolean hasInversion = false;
    boolean removalBad = false; // removal would lead to !increasing
    for (int i = 1; i < sequence.length; i++) {
        if (sequence[i-1] >= sequence[i]) {
            if (hasInversion) {
                return false;
            }
            hasInversion = true;
        }
        if (i >= 2 && sequence[i-2] >= sequence[i]) {
            if (removalBad) {
                return false;
            }
            removalBad = true;
        }
    }
    return true;
}

