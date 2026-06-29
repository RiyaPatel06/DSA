class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int l=0,h=0,max=0,ans=0;

        for(int n:weights){
            l=Math.max(l,n);
            h+=n;
        }

        while(l<=h){
            int mid=l+(h-l)/2;
            int minDaysNeed=1;
            int load=0;

            for(int num:weights){
                if(num+load>mid){
                    load=num;
                    minDaysNeed++;
                }else{
                    load+=num;
                }
            }
            if(minDaysNeed<=days){
                ans=mid;
                h=mid-1;
            }else{
                l=mid+1;
            }
        }
        return ans;
    }
}