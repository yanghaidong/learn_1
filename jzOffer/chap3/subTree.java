package jzOffer.chap3;

/**
 * �������ö�����A��B���ж�B�ǲ���A���ӽṹ��
 * ps������Լ��������������һ�������ӽṹ
 */
public class subTree {
    class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;

        }
    }

    /**
     * �ݹ鷽������һ���ݹ���������ҵ���Ƚڵ�
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //��־���ڼ����Ƿ��ҵ�����
        boolean result = false;
        if (root1 != null && root2 !=null){
            if (root1.val == root2.val){
                result = isSubTree(root1,root2);
            }
            if (!result){
                result = HasSubtree(root1.left,root2);
            }
            if (!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    /**
     * �ڶ����ݹ��ж����������Ƿ���ͬ
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        //�ݹ�ʱ�ӽṹ��Ҷ�ڵ㣬˵����ڵ�����ҽڵ�һ��
        if (root2 == null){
            return true;
        }
        //���Ƚ����ˣ�˵���϶�������
        if (root1 == null){
            return false;
        }
        //����ȣ���϶�������
        if (root1.val != root2.val){
            return false;
        }
        //���Ҷ�������
        return isSubTree(root1.left,root2.left) && isSubTree(root1.right ,root2.right);
    }


    /**
     *
     * ������д��,���ö�·����
     * &&��||������һ����·���Լ��������¡�
     *
     * Ҫʹ�����ʽ1��&&�����ʽ2��������Ϊ����Ҫ�󣺱��ʽ1�����ʽ2��Ϊ�棬������ʽ1Ϊ�٣��򲻼�����ʽ2�ˣ���Ϊ��ʱ�Ѿ�ȷ�������ʽ1��&&�����ʽ2��������������Ϊ�棬�����&&����Ķ�·���ԡ�
     *
     * Ҫʹ�����ʽ1��||�����ʽ2��������Ϊ����Ҫ�󣺱��ʽ1�����ʽ2��Ϊ�٣�������ʽ1Ϊ�棬�򲻼�����ʽ2�ˣ���Ϊ��ʱ�Ѿ�ȷ�������ʽ1��||�����ʽ2��������������Ϊ�٣������||����Ķ�·���ԡ�
     */
    public boolean HasSubtree1(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return isSubTree1(root1,root2) || HasSubtree1(root1.left,root2) || HasSubtree1(root1.right,root2);
    }

    private boolean isSubTree1(TreeNode root1, TreeNode root2) {
        /**
         * ������ж��Ƿ������ĺ���isSubtree����жϵ�rootB == NULL ���� ���жϵ�RootA == NULL,����Ⱥ�˳��һ������ǲ�ͬ��
         * ����ͬʱ�������գ��������ӽṹ�����
         * ˳���ܱ�
         */
        if (root2 == null)  return true;
        if (root1 == null)  return false;

       if (root1.val == root2.val){
           return isSubTree1(root1.left,root2.left) && isSubTree1(root1.right,root2.right);
       }else {
           return false;
       }
    }

}
