package jzOffer.chap4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 操作给定的二叉树，将其变换为源二叉树的镜像
 */
public class mirrorTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }
        /**
         * 递归版本，就是栈的思想
         * @param root
         */
        public void Mirror(TreeNode root) {
           //递归的终止条件
           if (root == null) return;

           if (root.left == null && root.right == null) return;

           //递归过程
           TreeNode temp = root.left;
           root.left = root.right;
           root.right = temp;
           //递归起点，依次修改参数为左右子节点
           if (root.left != null) Mirror(root.left);

           if (root.right != null) Mirror(root.right);

        }

    /**
     * 前序循环遍历的解决思路，利用栈保存根节点
     */

    public void Mirror1(TreeNode root) {
        //通过栈来记录前序遍历的根节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        //当根节点不为空时或者栈不为空时，存在根节点时进入循环，两种选择，
        while (root != null || !stack.isEmpty()){
            //循环去找左子树，并记录根节点，交换非叶节点的左右子树
            while (root != null) {
                stack.push(root);
                if (root.left != null || root.right != null) {
                    TreeNode temp = root.left;
                    root.left = root.right;
                    root.right = temp;
                }
                //转向其左节点
                root = root.left;
            }
            //出栈，退出左循环，由下往上，依次转向根节点的右节点
            if (!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }

    }

    /**
     * 层次遍历版本，利用队列保存根节点
     */
    public void Mirror2(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        //入队
        queue.offer(root);
        while (!queue.isEmpty()){
            //出队
            TreeNode node = queue.poll();
            //左右存在不为空的则交换
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            //左右节点先入队保存
            if (node.left != null) queue.offer(node.left);

            if (node.right != null) queue.offer(node.right);

        }
    }
}
