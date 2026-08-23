class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        // 1. Create adjacency list
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        // 2. Build graph
        for (int[] prerequisite : prerequisites) {

            int course = prerequisite[0];
            int pre = prerequisite[1];

            adj.get(pre).add(course);
        }

        // 3. Calculate indegree
        int[] indegree = new int[numCourses];

        for (int u = 0; u < numCourses; u++) {
            for (int v : adj.get(u)) {
                indegree[v]++;
            }
        }

        // 4. Put indegree 0 nodes into queue
        Queue<Integer> q = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }

        // 5. BFS
        int[] ans = new int[numCourses];
        int index = 0;

        while (!q.isEmpty()) {

            int node = q.remove();

            ans[index++] = node;

            for (int neighbor : adj.get(node)) {

                indegree[neighbor]--;

                if (indegree[neighbor] == 0) {
                    q.add(neighbor);
                }
            }
        }

        // 6. Cycle detection
        if (index != numCourses) {
            return new int[0];
        }

        return ans;
    }
}