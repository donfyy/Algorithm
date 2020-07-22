import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * 第一遍：2020/07/20周二 ✅
 * 第二遍：2020/07/21周二 ✅
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 * 今不知道回事，居然有理解障碍，卧槽，可能是太累了吧，早上就没有，而且比较顺利地写出来了dp解法
 * 明天要复习下。
 * 还有一种节省空间的dp解法
 * todo 彻底理解求出长度为1，2。。直到n地所有可能
 * todo 学习从[1,2]推出[1,2,3]的解法
 * 参考：https://leetcode-cn.com/problems/unique-binary-search-trees-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-2-7/
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

    public List<TreeNode> generateTreesDp(int n) {
        // f(i, j) 表示(i, j)生成的二叉搜索树集合 (0, n + 1)
        // f(i, j) = f(i, k) * f(k, j) for k in (i, j)
        //  0 <= i <= n           1 <= j <= n + 1
        // f(0, n + 1)
        // if (j == i + 1)
        if (n < 1) return Collections.emptyList();
        List[][] dp = new List[n + 2][n + 2];
        for (int i = n; i >= 0; i--) {
            for (int j = i + 1; j <= n + 1; j++) {
                LinkedList<TreeNode> list = new LinkedList<>();
                if (j == i + 1) {
                    list.add(null);
                } else {
                    for (int k = i + 1; k < j; k++) {
                        LinkedList<TreeNode> leftTrees = (LinkedList<TreeNode>) dp[i][k];
                        LinkedList<TreeNode> rightTrees = (LinkedList<TreeNode>) dp[k][j];

                        for (TreeNode left : leftTrees) {
                            for (TreeNode right : rightTrees) {
                                list.add(new TreeNode(k, left, right));
                            }
                        }
                    }
                }
                dp[i][j] = list;
            }
        }
        return dp[0][n + 1];
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

    class SolutionByLength {
        //不断地求长度从0到n地所有情况
        public List<TreeNode> generateTrees(int n) {
            if (n < 1) return Collections.emptyList();
            LinkedList<TreeNode>[] dp = new LinkedList[n + 1];
            dp[0] = new LinkedList<TreeNode>();
            dp[0].add(null);
            for (int length = 1; length <= n; length++) {
                LinkedList<TreeNode> list = new LinkedList<>();
                for (int root = 1; root <= length; root++) {
                    for (TreeNode left : dp[root - 1]) {
                        for (TreeNode right : dp[length - root]) {
                            list.add(new TreeNode(root, left, clone(right, root)));
                        }
                    }
                }
                dp[length] = list;
            }
            return dp[n];
        }

        TreeNode clone(TreeNode node, int offset) {
            if (node == null) {
                return null;
            }
            return new TreeNode(node.val + offset, clone(node.left, offset), clone(node.right, offset));
        }
    }
}