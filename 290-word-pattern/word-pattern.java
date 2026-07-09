class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] words=s.split(" ");
        int len=words.length;
        if(len!=pattern.length()) return false;
        Map<Character,String> map1=new HashMap<>();
        Map<String,Character> map2=new HashMap<>();
        for(int i=0;i<len;i++){
            String word=words[i];
            char cur=pattern.charAt(i);
            if(map1.containsKey(cur) && !map1.get(cur).equals(word)) return false;
            if(map2.containsKey(word) && !map2.get(word).equals(cur)) return false;
            map1.put(cur,word);
            map2.put(word,cur);
        }
        return true;
        
    }    
      
}
        
