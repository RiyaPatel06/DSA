class Solution {
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        if(m!=n) return false;
        char[] freq=new char[26];
        for(int i=0;i<m;i++){
            freq[t.charAt(i)-'a']++;
        }
        for(int i=0;i<n;i++){
            freq[s.charAt(i)-'a']--;
        }
        for(int i=0;i<freq.length;i++){
            if(freq[i]!=0){
                return false;
            }
        }
        return true;
        
       
    }
    
}