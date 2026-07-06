
class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> mp=new HashMap<>();
        int left = 0;
        int maxLength = 0;
        
        for (int right = 0; right < s.length(); right++) {
            char ch=s.charAt(right);
            if(mp.containsKey(ch)){
                left=Math.max(left,mp.get(ch)+1);
            }
            mp.put(ch,right);
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;       
    }
}