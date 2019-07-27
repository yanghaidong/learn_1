package jzOffer.chap4;


import java.util.LinkedList;
import java.util.Queue;

/**
 * 请实现一个函数，用来判断一颗二叉树是不是对称的。
 * 注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 */
public class SymmetricalTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    /**
     * 递归解法
     * 从上往下，递归函数设两个参数，一个先左后右，一个先右后左
     * 判断是否相等（1，值相等，2，都为空）；一空则不对称
     * 只要有不相等的，肯定不对成
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
       if (pRoot == null) return true;
       return isSymmetricalRecur(pRoot.left,pRoot.right);
    }
    private boolean isSymmetricalRecur(TreeNode root1,TreeNode root2){
        //一直相等，则一直到叶节点同为空，则对称
        if (root1 == null && root2 == null) return true;
        //有一个为空就不对称
        if (root1 == null || root2 == null) return false;
        //排除不相等的情况，不相等肯定不对称，提前跳出
        if (root1.val != root2.val){
            return false;
        }

        return isSymmetricalRecur(root1.left,root2.right) && isSymmetricalRecur(root1.right,root2.left);

    }
    }

    /**
     * 非递归写法
     * 队列保证
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
        if (pRoot == null) return true;

        Queue<TreeNode> queueA = new LinkedList<>();
        Queue<TreeNode> queueB = new LinkedList<>();
        queueA.offer(pRoot.left);
        queueB.offer(pRoot.right);

        TreeNode leftNode = null;
        TreeNode rightNode = null;
        //循环节点，保证往深处遍历，还能再回来
        while (!queueA.isEmpty() && !queueB.isEmpty()){
            leftNode = queueA.poll();
            rightNode = queueB.poll();

            //遇到叶节点，则跳出循环
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;

            //两两对称的加入
            queueA.offer(leftNode.left);
            queueB.offer(rightNode.right);
            queueA.offer(leftNode.right);
            queueB.offer(rightNode.left);
        }
        return true;
    }
}
