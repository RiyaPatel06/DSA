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
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Queue<Pair<TreeNode,Integer>>q=new LinkedList<>();
        q.add(new Pair<>(root,0));
        int maxWidth=0;
        while(!q.isEmpty()){
            int levelLength=q.size();
            int levelStart=q.peek().getValue();
            int idx=0;
            for(int i=0;i<levelLength;i++){
                Pair<TreeNode,Integer> pair=q.poll();
                TreeNode node=pair.getKey();
                idx=pair.getValue();
                if(node.left!=null){
                    q.add(new Pair<>(node.left,2*idx));
                }
                if(node.right!=null){
                    q.add(new Pair<>(node.right,2*idx+1));
                }
            }
            maxWidth=Math.max(maxWidth,idx-levelStart+1);
        }
        return maxWidth;
    }
}