class Solution {
    public String reverseWords(String s) {
        char[] arr=s.toCharArray();
        int i=0,j=0;
        while(j<arr.length){
            if(arr[j]==' '){
                reverse(arr,i,j-1);
                i=j+1;
            }
            j++;
        }
        reverse(arr,i,j-1);
        return new String(arr);
        
    }
    private void reverse(char[] arr,int i,int j){
        while(i<j){
            char temp=arr[i];
            arr[i++]=arr[j];
            arr[j--]=temp;

        }
        
    }
}