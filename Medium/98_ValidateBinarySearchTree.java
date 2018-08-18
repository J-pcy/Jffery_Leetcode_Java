/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
Example 1:

Input:
    2
   / \
  1   3
Output: true
Example 2:

    5
   / \
  1   4
     / \
    3   6
Output: false
Explanation: The input is: [5,1,4,null,null,3,6]. The root node's value
             is 5 but its right child's value is 4.
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
/*
class resultType {
    boolean isBST;
    long maxValue, minValue;
    resultType(boolean isBST, long maxValue, long minValue) {
        this.isBST = isBST;
        this.maxValue = maxValue;
        this.minValue = minValue;
    }
}*/
class Solution {
    private long lastVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (root.val <= lastVal) {
            return false;
        }
        lastVal = root.val;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }
/*    public boolean isValidBST(TreeNode root) {
        return divConq(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean divConq(TreeNode node, long min, long max) {
        if (node == null) {
            return true;
        }
        if (node.val <= min || node.val >= max) {
            return false;
        }
        return divConq(node.left, min, node.val) && divConq(node.right, node.val, max);
    }*/
/*    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        TreeNode lastNode = null;
        while (!stack.isEmpty()) {
            TreeNode node = stack.peek();
            if (lastNode != null && lastNode.val >= node.val) {
                return false;
            }
            lastNode = node;
            if (node.right == null) {
                node = stack.pop();
                while(!stack.isEmpty() && stack.peek().right == node) {
                    node = stack.pop();
                }
            } else {
                node = node.right;
                while (node != null) {
                    stack.push(node);
                    node = node.left;
                }
            }
        }
        return true;
    }*/
/*    public boolean isValidBST(TreeNode root) {
        resultType res = isValid(root);
        return res.isBST;
    }
    private resultType isValid(TreeNode node) {
        if (node == null) {
            return new resultType(true, Long.MIN_VALUE, Long.MAX_VALUE);
        }
        resultType left = isValid(node.left);
        resultType right = isValid(node.right);
        if (!left.isBST || !right.isBST) {
            return new resultType(false, 0, 0);
        }
        if (left.maxValue >= node.val || right.minValue <= node.val) {
            return new resultType(false, 0, 0);
        }
        return new resultType(true, Math.max(node.val, right.maxValue), Math.min(node.val, left.minValue));
    }*/
}