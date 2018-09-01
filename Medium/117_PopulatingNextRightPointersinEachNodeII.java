/*
Given a binary tree

struct TreeLinkNode {
  TreeLinkNode *left;
  TreeLinkNode *right;
  TreeLinkNode *next;
}
Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
Recursive approach is fine, implicit stack space does not count as extra space for this problem.
Example:

Given the following binary tree,

     1
   /  \
  2    3
 / \    \
4   5    7
After calling your function, the tree should look like:

     1 -> NULL
   /  \
  2 -> 3 -> NULL
 / \    \
4-> 5 -> 7 -> NULL
*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
/*    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode nextNode = root.next;
        while (nextNode != null) {
            if (nextNode.left != null) {
                nextNode = nextNode.left;
                break;
            }
            if (nextNode.right != null) {
                nextNode = nextNode.right;
                break;
            }
            nextNode = nextNode.next;
        }
        if (root.right != null) {
            root.right.next = nextNode;
        }
        if (root.left != null) {
            root.left.next = (root.right != null) ? root.right : nextNode;
        }
        connect(root.right);
        connect(root.left);
    }*/
/*    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeLinkNode> que = new LinkedList<>();
        que.offer(root);
        while (!que.isEmpty()) {
            int size = que.size();
            for (int i = 0; i < size; i++) {
                TreeLinkNode cur = que.poll();
                cur.next = (i < size - 1) ? que.peek() : null;
                if (cur.left != null) {
                    que.offer(cur.left);
                }
                if (cur.right != null) {
                    que.offer(cur.right);
                }
            }
        }
    }*/
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        TreeLinkNode dummy = new TreeLinkNode(0), cur = dummy;
        while (root != null) {
            if (root.left != null) {
                cur.next = root.left;
                cur = cur.next;
            }
            if (root.right != null) {
                cur.next = root.right;
                cur = cur.next;
            }
            root = root.next;
            if (root == null) {
                cur = dummy;
                root = dummy.next;
                dummy.next = null;
            }
        }
    }
}