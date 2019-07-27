package jzOffer.chap4;


import java.util.LinkedList;
import java.util.Queue;

/**
 * ��ʵ��һ�������������ж�һ�Ŷ������ǲ��ǶԳƵġ�
 * ע�⣬���һ��������ͬ�˶������ľ�����ͬ���ģ�������Ϊ�ԳƵġ�
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
     * �ݹ�ⷨ
     * �������£��ݹ麯��������������һ��������ң�һ�����Һ���
     * �ж��Ƿ���ȣ�1��ֵ��ȣ�2����Ϊ�գ���һ���򲻶Գ�
     * ֻҪ�в���ȵģ��϶����Գ�
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot)
    {
       if (pRoot == null) return true;
       return isSymmetricalRecur(pRoot.left,pRoot.right);
    }
    private boolean isSymmetricalRecur(TreeNode root1,TreeNode root2){
        //һֱ��ȣ���һֱ��Ҷ�ڵ�ͬΪ�գ���Գ�
        if (root1 == null && root2 == null) return true;
        //��һ��Ϊ�վͲ��Գ�
        if (root1 == null || root2 == null) return false;
        //�ų�����ȵ����������ȿ϶����Գƣ���ǰ����
        if (root1.val != root2.val){
            return false;
        }

        return isSymmetricalRecur(root1.left,root2.right) && isSymmetricalRecur(root1.right,root2.left);

    }
    }

    /**
     * �ǵݹ�д��
     * ���б�֤
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
        //ѭ���ڵ㣬��֤��������������ٻ���
        while (!queueA.isEmpty() && !queueB.isEmpty()){
            leftNode = queueA.poll();
            rightNode = queueB.poll();

            //����Ҷ�ڵ㣬������ѭ��
            if (leftNode == null && rightNode == null) continue;
            if (leftNode == null || rightNode == null) return false;
            if (leftNode.val != rightNode.val) return false;

            //�����ԳƵļ���
            queueA.offer(leftNode.left);
            queueB.offer(rightNode.right);
            queueA.offer(leftNode.right);
            queueB.offer(rightNode.left);
        }
        return true;
    }
}
