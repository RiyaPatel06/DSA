class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> st=new Stack<>();
        for(String token:tokens){
            if(token.equals("+")){
                int nums2=st.pop();
                int nums1=st.pop();
                st.push(nums1+nums2);
            }
            else if(token.equals("-")){
                int nums2=st.pop();
                int nums1=st.pop();
                st.push(nums1-nums2);
            }
            else if(token.equals("*")){
                int nums2=st.pop();
                int nums1=st.pop();
                st.push(nums1*nums2);
            }
            else if(token.equals("/")){
                int nums2=st.pop();
                int nums1=st.pop();
                st.push(nums1/nums2);
            }else{
                st.push(Integer.parseInt(token));
            }

        }
        return st.pop();
        
    }
}