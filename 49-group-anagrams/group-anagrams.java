class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>>mp=new HashMap<>();
        for(String word:strs){
            int count[]=new int[26];
            for(char ch:word.toCharArray()){
                count[ch-'a']++;
            }
            StringBuilder sb=new StringBuilder();
            for(int num:count){
                sb.append('#');
                sb.append(num);

            }
            String key=sb.toString();
            if(!mp.containsKey(key)){
                mp.put(key,new ArrayList<>());
            }
            mp.get(key).add(word);

        }
        return new ArrayList<>(mp.values());
        
        
        
    }
    
}