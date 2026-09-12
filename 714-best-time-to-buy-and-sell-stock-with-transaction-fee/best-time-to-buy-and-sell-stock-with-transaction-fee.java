class Solution {
    public int maxProfit(int[] prices, int fee) {

        int hold = -prices[0];
        int cash = 0;

        for (int i = 1; i < prices.length; i++) {

            int oldCash = cash;

            // Sell
            cash = Math.max(cash, hold + prices[i] - fee);

            // Buy
            hold = Math.max(hold, oldCash - prices[i]);
        }

        return cash;
    }
}