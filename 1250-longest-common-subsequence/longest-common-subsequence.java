class Solution {
    
    public int longestCommonSubsequence(String a, String b) {
        int m=a.length(),n=b.length();
        int [][] dp=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int p=(i>=1 && j>=1) ? dp[i-1][j-1]:0;
                int q=(j>=1)?dp[i][j-1]:0;
                int r=(i>=1)?dp[i-1][j]:0;
                if(a.charAt(i)==b.charAt(j)) dp[i][j]=1+p;
                else dp[i][j]=Math.max(q,r);
            }
        }
        return dp[m-1][n-1];
    }
}