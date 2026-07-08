class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        for (int[] p : prerequisites) {
            int course = p[0];
            int prerequisite = p[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        int[] topo = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {

            int node = q.poll();
            topo[index++] = node;

            for (int neighbor : adj.get(node)) {
                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        if (index != numCourses) {
            return new int[0];
        }

        return topo;
    }
}