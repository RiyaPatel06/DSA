class Solution {

    int[] parent;
    int[] rank;

    int find(int x) {

        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    boolean union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        // Already connected
        if (pu == pv) {
            return false;
        }

        if (rank[pu] < rank[pv]) {
            parent[pu] = pv;
        }
        else if (rank[pu] > rank[pv]) {
            parent[pv] = pu;
        }
        else {
            parent[pv] = pu;
            rank[pu]++;
        }

        return true;
    }

    public int makeConnected(int n, int[][] connections) {

        // Not enough cables
        if (connections.length < n - 1) {
            return -1;
        }

        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }

        int components = n;

        for (int[] connection : connections) {

            int u = connection[0];
            int v = connection[1];

            if (union(u, v)) {
                components--;
            }
        }

        return components - 1;
    }
}