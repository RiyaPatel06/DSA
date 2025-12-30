import java.util.*;

class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int n = nums.length;
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int k = queries[i][0];
            int trim = queries[i][1];
            Integer[] indices = new Integer[n];
            for (int j = 0; j < n; j++) indices[j] = j;
            Arrays.sort(indices, (a, b) -> {
                String s1 = nums[a].substring(nums[a].length() - trim);
                String s2 = nums[b].substring(nums[b].length() - trim); 
                int cmp = s1.compareTo(s2);
                if (cmp == 0) return a - b; 
                return cmp;
            });
            result[i] = indices[k - 1];
        }
        return result;
    }
}