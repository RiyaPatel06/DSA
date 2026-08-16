/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    public List<Integer> distanceK(
        TreeNode root,
        TreeNode target,
        int k) {

        // Step 1: Store parent of every node
        Map<TreeNode, TreeNode> parent = new HashMap<>();

        markParents(root, parent);

        // Step 2: BFS from target
        Queue<TreeNode> q = new LinkedList<>();
        Set<TreeNode> visited = new HashSet<>();

        q.offer(target);
        visited.add(target);

        int distance = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            // We reached distance K
            if (distance == k) {
                List<Integer> ans = new ArrayList<>();

                for (TreeNode node : q) {
                    ans.add(node.val);
                }

                return ans;
            }

            for (int i = 0; i < size; i++) {

                TreeNode curr = q.poll();

                // Left
                if (curr.left != null &&
                    !visited.contains(curr.left)) {

                    visited.add(curr.left);
                    q.offer(curr.left);
                }

                // Right
                if (curr.right != null &&
                    !visited.contains(curr.right)) {

                    visited.add(curr.right);
                    q.offer(curr.right);
                }

                // Parent
                TreeNode p = parent.get(curr);

                if (p != null &&
                    !visited.contains(p)) {

                    visited.add(p);
                    q.offer(p);
                }
            }

            distance++;
        }

        return new ArrayList<>();
    }


    private void markParents(
        TreeNode root,
        Map<TreeNode, TreeNode> parent) {

        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while (!q.isEmpty()) {

            TreeNode curr = q.poll();

            if (curr.left != null) {

                parent.put(curr.left, curr);
                q.offer(curr.left);
            }

            if (curr.right != null) {

                parent.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }
}