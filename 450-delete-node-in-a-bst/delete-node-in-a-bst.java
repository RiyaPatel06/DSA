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
    public TreeNode deleteNode(TreeNode root, int target) {
        if(root==null) return root;
        if(target<root.val){
           root.left= deleteNode(root.left,target);
           return root;
        }
        else if(target>root.val){
            root.right=deleteNode(root.right,target);
            return root;
        }else{
            //leaf node
            if(root.left==null && root.right==null) return null;
            if(root.left==null){
                return root.right;
            }
            else if(root.right==null){
                return root.left;
            }else{
                TreeNode min=root.right;
                while(min.left!=null){
                    min=min.left;
                }
                root.val=min.val;
                root.right=deleteNode(root.right,min.val);
                
            }
        }
        return root;
    }
}