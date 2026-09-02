class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {

        // Adjacency list
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        // Build graph
        for (int[] edge : times) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.get(u).add(new int[]{v, wt});
        }

        // Distance array
        int[] dist = new int[n + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);

        // PriorityQueue -> {distance, node}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[0], b[0]));

        dist[k] = 0;

        pq.offer(new int[]{0, k});

        // Dijkstra
        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int distance = curr[0];
            int node = curr[1];

            // Ignore outdated entry
            if (distance > dist[node]) {
                continue;
            }

            for (int[] edge : adj.get(node)) {

                int next = edge[0];
                int weight = edge[1];

                int newDist = distance + weight;

                if (newDist < dist[next]) {

                    dist[next] = newDist;

                    pq.offer(new int[]{
                        newDist,
                        next
                    });
                }
            }
        }

        // Find maximum shortest distance
        int max = 0;

        for (int i = 1; i <= n; i++) {

            if (dist[i] == Integer.MAX_VALUE) {
                return -1;
            }

            max = Math.max(max, dist[i]);
        }

        return max;
    }
}