class Solution {

    private boolean canShip(int[] weights, int days, int capacity) {

        int daysUsed = 1;
        int currentLoad = 0;

        for (int weight : weights) {

            if (currentLoad + weight <= capacity) {
                currentLoad += weight;
            } else {
                daysUsed++;
                currentLoad = weight;

                if (daysUsed > days)
                    return false;
            }
        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {

        int low = 0;
        int high = 0;

        for (int weight : weights) {
            low = Math.max(low, weight);
            high += weight;
        }

        int ans = high;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            if (canShip(weights, days, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}