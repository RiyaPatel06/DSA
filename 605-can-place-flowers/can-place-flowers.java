class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) {
         int m=flowerbed.length;
        
         for(int i=0;i<m;i++){
            if(flowerbed[i]==0){
               if((i==0 ||flowerbed[i-1]==0) && (i==m-1 || flowerbed[i+1]==0)){
                   flowerbed[i]=1;
                   n=n-1;
                   
                } 
                
                
            }
            if(n==0) return true;
            
         }  
         return n<=0;
            
        
        
    }
}     
