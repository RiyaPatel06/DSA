class Solution {
    public boolean isPalindrome(String s) {
        s=s.toLowerCase();
        char[] ch=s.toCharArray();
        int i=0,j=ch.length-1;
        while(i<j){
            if(ch[i]==ch[j]){
                char temp=ch[i];
                ch[i]=ch[j];
                ch[j]=temp;
                i++;
                j--;
            }else if(!(ch[i]>='a' && ch[i]<='z' || ch[i]>='0' && ch[i]<='9')) i++;
            else if(!(ch[j]>='a' && ch[j]<='z' || ch[j]>='0' && ch[j]<='9')) j--;
            else return false;
        }
        return true;

        
    }
}