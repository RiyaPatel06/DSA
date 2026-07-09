class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character, Integer> map = new HashMap<>();

        // Count characters of s
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Traverse t
        for(char c : t.toCharArray()){

            if(!map.containsKey(c)){
                return c;
            }

            map.put(c, map.get(c) - 1);

            if(map.get(c) == 0){
                map.remove(c);
            }
        }

        return ' ';        
    }
}