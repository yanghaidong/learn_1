package jzOffer.chap6;

/**
 * ����һ�ö��������жϸö������Ƿ���ƽ�������
 */

public class BalanceTree {
    private class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * �ݹ���ÿ����������Ȳ�
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        //�ݹ����������һֱ������Ҷ�ڵ㶼û�г�����˵����������������
       if (root == null) return true;
       int left = depth(root.left);
       int right = depth(root.right);
       if (Math.abs(left - right) > 1) return false;
       return IsBalanced_Solution(root.left) && IsBalanced_Solution(root.right);
    }

    private int depth(TreeNode treeNode) {
        if (treeNode == null) return 0;
        int left = depth(treeNode.left);
        int right = depth(treeNode.right);

        return left > right ? left+1 : right+1;
    }

    /**
     * �ݹ���Ż������������ƽ��ķ���-1��һֱ���ϣ�ֱ����ֹ
     * @param root
     * @return
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return betterDepth(root) >= 0;
    }

    private int betterDepth(TreeNode root) {
        if (root == null) return 0;
        int left = betterDepth(root.left);
        int right = betterDepth(root.right);
        //��������ǰ��Ĳ���-1.�Ż���������ж�
        return left >= 0 && right >= 0 && Math.abs(left - right) <=1 ? Math.max(left,right) + 1 : -1;
    }

    public boolean isBalanced1(TreeNode root) {
       return isBalance(root,new int[1]);
    }

    private boolean isBalance(TreeNode root, int[] depth) {
        if (root == null) {
            depth[0] = 0;
            return true;
        }
        boolean left = isBalance(root.left, depth);
        int leftdepth = depth[0];
        boolean right = isBalance(root.right, depth);
        int rightdepth = depth[0];
        depth[0] = Math.max(leftdepth+1,rightdepth+1);
        if (left && right && Math.abs(leftdepth - rightdepth) <= 1){
            return true;
        }
        return false;
    }
}
