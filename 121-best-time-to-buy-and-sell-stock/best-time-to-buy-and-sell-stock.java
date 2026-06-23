class Solution {
    public int maxProfit(int[] prices) {
        int j=prices[0];
        int profit=0;
        for(int i=1;i<prices.length;i++){
            if(prices[i]<j){
                j=prices[i];
            }    
            else{
                int curr_profit=prices[i]-j;
                profit=Math.max(curr_profit,profit);
            }    

        }
        return profit;
        
    }
}