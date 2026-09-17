class Solution {
    public int numDecodings(String s) {
        int n = s.length();

        int[] dp = new int[n + 1];

        dp[0] = 1;

        if (s.charAt(0) != '0') {
            dp[1] = 1;
        }

        for (int i = 2; i <= n; i++) {

            // Take one digit
            int one = s.charAt(i - 1) - '0';

            if (one >= 1 && one <= 9) {
                dp[i] += dp[i - 1];
            }

            // Take two digits
            int two = Integer.parseInt(s.substring(i - 2, i));

            if (two >= 10 && two <= 26) {
                dp[i] += dp[i - 2];
            }
        }

        return dp[n];
    }
}