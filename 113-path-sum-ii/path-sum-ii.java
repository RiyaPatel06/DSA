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

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> path = new ArrayList<>();

        dfs(root, targetSum, path, result);

        return result;
    }

    public void dfs(TreeNode root,
                    int targetSum,
                    List<Integer> path,
                    List<List<Integer>> result) {

        if (root == null)
            return;

        // Add current node
        path.add(root.val);

        // Check leaf
        if (root.left == null && root.right == null) {

            if (targetSum == root.val) {

                result.add(new ArrayList<>(path));
            }

        } else {

            // Explore left
            dfs(root.left,
                targetSum - root.val,
                path,
                result);

            // Explore right
            dfs(root.right,
                targetSum - root.val,
                path,
                result);
        }

        // Backtrack
        path.remove(path.size() - 1);
    }
}