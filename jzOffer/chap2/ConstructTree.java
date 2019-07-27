package jzOffer.chap2;


import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
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
     * 递归建造二叉树
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
     * 根据根节点构造树，对于前序遍历每段区间起始坐标的值为根节点取值构造树节点
     * 在中序遍历中寻找根节点坐标，进行分区间递归
     * 每次的递归区间如下：
     * @param pre
     * @param preStart  左区间：+1；右区间：preStart+index-inStart+1
     * @param preEnd    左区间：preStart+index-inStart;右区间：preEnd
     * @param in
     * @param inStart   左区间：instart;右区间：i-1
     * @param inEnd     左区间：i+1;右区间：inEnd
     * @return
     */
    private TreeNode reConstructBinaryTree(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        //如果起始坐标大于终止坐标，则终止
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
     * 打印二叉树
     * 通过一个队列，按顺序记录根节点和左右孩子
     * 循环对队列进行取值加入list，顺带将左右孩子节点加入队列
     * 终止条件为队列为空
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
