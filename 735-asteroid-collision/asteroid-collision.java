class Solution {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();
        for(int i=0;i<asteroids.length;i++){
            //if stack is empty or a positive value arrives then perform blind insertion
            if(st.isEmpty() || asteroids[i]>0){
                st.push(asteroids[i]);
            }
            else{
                while(!st.isEmpty()){
                    int top=st.peek();
                    if(top<0){
                        st.push(asteroids[i]);
                        break;
                    }
                    int modVal=Math.abs(asteroids[i]);
                    if(modVal==top){
                        st.pop();
                        break;
                    }else if(modVal<top){
                        break;
                    }else{
                        st.pop();
                        if(st.isEmpty()){
                            st.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }
        int len=st.size();
        int ansArr[]=new int[len];
        for(int i=len-1;i>=0;i--){
            ansArr[i]=st.pop();
        }
        return ansArr;
        

            
    }
}