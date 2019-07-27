package jzOffer.chap4;


/***
 * ��ʵ�������������ֱ��������л��ͷ����л�������
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
     * ʹ�õݹ�
     * 1. �������л���ʹ��ǰ��������ݹ�Ľ���������ֵת��Ϊ�ַ���������ÿ�ζ������Ľ��
     * ��Ϊ��ʱ����ת��val���õ��ַ�֮�����һ��' �� '��Ϊ�ָ���ڿսڵ����� '#' ���档
     * 2. ���ڷ����л�������ǰ��˳�򣬵ݹ��ʹ���ַ����е��ַ�����һ��������
     */
    //ȫ�ֱ���������¼�ַ���λ��
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
