class Solution {
    public int count(int x){
        int con = 0;
        while(x != 1){
            if(x%2==0){
                x = x/2;
                con++;
            }
            else{
                x = 3*x+1;
                con++;
            }
        }
        return con;
    }
    public int getKth(int lo, int hi, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        for(int i = lo;i<=hi;i++){
            map.put(i,count(i));
        }
        
        List<Integer> al = new ArrayList<>(map.keySet());
        Collections.sort(al, (a,b) -> {
			
            if(map.get(a) != map.get(b)){
                return map.get(a) - map.get(b);
            }
			
            return a - b;
        });
        
        return al.get(k-1);
    }
}