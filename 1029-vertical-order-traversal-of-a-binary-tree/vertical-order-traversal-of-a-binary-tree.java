/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    class Pair {

        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node,int row,int col){

            this.node=node;
            this.row=row;
            this.col=col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<List<Integer>> ans=new ArrayList<>();

        if(root==null)
            return ans;

        TreeMap<Integer,
                TreeMap<Integer,
                        PriorityQueue<Integer>>> map=new TreeMap<>();

        Queue<Pair> q=new LinkedList<>();

        q.offer(new Pair(root,0,0));

        while(!q.isEmpty()){

            Pair curr=q.poll();

            TreeNode node=curr.node;

            int row=curr.row;

            int col=curr.col;

            map
            .computeIfAbsent(col,k->new TreeMap<>())
            .computeIfAbsent(row,k->new PriorityQueue<>())
            .offer(node.val);

            if(node.left!=null)
                q.offer(new Pair(node.left,row+1,col-1));

            if(node.right!=null)
                q.offer(new Pair(node.right,row+1,col+1));

        }

        for(TreeMap<Integer,PriorityQueue<Integer>> rows:map.values()){

            List<Integer> list=new ArrayList<>();

            for(PriorityQueue<Integer> pq:rows.values()){

                while(!pq.isEmpty()){

                    list.add(pq.poll());

                }

            }

            ans.add(list);

        }

        return ans;
    }
}

