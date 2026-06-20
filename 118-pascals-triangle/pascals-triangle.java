class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> ans=new ArrayList<>();
        for(int i=0;i<n;i++){
            ans.add(new ArrayList<Integer>());
            for(int j=0;j<=i;j++){
                if(j==0 || j==i) ans.get(i).add(1);
                else{
                    int val=ans.get(i-1).get(j)+ans.get(i-1).get(j-1);
                    ans.get(i).add(val);
                }
            }
        }
        return ans;
        
    }
}