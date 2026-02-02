class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int[] row : matrix) {
            for (int val : row) {
                pq.offer(val);
            }
        }

        while (--k > 0) {
            pq.poll();
        }

        return pq.poll();
    }
}