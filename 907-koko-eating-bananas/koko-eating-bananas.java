class Solution {

    private long calculateTotalHours(int[] piles, int speed) {

        long hours = 0;

        for (int bananas : piles) {
            hours += (bananas + speed - 1L) / speed;
        }

        return hours;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int maxPile = Arrays.stream(piles).max().getAsInt();

        int low = 1;
        int high = maxPile;
        int ans = maxPile;

        while (low <= high) {

            int mid = low + (high - low) / 2;

            long hours = calculateTotalHours(piles, mid);

            if (hours <= h) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
}