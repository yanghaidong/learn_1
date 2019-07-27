package jzOffer.chap4;


/***
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 */
public class SerializeBT {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 使用递归
     * 1. 对于序列化：使用前序遍历，递归的将二叉树的值转化为字符，并且在每次二叉树的结点
     * 不为空时，在转化val所得的字符之后添加一个' ， '作为分割。对于空节点则以 '#' 代替。
     * 2. 对于反序列化：按照前序顺序，递归的使用字符串中的字符创建一个二叉树
     */
    //全局变量索引记录字符串位置
    private int index = -1;
    String Serialize(TreeNode root) {
        if (root == null) return "";
        StringBuilder sb = new StringBuilder();
        preOrder(root,sb);
        return sb.toString();
    }

    private void preOrder(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }
        sb.append(node.val).append(",");
        preOrder(node.left,sb);
        preOrder(node.right,sb);

    }

    TreeNode Deserialize(String str) {
        if (str.isEmpty()) return null;
        String[] seq = str.split(",");
        return reConstruct(seq);
    }

    private TreeNode reConstruct(String[] seq) {

        ++index;
        if (seq[index].equals("#") || index >= seq.length) return null;

        TreeNode root = new TreeNode(Integer.parseInt(seq[index]));
        root.left = reConstruct(seq);
        root.right = reConstruct(seq);

        return root;
    }
}
