package jzOffer.chap4;


import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * �����У��������´�ӡ����������ÿ���ڵ㣬ͬ��ڵ�������Ҵ�ӡ�����������
 */
public class BinaryTreeLevelOrder {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * ��©�˷ǿ��������ж�
     * @param root
     * @return
     */
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()){
            TreeNode treeNode = queue.poll();
            result.add(treeNode.val);
            if (treeNode.left != null) queue.offer(treeNode.left);
            if (treeNode.right != null) queue.offer(treeNode.right);
        }

        return result;
    }
}
