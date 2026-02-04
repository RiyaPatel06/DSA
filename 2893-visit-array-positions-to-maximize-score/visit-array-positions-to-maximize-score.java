class Solution {
    public long maxScore(int[] nums, int x) {
        long oddScore = nums[0], evenScore = nums[0], score = nums[0];
        if (nums[0] % 2 == 0) oddScore -= x;
        else evenScore -= x;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                evenScore = Math.max(evenScore + nums[i], oddScore + nums[i] - x);
                score = Math.max(score, evenScore);
            } else {
                oddScore = Math.max(oddScore + nums[i], evenScore + nums[i] - x);
                score = Math.max(score, oddScore);
            }
        }
        return score;
    }
}