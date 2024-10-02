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

        TreeNode curNode = root;

        while(curNode != null || !stack.isEmpty()) {
            while(curNode != null) {
                stack.offerLast(curNode);
                curNode = curNode.left;
            }
            TreeNode node = stack.pollLast();
            result.add(node.val);
            curNode = node.right;
        }

        return result;
    }
}
