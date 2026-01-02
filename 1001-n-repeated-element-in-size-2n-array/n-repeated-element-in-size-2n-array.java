class Solution {
    public int repeatedNTimes(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for (int i : nums) {
            if (seen.contains(i))
                return i;
            seen.add(i);
        }
        return -1;
    }
}