class Solution {

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // prerequisite -> course
        for (int[] edge : prerequisites) {
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[numCourses];
        boolean[] pathVis = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if (!vis[i]) {
                if (dfs(i, adj, vis, pathVis))
                    return false;      // Cycle found
            }
        }

        return true;
    }

    private boolean dfs(int node,
                        ArrayList<ArrayList<Integer>> adj,
                        boolean[] vis,
                        boolean[] pathVis) {

        vis[node] = true;
        pathVis[node] = true;

        for (int neigh : adj.get(node)) {

            if (!vis[neigh]) {

                if (dfs(neigh, adj, vis, pathVis))
                    return true;

            } else if (pathVis[neigh]) {

                return true;
            }
        }

        pathVis[node] = false;

        return false;
    }
}