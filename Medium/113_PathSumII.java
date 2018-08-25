/*
Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

Note: A leaf is a node with no children.

Example:

Given the below binary tree and sum = 22,

      5
     / \
    4   8
   /   / \
  11  13  4
 /  \    / \
7    2  5   1
Return:

[
   [5,4,11,2],
   [5,8,4,5]
]
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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        dfs(root, sum, new ArrayList<Integer>(), res);
        return res;
    }
    
    private void dfs(TreeNode node, int sum, ArrayList<Integer> tmp, List<List<Integer>> res) {
        if (node == null) {
            return;
        }
        sum -= node.val;
        tmp.add(node.val);
        if (node.left == null && node.right == null) {
            if (sum == 0) {
                res.add(new ArrayList<Integer>(tmp));
            }
        }
        dfs(node.left, sum, tmp, res);
        dfs(node.right, sum, tmp, res);
        tmp.remove(tmp.size() - 1);
    }
}