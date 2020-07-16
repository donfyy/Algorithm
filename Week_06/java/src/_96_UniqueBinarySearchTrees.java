/**
 * 第一遍：2020/07/15周三 ✅
 * 第二遍：2020/07/15周三
 * 第三遍：2020/07/08周四
 * 第四遍：2020/07/13周一
 * 第三遍：2020/06/29周一
 * 第四遍：2020/07/05周日
 */
class _96_UniqueBinarySearchTrees {
    public int numTrees(int n) {
        //G(n)长度为n的序列能够构成的不同二叉搜索树的个数
        //F(i, n)以i为根，序列长度为n的不同二叉搜索树的个数
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                G[i] += G[j - 1] * G[i - j];
            }
        }
        return G[n];
    }
}