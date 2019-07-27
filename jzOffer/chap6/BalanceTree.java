package jzOffer.chap6;

/**
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树
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
     * 递归求每个子树的深度差
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        //递归结束条件，一直遍历到叶节点都没有出来，说明以上子树都满足
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
     * 递归的优化，如果遇到不平衡的返回-1，一直往上，直接终止
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
        //必须满足前面的不是-1.才会继续进行判断
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
