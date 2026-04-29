class Solution {
    public int firstMissingPositive(int[] nums) {
        int n=nums.length;
        Set<Integer> set=new HashSet<>();
        for(int ele:nums){
            set.add(ele);
        }
        for(int num=1;num<=n+1;num++){
            if(!set.contains(num)) return num;
        }
        return 456364;
    }
}