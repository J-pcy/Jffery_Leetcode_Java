/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

For example, given

preorder = [3,9,20,15,7]
inorder = [9,3,15,20,7]
Return the following binary tree:

    3
   / \
  9  20
    /  \
   15   7
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length != inorder.length) {
            return null;
        }
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode build(int[] preorder, int prestart, int preend, int[] inorder, int instart, int inend) {
        if (instart > inend) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[prestart]);
        int pos = findPosition(inorder, instart, inend, root.val);
        root.left = build(preorder, prestart + 1, prestart + pos - instart, inorder, instart, pos - 1);
        root.right = build(preorder, prestart + pos - instart + 1, preend, inorder, pos + 1, inend);
        return root;
    }
    
    private int findPosition(int[] array, int start, int end, int value) {
        for (int i = start; i <= end; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }
}