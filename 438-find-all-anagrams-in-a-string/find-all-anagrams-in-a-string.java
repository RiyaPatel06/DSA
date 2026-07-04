class Solution {
    public List<Integer> findAnagrams(String s, String p) {
    List<Integer> res = new java.util.ArrayList<>();     
    int n=s.length();
    int m=p.length();
    if(n<m) return res;
    int[] pCount = new int[26];
    int[] sCount = new int[26];
    

    // Count frequency of characters in p
    for (char c : p.toCharArray()) {
      pCount[c - 'a']++;
    }

    // Sliding window to count frequency of characters in s
    for (int i = 0; i < n; i++) {
      sCount[s.charAt(i) - 'a']++;

      // Remove the character that is out of the window
      if (i >= m) {
        sCount[s.charAt(i - m) - 'a']--;
      }

      // Compare counts
      if (Arrays.equals(pCount, sCount)) {
        res.add(i - m + 1);
      }
    }

    return res;
  }

    
}