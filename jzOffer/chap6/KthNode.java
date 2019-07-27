package jzOffer.chap6;



import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ����һ�Ŷ��������������ҳ�������k�Ľ�㡣
 */
public class KthNode {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * �ǵݹ��������
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k)
    {
       if (pRoot == null || k <= 0) return null;
       //ʹ��ջ�����м�ڵ�
        LinkedList<TreeNode> stack = new LinkedList<>();
        int count = 0;
        while (pRoot != null || !stack.isEmpty()){
            //���ҵ��������µĽڵ�
            while (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (!stack.isEmpty()){
                pRoot = stack.pop();
                if (++count == k) return pRoot;
                //�ҵ��˸��ڵ����������ѭ������
                pRoot = pRoot.right;
            }
        }
        return null;
    }

    /**
     * �ݹ��������
     */
    int index = 0; //������
    TreeNode KthNode1(TreeNode root, int k)
    {
        if(root != null){ //�������Ѱ�ҵ�k��
            TreeNode node = KthNode1(root.left,k);
            if(node != null)
                return node;
            //���Բ����Լ�����ֵ
            index ++;
            if(index == k)
                return root;
            //��������û���ҵ������������������Ľڵ�
            node = KthNode1(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }

    /**
     * �ݹ�ⷨ��
     */
    ArrayList<TreeNode> treenode=new ArrayList<TreeNode>();
    TreeNode KthNode2(TreeNode pRoot, int k) {
        InOrder(pRoot);
        if(treenode.size()<1||k<1||k>treenode.size())
            return null;
        //���ؼ�������Ϊk-1�Ľڵ�
        return treenode.get(k-1);

    }
    //�������
    public void InOrder(TreeNode node)
    {
        if(node!=null)
        {
            InOrder(node.left);
            treenode.add(node);
            InOrder(node.right);
        }
    }
}
