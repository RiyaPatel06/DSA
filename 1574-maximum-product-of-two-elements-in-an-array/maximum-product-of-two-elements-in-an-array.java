class Solution {
    public int maxProduct(int[] nums) {
        int max=-1;
        int secMax=-1;
        for(int i=0;i<nums.length;i++){
            if(nums[i]>=max){
                secMax=max;
                max=nums[i];
                
            }
            else if(nums[i]<max && nums[i]>secMax){
                secMax=nums[i];
            }
        }
        return (max-1)*(secMax-1);
    }
}