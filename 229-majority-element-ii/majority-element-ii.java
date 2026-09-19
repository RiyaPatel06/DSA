class Solution {
    public List<Integer> majorityElement(int[] nums) {
       int n = nums.length;
       int cand1=Integer.MIN_VALUE;
       int count1=0;
       int cand2=Integer.MIN_VALUE;
       int count2=0;
        for(int i=0;i<n;i++){
          if(count1==0 && cand2!=nums[i]){
            count1=1;
            cand1=nums[i];
          }else if(count2==0 && cand1!=nums[i]){
            count2=1;
            cand2=nums[i];
          }else if(cand1==nums[i]){
            count1++;
          }else if(cand2==nums[i]){
            count2++;
          }else{
            count1--;
            count2--;
          }
        }  
        count1=0;
        count2=0;
        for(int i=0;i<n;i++){
            if(nums[i]==cand1) count1++;
            if(nums[i]==cand2) count2++;
        } 
        int mini=n/3+1;
        List<Integer> res=new ArrayList<>();
        if(count1 >= mini) res.add(cand1);
        if(count2 >= mini){
            res.add(cand2);
        }
        return res;

    }
}