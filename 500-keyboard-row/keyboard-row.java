class Solution {
    public String[] findWords(String[] words) {
        String row1="qwertyuiop";
        String row2="asdfghjkl";
        String row3="zxcvbnm";
        List<String> list=new LinkedList<>();
        for(String word:words){
            int[] rows=new int[3];
            for(char ch:word.toLowerCase().toCharArray()){
             if(row1.indexOf(ch)!=-1)
               rows[0]=1;
             else if(row2.indexOf(ch)!=-1)
               rows[1]=1;
             else if(row3.indexOf(ch)!=-1)
               rows[2]=1;
            }
            int sum=rows[0]+rows[1]+rows[2];
            if(sum==1)
              list.add(word);

        }
        String[] arr=new String[list.size()];
        int i=0;
        for(String word:list)
           arr[i++]=word;
        return arr;
        
    }
    
}