class Solution {

    class Pair {
        int node, time;
        Pair(int node, int time) {
            this.node = node;
            this.time = time;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++)
            adj.add(new ArrayList<>());

        for (int[] t : times)
            adj.get(t[0]).add(new Pair(t[1], t[2]));

        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        PriorityQueue<Pair> pq =
            new PriorityQueue<>((a, b) -> a.time - b.time);

        dist[k] = 0;
        pq.offer(new Pair(k, 0));

        while (!pq.isEmpty()) {

            Pair curr = pq.poll();

            int node = curr.node;
            int time = curr.time;

            if (time > dist[node])
                continue;

            for (Pair p : adj.get(node)) {

                int adjNode = p.node;
                int adjTime = p.time;

                if (time + adjTime < dist[adjNode]) {
                    dist[adjNode] = time + adjTime;
                    pq.offer(new Pair(adjNode, dist[adjNode]));
                }
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            if (dist[i] == Integer.MAX_VALUE)
                return -1;
            max = Math.max(max, dist[i]);
        }

        return max;
    }
}