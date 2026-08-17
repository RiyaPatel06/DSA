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
    public int rob(TreeNode root) {
        int[] options=travel(root);
        return Math.max(options[0],options[1]);
        
    }
    private int[] travel(TreeNode root){
        //basecase just return {0,0} as u cannot rob anything
        if(root==null) return new int[2];
        int[] left_choices=travel(root.left);
        int[] right_choices=travel(root.right);
        int[] options=new int[2];
        //store value if looted in [0];
        options[0]=root.val+left_choices[1]+right_choices[1];

        //store val if skipped in [1]
        options[1]=Math.max(left_choices[0],left_choices[1])+Math.max(right_choices[0],right_choices[1]);
        return options;

    }
}