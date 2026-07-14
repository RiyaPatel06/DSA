class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans=new ArrayList<>();
        backtrack(0,target,candidates,new ArrayList<>(),ans);
        return ans;
    }
    private void backtrack(int idx,int target,int[] candidates,List<Integer>curr,List<List<Integer>>ans){
        if(target==0){
            ans.add(new ArrayList<>(curr));
            return;
        }
        if(target<0 || idx==candidates.length) return;
        //include curr num
        curr.add(candidates[idx]);
        backtrack(idx,target-candidates[idx],candidates,curr,ans);
        //backtrack
        curr.remove(curr.size()-1);
        //exclude curr num
        backtrack(idx+1,target,candidates,curr,ans);
    }
}