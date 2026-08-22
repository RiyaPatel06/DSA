class Solution {
    public boolean checkDivisibility(int n) {
        int original=n;
        int sum=0;
        int prod=1;
        while(n>0){
            int a=n%10;
            sum+=a;
            prod*=a;
            n/=10;
        
        }
        int ans=sum+prod;
        return original % ans == 0;
        
    }
}