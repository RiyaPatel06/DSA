class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if(n < m) {
            return res;
        }
        int []freq1 = new int[26];
        int []freq2 = new int[26];
        for(char ch : p.toCharArray()) {
            freq1[ch-'a']++;
        }
        for(int i=0;i<m;i++) {
            freq2[s.charAt(i)-'a']++;
        }
        if(Arrays.equals(freq1,freq2)) {
            res.add(0);
        }
        for(int i=m;i<n;i++) {
            freq2[s.charAt(i)-'a']++;
            freq2[s.charAt(i-m)-'a']--;
            if(Arrays.equals(freq1,freq2)) {
                res.add(i-m+1);
            }
        }
        return res;
    }
}