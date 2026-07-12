class Solution {
    static class Pair {

        int node, cost;

        Pair(int node, int cost) {

            this.node = node;

            this.cost = cost;

        }

    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++)

            adj.add(new ArrayList<>());

        for (int[] flight : flights) {

            adj.get(flight[0]).add(new Pair(flight[1], flight[2]));

        }

        Queue<Pair> q = new LinkedList<>();

        q.offer(new Pair(src, 0));

        int[] dist = new int[n];

        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[src] = 0;

        int stops = 0;

        while (!q.isEmpty() && stops <= k) {

            int size = q.size();

            while (size-- > 0) {

                Pair curr = q.poll();

                for (Pair it : adj.get(curr.node)) {

                    int newCost = curr.cost + it.cost;

                    if (newCost < dist[it.node]) {

                        dist[it.node] = newCost;

                        q.offer(new Pair(it.node, newCost));

                    }

                }

            }

            stops++;

        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];

    }
}