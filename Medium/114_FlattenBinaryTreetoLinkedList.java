/*
Given a binary tree, flatten it to a linked list in-place.

For example, given the following tree:

    1
   / \
  2   5
 / \   \
3   4   6
The flattened tree should look like:

1
 \
  2
   \
    3
     \
      4
       \
        5
         \
          6
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
/*    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            flatten(root.left);
        }
        if (root.right != null) {
            flatten(root.right);
        }
        TreeNode tmp = root.right;
        root.right = root.left;
        root.left = null;
        while (root.right != null) {
            root = root.right;
        }
        root.right = tmp;
    }*/
/*    public void flatten(TreeNode root) {
        divCon(root);
    }
    
    private TreeNode divCon(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode lastLeft = divCon(root.left);
        TreeNode lastRight = divCon(root.right);
        if (lastLeft != null) {
            lastLeft.right = root.right;
            root.right = root.left;
            root.left = null;
        }
        if (lastRight != null) {
            return lastRight;
        }
        if (lastLeft != null) {
            return lastLeft;
        }
        return root;
    }*/
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null) {
            if (cur.left != null) {
                TreeNode tmp = cur.left;
                while (tmp.right != null) {
                    tmp = tmp.right;
                }
                tmp.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}