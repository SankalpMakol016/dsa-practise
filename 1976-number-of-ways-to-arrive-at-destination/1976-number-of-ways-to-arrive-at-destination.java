class Solution {

    class Pair {
        int node;
        long dist;

        Pair(int node, long dist) {
            this.node = node;
            this.dist = dist;
        }
    }

    public int countPaths(int n, int[][] roads) {

        int MOD = 1_000_000_007;

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());

        for (int[] road : roads) {
            adj.get(road[0]).add(new Pair(road[1], road[2]));
            adj.get(road[1]).add(new Pair(road[0], road[2]));
        }

        long[] dist = new long[n];
        Arrays.fill(dist, Long.MAX_VALUE);

        long[] ways = new long[n];

        PriorityQueue<Pair> pq =
                new PriorityQueue<>((a, b) -> Long.compare(a.dist, b.dist));

        dist[0] = 0;
        ways[0] = 1;

        pq.offer(new Pair(0, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            long currDist = curr.dist;

            if (currDist > dist[node])
                continue;

            for (Pair p : adj.get(node)) {

                int adjNode = p.node;
                long wt = p.dist;

                if (currDist + wt < dist[adjNode]) {

                    dist[adjNode] = currDist + wt;
                    ways[adjNode] = ways[node];

                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
                else if (currDist + wt == dist[adjNode]) {

                    ways[adjNode] = (ways[adjNode] + ways[node]) % MOD;
                }
            }
        }

        return (int) ways[n - 1];
    }
}