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
/**
Morris Inorder traversal with O(n) time and O(1) space
*/
class Solution {
    private TreeNode findInorderPredecesor(TreeNode root) {
        TreeNode cur = root.left;

        while(cur.right != null && cur.right != root) {
            cur = cur.right;
        }

        return cur;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        TreeNode curNode = root;

        while(curNode != null) {
            /*If there is no left subtree for cur node 
            then just add the node and do inorder traversal 
            of right subtree
            */
            if(curNode.left==null) {
                result.add(curNode.val);
                curNode = curNode.right;
            } else {
                /**
                Find inorder predecesor of curnode
                 */
                TreeNode node = findInorderPredecesor(curNode);
                /**
                If link from inorder predecesor to cur node is not there 
                then add the link and traverse left subtree
                */
                if(node.right == null) {
                    node.right = curNode;
                    curNode = curNode.left;
                } else {
                    /**Now first we have to unlink the precessor
                    visit current node to result and then travese
                    right subtree
                    */
                    node.right = null;
                    result.add(curNode.val);
                    curNode = curNode.right;
                }
            }
        }

        return result;
    }
}
