class Solution {
    
    HashMap<Integer, Integer> dp = new HashMap<>();
    public int getKth(int lo, int hi, int k) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) ->{
            int steps1 = 0, steps2 = 0;
            if(!dp.containsKey(a)){
                dp.put(a, steps(a));
            }
            steps1 = dp.get(a);
            if(!dp.containsKey(b)){
                dp.put(b, steps(b));
            }
            steps2 = dp.get(b);
            
            if(steps1 == steps2){
                return b- a;
            }else{
                return steps2 - steps1;
            }
        });
        
        for(int i = lo ; i <= hi ; i++){
            pq.add(i);
            if(pq.size() > k){
                pq.poll();
            }
        }
        
        return pq.peek();
    }
    
    public int steps(int x){
        int steps = 0;
        
        while(x != 1){
            if(x % 2 == 0){
                x/=2;
            }else{
                x = 3 * x + 1;
            }
            steps++;
        }
        
        return steps;
    }
}