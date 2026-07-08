class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;

        List<List<Integer>> rev = new ArrayList<>();

        for (int i = 0; i < V; i++) {
            rev.add(new ArrayList<>());
        }

        int[] indegree = new int[V];

        // Reverse the graph
        for (int u = 0; u < V; u++) {
            for (int v : graph[u]) {
                rev.get(v).add(u);
                indegree[u]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        // Terminal nodes
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
            }
        }

        List<Integer> safe = new ArrayList<>();

        while (!q.isEmpty()) {

            int node = q.poll();
            safe.add(node);

            for (int neighbor : rev.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        Collections.sort(safe);

        return safe;
    }
}