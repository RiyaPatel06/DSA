class Solution {
    public int findCheapestPrice(int n, int[][] flights,
                                 int src, int dst, int k) {

        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];

            adj.get(u).add(new int[]{v, price});
        }

        // dist[node][flightsUsed]
        int[][] dist = new int[n][k + 2];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }

        // {cost, node, flightsUsed}
        PriorityQueue<int[]> pq =
            new PriorityQueue<>((a, b) ->
                Integer.compare(a[0], b[0]));

        dist[src][0] = 0;

        pq.offer(new int[]{0, src, 0});

        while (!pq.isEmpty()) {

            int[] curr = pq.poll();

            int cost = curr[0];
            int node = curr[1];
            int flightsUsed = curr[2];

            if (node == dst) {
                return cost;
            }

            // Maximum flights = k + 1
            if (flightsUsed == k + 1) {
                continue;
            }

            for (int[] edge : adj.get(node)) {

                int next = edge[0];
                int price = edge[1];

                int newCost = cost + price;
                int newFlights = flightsUsed + 1;

                if (newCost < dist[next][newFlights]) {

                    dist[next][newFlights] = newCost;

                    pq.offer(new int[]{
                        newCost,
                        next,
                        newFlights
                    });
                }
            }
        }

        return -1;
    }
}