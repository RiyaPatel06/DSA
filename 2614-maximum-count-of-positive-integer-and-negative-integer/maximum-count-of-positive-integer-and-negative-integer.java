class Solution {
    public int maximumCount(int[] nums) {
        int n = nums.length;
        int l = 0;
        int h = n - 1;
        int firstPosIdx = n;
        int neg = n;

        while(l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] >= 0) {
                neg = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }

        l = 0;
        h = n - 1;
        while(l <= h) {
            int mid = l + (h - l) / 2;
            if (nums[mid] > 0) {
                firstPosIdx = mid;
                h = mid - 1;
            }
            else l = mid + 1;
        }
        int pos = n - firstPosIdx;

        return Math.max(pos , neg);
        
       
    }
}