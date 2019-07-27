package jzOffer.chap6;



import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 给定一颗二叉搜索树，请找出排名第k的结点。
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
     * 非递归中序遍历
     * @param pRoot
     * @param k
     * @return
     */
    TreeNode KthNode(TreeNode pRoot, int k)
    {
       if (pRoot == null || k <= 0) return null;
       //使用栈保存中间节点
        LinkedList<TreeNode> stack = new LinkedList<>();
        int count = 0;
        while (pRoot != null || !stack.isEmpty()){
            //先找到树最左下的节点
            while (pRoot != null){
                stack.push(pRoot);
                pRoot = pRoot.left;
            }
            if (!stack.isEmpty()){
                pRoot = stack.pop();
                if (++count == k) return pRoot;
                //找到此根节点的右子树，循环往复
                pRoot = pRoot.right;
            }
        }
        return null;
    }

    /**
     * 递归中序遍历
     */
    int index = 0; //计数器
    TreeNode KthNode1(TreeNode root, int k)
    {
        if(root != null){ //中序遍历寻找第k个
            TreeNode node = KthNode1(root.left,k);
            if(node != null)
                return node;
            //共性操作以及返回值
            index ++;
            if(index == k)
                return root;
            //左子树中没有找到，继续遍历右子树的节点
            node = KthNode1(root.right,k);
            if(node != null)
                return node;
        }
        return null;
    }

    /**
     * 递归解法二
     */
    ArrayList<TreeNode> treenode=new ArrayList<TreeNode>();
    TreeNode KthNode2(TreeNode pRoot, int k) {
        InOrder(pRoot);
        if(treenode.size()<1||k<1||k>treenode.size())
            return null;
        //返回集合索引为k-1的节点
        return treenode.get(k-1);

    }
    //中序遍历
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
