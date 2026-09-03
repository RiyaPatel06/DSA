class Solution {

    int[] parent;

    int find(int x) {
        if (parent[x] == x) {
            return x;
        }

        return parent[x] = find(parent[x]);
    }

    boolean union(int u, int v) {

        int pu = find(u);
        int pv = find(v);

        // Already connected → cycle
        if (pu == pv) {
            return false;
        }

        parent[pu] = pv;

        return true;
    }

    public int[] findRedundantConnection(int[][] edges) {

        int n = edges.length;

        parent = new int[n + 1];

        // Initially every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        for (int[] edge : edges) {

            int u = edge[0];
            int v = edge[1];

            // If union fails, this is redundant edge
            if (!union(u, v)) {
                return edge;
            }
        }

        return new int[]{};
    }
}