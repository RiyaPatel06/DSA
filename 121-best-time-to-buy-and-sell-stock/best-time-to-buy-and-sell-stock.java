class Solution {
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int j=prices[0];
        int profit=0;
        for(int i=1;i<n;i++){
            if(prices[i]<j){
                j=prices[i];
            }
            else{
                int curProfit=prices[i]-j;
                profit=Math.max(curProfit,profit);
            }
        }
        return profit;
        
        
    }
}