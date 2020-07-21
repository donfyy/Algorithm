import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
/**
 * 第一遍：2020/07/20周二 ✅
 * 第二遍：2020/07/21周二
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 今不知道回事，居然有理解障碍，卧槽
 * 明天要复习下。
 * todo dp解法
 */
class _95_UniqueBinarySearchTreesII {
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) return Collections.emptyList();
        return generateTrees(1, n);
    }

    public List<TreeNode> generateTrees(int start, int end) {
        List<TreeNode> trees = new LinkedList<>();
        if (start > end) {
            trees.add(null);
            return trees;
        }
        for (int i = start; i <= end; i++) {
            List<TreeNode> leftTrees = generateTrees(start, i - 1);
            List<TreeNode> rightTrees = generateTrees(i + 1, end);
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    trees.add(new TreeNode(i, left, right));
                }
            }
        }
        return trees;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}