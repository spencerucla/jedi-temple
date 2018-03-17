class Solution {
    public int findCircleNum(int[][] M) {
        int numCircles = 0;
        Set<Integer> checked = new HashSet<Integer>();
        for (int i = 0; i < M.length; /* see bottom of loop */) {
            Set<Integer> friendCircle = new HashSet<Integer>();
            friendCircle.add(i);
            Queue<Integer> queueToCheck = new LinkedList<Integer>();
            queueToCheck.add(i);

            while (!queueToCheck.isEmpty()) {
                int toCheck = queueToCheck.poll();
                for (int j = 0; j < M[toCheck].length; j++) {
                    if (M[toCheck][j] == 1 && !friendCircle.contains(j)) {
                        friendCircle.add(j);
                        queueToCheck.add(j);
                    }
                }
            }
            numCircles++;

            checked.addAll(friendCircle);
            while (checked.contains(i)) {
                i++;
            }
        }
        return numCircles;
    }
}
