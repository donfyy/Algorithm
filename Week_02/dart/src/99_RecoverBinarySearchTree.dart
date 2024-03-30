import 'dart:collection';

/**
 * Definition for a binary tree node.

 */
class Solution {
  void recoverTree2(TreeNode? root) {
    TreeNode? x, y, pre;

    final stack = Queue<TreeNode>();
    while (root != null || stack.isNotEmpty) {
      while (root != null) {
        stack.addLast(root);
        root = root.left;
      }
      final node = stack.removeLast();
      if (pre != null && pre.val > node.val) {
        y = node;
        if (x == null) {
          x = pre;
        }
      }
      pre = node;
      root = node.right;
    }

    if (x != null && y != null) {
      final t = x.val;
      x.val = y.val;
      y.val = t;
    }
  }

  void recoverTree(TreeNode? root) {
    TreeNode? x, y, pre;
    while (root != null) {
      if (root.left != null) {
        var p = root.left;
        while (p?.right != null && p?.right != root) {
          p = p?.right;
        }
        if (p?.right == null) {
          p?.right = root;
          root = root.left;
        } else {
          if (pre != null && pre.val > root.val) {
            y = root;
            if (x == null) {
              x = pre;
            }
          }
          p?.right = null;
          pre = root;
          root = root.right;
        }
      } else {
        if (pre != null && pre.val > root.val) {
          y = root;
          if (x == null) {
            x = pre;
          }
        }
        pre = root;
        root = root.right;
      }
    }
    if (x != null && y != null) {
      final t = x.val;
      x.val = y.val;
      y.val = t;
    }
  }
}

class TreeNode {
  int val;
  TreeNode? left;
  TreeNode? right;
  TreeNode([this.val = 0, this.left, this.right]);
}
