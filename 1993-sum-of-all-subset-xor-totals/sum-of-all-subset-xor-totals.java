class Solution {
    public int subsetXORSum(int[] nums) {
        return findXorTotal(nums,0,0);
        
    }
    public int findXorTotal(int[] nums,int idx,int xor){
        if(idx==nums.length) return xor;
        int pick=findXorTotal(nums,idx+1,xor^nums[idx]);
        int nopick=findXorTotal(nums,idx+1,xor);
        return pick+nopick;
    }
}