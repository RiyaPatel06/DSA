class Solution {
    public boolean isThree(int n) {
        int divs=2;
        for (int i=2;i<n-1;i++){
            if(n%i==0){
                divs++;
            }
        }
        if(divs==3) return true;
        else return false;
    }
}