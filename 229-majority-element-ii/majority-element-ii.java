class Solution {
    public List<Integer> majorityElement(int[] nums) {
        Integer cand1 = null, cand2 = null;
        int count1 = 0, count2 = 0;

        
        for (int num : nums) {
            if (cand1 != null && num == cand1) {
                count1++;
            } else if (cand2 != null && num == cand2) {
                count2++;
            } else if (count1 == 0) {
                cand1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                cand2 = num;
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }

        
        List<Integer> result = new ArrayList<>();
        int n = nums.length;

        int freq1 = 0, freq2 = 0;
        for (int num : nums) {
            if (cand1 != null && num == cand1) freq1++;
            if (cand2 != null && num == cand2) freq2++;
        }

        if (freq1 > n / 3) result.add(cand1);
        if (cand2 != null && cand2 != cand1 && freq2 > n / 3) result.add(cand2);

        return result;
    }
}
