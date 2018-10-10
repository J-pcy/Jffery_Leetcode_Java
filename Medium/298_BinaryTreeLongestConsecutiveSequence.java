/*
Given a binary tree, find the length of the longest consecutive sequence path.

The path refers to any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The longest consecutive path need to be from parent to child (cannot be the reverse).

Example 1:

Input:

   1
    \
     3
    / \
   2   4
        \
         5

Output: 3

Explanation: Longest consecutive sequence path is 3-4-5, so return 3.
Example 2:

Input:

   2
    \
     3
    / 
   2    
  / 
 1

Output: 2 

Explanation: Longest consecutive sequence path is 2-3, not 3-2-1, so return 2.
*/

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
/*
    private int res = 0;
    public int longestConsecutive(TreeNode root) {
        if (root == null) return 0;
        dfs(root, root.val, 0);
        return res;
    }
    private void dfs(TreeNode node, int val, int tmp) {
        if (node == null) return;
        if (node.val == val + 1) ++tmp;
        else tmp = 1;
        res = Math.max(res, tmp);
        dfs(node.left, node.val, tmp);
        dfs(node.right, node.val, tmp);
    }*/
    private int max = 0;
    public int longestConsecutive(TreeNode root) {
        divAndCon(root);
        return max;
    }
    private int divAndCon(TreeNode node) {
        if (node == null) return 0;
        int left = divAndCon(node.left);
        int right = divAndCon(node.right);
        int leftMax = (node.left != null && node.left.val == node.val + 1) ? left + 1 : 1;
        int rightMax = (node.right != null && node.right.val == node.val + 1) ? right + 1 : 1;
        max = Math.max(max, Math.max(leftMax, rightMax));
        return Math.max(leftMax, rightMax);
    }
}