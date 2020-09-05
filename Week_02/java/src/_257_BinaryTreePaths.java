import java.util.ArrayList;
import java.util.List;

/**
 * 第一遍：2020/09/05周五 ✅
 * 第二遍：2020/07/06周一
 * 第三遍：2020/07/08周三
 * 第四遍：2020/07/13周一
 * 第五遍：2020/09/03周四
 */
public class _257_BinaryTreePaths {
    // 时间O(n) 空间O(n)
    static class SolutionDfs {
        StringBuilder path = new StringBuilder();
        List<String> ret = new ArrayList<>();

        public List<String> binaryTreePaths(TreeNode root) {
            if (root == null) return ret;
            dfs(root);
            return ret;
        }

        void dfs(TreeNode root) {
            if (root == null) return;
            int len = path.length();
            if (len != 0) path.append("->");
            path.append(root.val);
            if (root.left == null && root.right == null) ret.add(path.toString());
            dfs(root.left);
            dfs(root.right);
            path.setLength(len);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
