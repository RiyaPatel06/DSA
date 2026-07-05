class Solution {
    public String mergeAlternately(String word1, String word2) {
        char[] arr1=word1.toCharArray();
        char[] arr2=word2.toCharArray();
        int m=arr1.length;
        int n=arr2.length;
        char merged[]=new char[m+n];
        int i=0,j=0,k=0;
        while(i<m && j<n){
            merged[k++]=arr1[i++];
            merged[k++]=arr2[j++];
        }
        while(i<m){
            merged[k++]=arr1[i++];
        }
        while(j<n){
            merged[k++]=arr2[j++];
        }
        return new String(merged);

        
    }

}