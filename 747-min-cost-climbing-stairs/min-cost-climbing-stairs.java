class Solution {
    static int[] dp;
    static int minCost(int[] cost,int idx){
        if(idx>=cost.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        return
         dp[idx]=cost[idx]+Math.min(minCost(cost,idx+1),minCost(cost,idx+2));
    }
    static int minCostClimbingStairs(int[] cost) {
        dp=new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(minCost(cost,0),minCost(cost,1));
        
    }
    
};