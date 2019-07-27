package jzOffer.chap6;

import java.util.LinkedList;

/**
 * ����һ�ö����������������ȡ�
 * �Ӹ���㵽Ҷ������ξ����Ľ�㣨������Ҷ��㣩�γ�����һ��·�����·���ĳ���Ϊ������ȡ�
 */
public class DepthOfTree {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * �ݹ�汾
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
      if (root == null) return 0;
      //ÿ����һ�εݹ飬�����ǰ�ڵ㲻Ϊ�գ��򷵻�ֵÿ�μ�1��ͳ�Ƴ���ȴ�С
      int left = TreeDepth(root.left);
      int right = TreeDepth(root.right);

//      return Math.max(left,right) + 1;
      return left>right ? left+1 : right+1;

    }

    /**
     * �ǵݹ�汾����α���
     * @param root
     * @return
     */
    public int TreeDepth1(TreeNode root){
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            //����ͬ��ڵ㣬�����һ��ڵ�
            for (int i=0;i<queue.size();i++){
                TreeNode t = queue.poll();
                if (t.left != null) queue.offer(t.left);
                if (t.right != null) queue.offer(t.right);
             }
             depth++;
        }
     return depth;
    }
}
