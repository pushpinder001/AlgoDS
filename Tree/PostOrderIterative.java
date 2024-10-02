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
    private static class TreeNodeState {
        TreeNode node;

        boolean isVisited;

        public TreeNodeState(TreeNode node, boolean isVisited) {
            this.node = node;
            this.isVisited = isVisited;
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        Deque<TreeNodeState> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        stack.offerLast(new TreeNodeState(root, false));

        while(!stack.isEmpty()) {
            TreeNodeState curState = stack.pollLast();
            if(curState.isVisited) {
                result.add(curState.node.val);
            } else {
                curState.isVisited = true;
                stack.offerLast(curState);
                if(curState.node.right != null) {
                    stack.offerLast(new TreeNodeState(curState.node.right, false));
                }
                if(curState.node.left != null) {
                    stack.offerLast(new TreeNodeState(curState.node.left, false));
                }
            }
        }

        return result;
    }
}
