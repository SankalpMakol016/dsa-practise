

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        Queue<Integer> q = new LinkedList<>();
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                bfs(i, q, visited, isConnected);
            }
        }

        return count;
    }

    void bfs(int node, Queue<Integer> q, boolean[] visited, int[][] isConnected) {
        visited[node] = true;
        q.offer(node);

        while (!q.isEmpty()) {
            int curr = q.poll();

            for (int i = 0; i < isConnected.length; i++) {
                if (isConnected[curr][i] == 1 && !visited[i]) {
                    visited[i] = true;
                    q.offer(i);
                }
            }
        }
    }
}
