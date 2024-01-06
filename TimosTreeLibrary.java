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

class TreeLibrary {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base case, when both have null at the end node
        if (p == null && q == null) {
            return true;
        }
        // not equal; return false
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        // Recursively check if the left and right subtrees are identical
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    // Check if a given tree is balanced
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return isBalancedTreeNode(root) != -1;
    }

    public int isBalancedTreeNode(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = isBalancedTreeNode(root.left);
        int right = isBalancedTreeNode(root.right);

        if (left == -1 || right == -1) {
            return -1;
        }

        int diff = Math.abs(left - right);
        if(diff > 1) {
            return -1;
        }
        
        return 1 + Math.max(left, right);
    }
}
