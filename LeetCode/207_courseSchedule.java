class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];
        for (int[] prereq : prerequisites) {
            inDegree[prereq[0]]++;
        }
        Queue<Integer> toCheck = new LinkedList();
        int count = 0;
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                toCheck.add(i);
                count++;
            }
        }

        while (!toCheck.isEmpty()) {
            int course = toCheck.poll();
            // TODO: create ArrayList for faster lookup instead of this loop
            for (int i = 0; i < prerequisites.length; i++) {
                if (prerequisites[i][1] == course) {
                    inDegree[prerequisites[i][0]]--;
                    if (inDegree[prerequisites[i][0]] == 0) {
                        toCheck.add(prerequisites[i][0]);
                        count++;
                    }
                }
            }
        }
        return count == numCourses;
    }
}
