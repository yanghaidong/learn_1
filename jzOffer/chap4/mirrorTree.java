package jzOffer.chap4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ���������Ķ�����������任ΪԴ�������ľ���
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
         * �ݹ�汾������ջ��˼��
         * @param root
         */
        public void Mirror(TreeNode root) {
           //�ݹ����ֹ����
           if (root == null) return;

           if (root.left == null && root.right == null) return;

           //�ݹ����
           TreeNode temp = root.left;
           root.left = root.right;
           root.right = temp;
           //�ݹ���㣬�����޸Ĳ���Ϊ�����ӽڵ�
           if (root.left != null) Mirror(root.left);

           if (root.right != null) Mirror(root.right);

        }

    /**
     * ǰ��ѭ�������Ľ��˼·������ջ������ڵ�
     */

    public void Mirror1(TreeNode root) {
        //ͨ��ջ����¼ǰ������ĸ��ڵ�
        LinkedList<TreeNode> stack = new LinkedList<>();
        //�����ڵ㲻Ϊ��ʱ����ջ��Ϊ��ʱ�����ڸ��ڵ�ʱ����ѭ��������ѡ��
        while (root != null || !stack.isEmpty()){
            //ѭ��ȥ��������������¼���ڵ㣬������Ҷ�ڵ����������
            while (root != null) {
                stack.push(root);
                if (root.left != null || root.right != null) {
                    TreeNode temp = root.left;
                    root.left = root.right;
                    root.right = temp;
                }
                //ת������ڵ�
                root = root.left;
            }
            //��ջ���˳���ѭ�����������ϣ�����ת����ڵ���ҽڵ�
            if (!stack.isEmpty()){
                root = stack.pop();
                root = root.right;
            }
        }

    }

    /**
     * ��α����汾�����ö��б�����ڵ�
     */
    public void Mirror2(TreeNode root) {
        if (root == null) return;

        Queue<TreeNode> queue = new LinkedList<>();
        //���
        queue.offer(root);
        while (!queue.isEmpty()){
            //����
            TreeNode node = queue.poll();
            //���Ҵ��ڲ�Ϊ�յ��򽻻�
            if (node.left != null || node.right != null) {
                TreeNode temp = node.left;
                node.left = node.right;
                node.right = temp;
            }
            //���ҽڵ�����ӱ���
            if (node.left != null) queue.offer(node.left);

            if (node.right != null) queue.offer(node.right);

        }
    }
}
