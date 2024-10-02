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
    /*
    Iterative
    Root Left Right
    */
    public List<Integer> preorderTraversal(TreeNode root) {
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();

        if(root == null) {
            return result;
        }
        stack.offerLast(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pollLast();
            result.add(node.val);

            if(node.right != null) {
                stack.offerLast(node.right);
            }

            if(node.left != null) {
                stack.offerLast(node.left);
            }
        }

        return result;
    }
}
