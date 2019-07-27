package jzOffer.chap4;


import java.util.Stack;

/**
 * ����һ�ö��������������ö���������ת����һ�������˫������Ҫ���ܴ����κ��µĽ�㣬ֻ�ܵ������н��ָ���ָ��
 */
public class BSTTransDoubleLinkList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * ����˼·��
     * 1.�������������˫��������������ͷ�ڵ㡣
     * 2.��λ��������˫�������һ���ڵ㡣
     * 3.�������������Ϊ�յĻ�������ǰroot׷�ӵ�����������
     * 4.�������������˫��������������ͷ�ڵ㡣
     * 5.�������������Ϊ�յĻ�����������׷�ӵ�root�ڵ�֮��
     * 6.���������������Ƿ�Ϊ��ȷ�����صĽڵ㡣
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
       if (pRootOfTree == null) return null;
       if (pRootOfTree.right == null && pRootOfTree.left == null){
           return pRootOfTree;
       }
       //�����������˳�򣬲����������ͷ���
       TreeNode left = Convert(pRootOfTree.left);
       TreeNode p = left;

       //��λ��������˫�������һ���ڵ�
       while (p != null && p.right != null){
           p = p.right;
       }

       //�������������Ϊ�գ�����ӵ�ĩβ
        if (left != null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        //�����������ڵ㣬�������γ������ͷ���
        TreeNode right = Convert(pRootOfTree.right);

        //�����������Ϊ�գ�����ӵ�ͷ��
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        return left != null ? left : pRootOfTree;
    }

    /**
     * �ݹ�ĸĽ�������һ��ȫ�ֱ�����¼�����������һ���ڵ�
     * @param pRootOfTree
     * @return
     */
    //��¼������������һ���ڵ㣬�ս��ֻ����Ϊֻ���������ķ�Ҷ�ڵ���Ҷ�ڵ�
            //���ܷ��ڵݹ麯����
    protected TreeNode leftLast = null;
    public TreeNode convert(TreeNode pRootOfTree){

         if (pRootOfTree == null) return null;
         if (pRootOfTree.left == null && pRootOfTree.right == null){
             //���һ���ڵ����Ϊ���Ҳ��Ҷ�ڵ�
             leftLast = pRootOfTree;
             return pRootOfTree;
         }

         TreeNode left = convert(pRootOfTree.left);
         if (left != null){
             leftLast.right = pRootOfTree;
             pRootOfTree.left = leftLast;
         }
         // �����ڵ�ֻ��������ʱ����ø��ڵ�Ϊ���һ���ڵ�
         leftLast = pRootOfTree;
         TreeNode right = convert(pRootOfTree.right);
         if (right != null){
             right.left = pRootOfTree;
             pRootOfTree.right = right;
         }

         return left != null ? left : pRootOfTree;
    }

    /**
     * �ǵݹ�ⷨ
     * ��ջ������������Ľ��
     * pre��¼��һ���ڵ㣬����ǰ���ָ��
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        //���ܳ���Ҷ�ڵ�Ϊ�յ����
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            //����ǵ�һ�Σ����¼��һ���ڵ㣬��Ϊ����ֵ
            if (isFirst){
                pRootOfTree = p;
                pre = pRootOfTree;
                isFirst = false;

            }else {
                //���򽻻����������ҵĽ���˳��һ��
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            //��ڵ���������ҽڵ�
            p = p.right;
        }
        return pRootOfTree;
    }

}
