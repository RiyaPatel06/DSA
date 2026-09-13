class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int[] dp=new int[n];
        dp[0]=nums[0];
        int maxSum=dp[0];
        for(int i=1;i<n;i++){
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
            maxSum=Math.max(maxSum,dp[i]);
        }
        return maxSum;
    }
}