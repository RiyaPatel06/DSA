class Solution {
    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length()) return false;
        Map<Character,Character>hm=new HashMap<>();
       for(int i=0;i<s.length();i++){
        char original=s.charAt(i);
        char replacement=t.charAt(i);
        if(!hm.containsKey(original)){
            if(!hm.containsValue(replacement)){
                hm.put(original,replacement);
            }else{
                return false;
            }
        }else{
            char mappedChar=hm.get(original);
            if(mappedChar!=replacement){
                return false;
            }
        }
        
       }
       return true;
    }
}