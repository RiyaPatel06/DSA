class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        backtrack(0,nums,new ArrayList<>(),res);
        return res;
        
    }
    private void backtrack(int idx,int[] nums,List<Integer> curr,List<List<Integer>> res){
        //store current subset
        res.add(new ArrayList<>(curr));
        for(int i=idx;i<nums.length;i++){
            //choose
            curr.add(nums[i]);
            //explore
            backtrack(i+1,nums,curr,res);
            //backtrack
            curr.remove(curr.size()-1);
        }
    }
}