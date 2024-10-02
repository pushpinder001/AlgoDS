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
    public List<Integer> inorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }

        while(root != null) {
            stack.offerLast(root);
            root = root.left;
        }

        while(!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            result.add(node.val);

            TreeNode right = node.right;
            while(right != null) {
                stack.offerLast(right);
                right = right.left;
            }
        }

        return result;
    }
}
