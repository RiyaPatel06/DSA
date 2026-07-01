class Solution {
    public int maxFreqSum(String s) {
        int n=s.length();
        int vowelCount=0;
        int consCount=0;
        int[] freq=new int[26];
        for(int i=0;i<n;i++){
            char ch=s.charAt(i);
            int idx=ch - 'a';
            freq[idx]++;
            if(s.charAt(i)=='a' || s.charAt(i)=='e'|| s.charAt(i)=='i' || s.charAt(i)=='o'|| s.charAt(i)=='u' ){
               vowelCount= Math.max(freq[idx],vowelCount);
            }
            else consCount=Math.max(freq[idx],consCount);
        
        }
        
        return vowelCount+consCount;

        
    }
}