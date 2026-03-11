class Solution {
    public boolean canVisitAllRooms(List<List<Integer>>adj){
        int n=adj.size();
        boolean[] visited=new boolean[n];
        visited[0]=true;
        dfs(0,adj,visited);
        for(boolean ele: visited){
            if(ele==false) return false;
        }
        return true;
    }
    private void dfs(int start,List<List<Integer>> adj,boolean[] visited) {
        visited[start]=true;
        for(int ele:adj.get(start)){
            if(!visited[ele]) dfs(ele,adj,visited);
        }
        
        
    }  
    
}