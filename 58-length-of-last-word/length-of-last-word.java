class Solution {
    public int lengthOfLastWord(String s) {
        String str=s.trim();
        int length=0;
        for(int j=str.length()-1;j>=0;j--){
            if(str.charAt(j)!=' '){
                length++;
            }else{
                break;

            }
        }
        return length;
        
    }
}