class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans=new ArrayList<>();
        if(digits.length()==0) return ans;
        String[] map={
            " "," ","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"
        };
        backtrack(0,digits,map,"",ans);
        return ans;
        
    }
    private void backtrack(int idx,String digits,String[] map,String curr,List<String>ans){
        //base case
        if(idx==digits.length()){
            ans.add(curr);
            return;
        }
        String letters=map[digits.charAt(idx)-'0'];
        for(int i=0;i<letters.length();i++){
            backtrack(idx+1,digits,map,curr+letters.charAt(i),ans);

        }

    }
}