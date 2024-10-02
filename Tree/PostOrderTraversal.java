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
    /** 
    //Referred from Tushar's video
    Single Stack Solution
    The issue with post order traversal is 
    we are not sure if we have visited the
    right subtree of node before popping out
    cur top
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        TreeNode cur = root;
        Deque<TreeNode> stack = new ArrayDeque<>();
        List<Integer> result = new ArrayList<>();
        TreeNode prev = null;

        while(cur!=null || !stack.isEmpty()) {
            if(cur != null) {
                stack.offerLast(cur);
                cur = cur.left;
            } else {
                if(stack.peekLast().right != null && prev !=stack.peekLast().right ) {
                    cur = stack.peekLast().right;
                } else {
                    prev = stack.pollLast();
                    result.add(prev.val);
                }
            }
        }

        return result;
    }
}
