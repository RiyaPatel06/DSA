class Solution {
    public boolean canFinish(int n, int[][] pre) {
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] edge:pre){
            int u=edge[0];
            int v=edge[1];
            adj.get(u).add(v);
        }
        //calculate indegree
        int[] indegree=new int[n];
        for(int u=0;u<n;u++){
            for(int v:adj.get(u)){
                indegree[v]++;
            }
        }
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++){
            if(indegree[i]==0){
                q.add(i);
            }
        }
        List<Integer> ans=new ArrayList<>();
        while(!q.isEmpty()){
            int node=q.remove();
            ans.add(node);
            for(int neigh:adj.get(node)){
                indegree[neigh]--;
                if(indegree[neigh]==0){
                    q.add(neigh);
                }
            }
        }
        if(ans.size()==n) return true;
        else return false;
        

    }

    
}