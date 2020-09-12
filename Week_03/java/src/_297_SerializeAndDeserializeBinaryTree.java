/**
 * 第一遍：2020/09/12周六 ✅
 * 第二遍：2020/09/11周四
 * 第二遍：2020/06/12周二
 * 第三遍：2020/06/18周四
 * 第四遍：2020/07/02周四
 * 虽然磨磨唧唧的做出来了，但是也开心啊
 */
public class _297_SerializeAndDeserializeBinaryTree {

    public static class Codec {
        void dfs(TreeNode node, StringBuilder sb) {
            if (node == null) {
                sb.append("$,");
                return;
            }
            sb.append(node.val).append(",");
            dfs(node.left, sb);
            dfs(node.right, sb);
        }

        TreeNode dfs_(String data, int[] idx) {
            int val = 0;
            int i = idx[0];
            boolean isNotNull = false;
            while (i < data.length() && data.charAt(i) != ',') i++;
            if (idx[0] < data.length() && data.charAt(idx[0]) != '$') {
                val = Integer.parseInt(data.substring(idx[0], i));
                isNotNull = true;
            }
            idx[0] = i + 1;
            TreeNode node = null;
            if (isNotNull) {
                node = new TreeNode(val);
                node.left = dfs_(data, idx);
                node.right = dfs_(data, idx);
            }
            return node;
        }

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);
            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            return dfs_(data, new int[]{0});
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Codec codec = new Codec();
        String serialize = codec.serialize(new TreeNode(-1, new TreeNode(0), new TreeNode(1)));
        System.out.println(serialize);
        TreeNode treeNode = codec.deserialize(serialize);
        System.out.println(codec.serialize(treeNode));
    }
}
