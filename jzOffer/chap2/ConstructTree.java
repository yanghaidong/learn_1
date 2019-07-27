package jzOffer.chap2;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * ����ĳ��������ǰ���������������Ľ�������ؽ����ö����������������ǰ���������������Ľ���ж������ظ������֡�
 * ��������ǰ���������{1,2,4,7,3,5,6,8}�������������{4,7,2,1,5,3,8,6}�����ؽ������������ء�
 */
public class ConstructTree {
    private class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    /**
     * �ݹ齨�������
     * @param pre
     * @param in
     * @return
     */
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null){
            return null;
        }
        TreeNode root = reConstructBinaryTree(pre,0,pre.length-1,in,0,in.length-1);
        return root;
    }

    /**
     * ���ݸ��ڵ㹹����������ǰ�����ÿ��������ʼ�����ֵΪ���ڵ�ȡֵ�������ڵ�
     * �����������Ѱ�Ҹ��ڵ����꣬���з�����ݹ�
     * ÿ�εĵݹ��������£�
     * @param pre
     * @param preStart  �����䣺+1�������䣺preStart+index-inStart+1
     * @param preEnd    �����䣺preStart+index-inStart;�����䣺preEnd
     * @param in
     * @param inStart   �����䣺instart;�����䣺i-1
     * @param inEnd     �����䣺i+1;�����䣺inEnd
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        //�����ʼ���������ֹ���꣬����ֹ
        if (preStart > preEnd || inStart > inEnd){
            return null;
        }
        int rootVal = pre[preStart];
        TreeNode root = new TreeNode(rootVal);
        for (int i=inStart;i<=inEnd;i++){
            if (rootVal==in[i]){
                root.left = reConstructBinaryTree(pre,preStart+1,preStart+i-inStart,in,inStart,i-1);
                root.right = reConstructBinaryTree(pre,preStart+i-inStart+1,preEnd,in,i+1,inEnd);
                break;
            }
        }
        return root;
    }

    /**
     * ��ӡ������
     * ͨ��һ�����У���˳���¼���ڵ�����Һ���
     * ѭ���Զ��н���ȡֵ����list��˳�������Һ��ӽڵ�������
     * ��ֹ����Ϊ����Ϊ��
     * @param root
     * @return
     */
    private ArrayList<Integer> PrintFromTopToBottom(TreeNode root){
        ArrayList<Integer> binaryTree = new ArrayList<Integer>();
        if (root == null) {
            return binaryTree;
        }
        LinkedList<TreeNode> tempQueue = new LinkedList<>();
        tempQueue.add(root);
        while (!tempQueue.isEmpty()){
            TreeNode temp = tempQueue.remove();
            binaryTree.add(temp.val);
            if (temp.left != null){
                tempQueue.add(temp.left);
            }
            if (temp.right != null){
                tempQueue.add(temp.right);
            }
        }
        return binaryTree;
        }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        ConstructTree constructTree = new ConstructTree();
        TreeNode root = constructTree.reConstructBinaryTree(pre,in);


        System.out.println(constructTree.PrintFromTopToBottom(root));
    }
}
