class Solution {

    class DSU {
        int[] parent, size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] == x)
                return x;
            return parent[x] = find(parent[x]);
        }

        boolean union(int u, int v) {
            int pu = find(u);
            int pv = find(v);

            if (pu == pv)
                return false;      // Already connected -> extra cable

            if (size[pu] < size[pv]) {
                parent[pu] = pv;
                size[pv] += size[pu];
            } else {
                parent[pv] = pu;
                size[pu] += size[pv];
            }

            return true;
        }
    }

    public int makeConnected(int n, int[][] connections) {

        DSU dsu = new DSU(n);
        int extra = 0;

        for (int[] edge : connections) {
            if (!dsu.union(edge[0], edge[1])) {
                extra++;
            }
        }

        int components = 0;

        for (int i = 0; i < n; i++) {
            if (dsu.find(i) == i)
                components++;
        }

        int required = components - 1;

        if (extra >= required)
            return required;

        return -1;
    }
}