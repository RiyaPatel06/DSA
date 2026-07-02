class Solution {
    public String reverseOnlyLetters(String s) {
        char[] ch=s.toCharArray();
        int n=ch.length;
        int i=0,j=n-1;
        while(i<j){
            if(!Character.isLetter(ch[i]) ){
                i++;
            }else if(!Character.isLetter(ch[j])){
                j--;
            }else{
                char temp=ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
            }
            
        }
        return new String(ch);
        
    }
}