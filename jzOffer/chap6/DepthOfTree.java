package jzOffer.chap6;

import java.util.LinkedList;

/**
 * 输入一棵二叉树，求该树的深度。
 * 从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
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
     * 递归版本
     * @param root
     * @return
     */
    public int TreeDepth(TreeNode root) {
      if (root == null) return 0;
      //每调用一次递归，如果当前节点不为空，则返回值每次加1，统计出深度大小
      int left = TreeDepth(root.left);
      int right = TreeDepth(root.right);

//      return Math.max(left,right) + 1;
      return left>right ? left+1 : right+1;

    }

    /**
     * 非递归版本，层次遍历
     * @param root
     * @return
     */
    public int TreeDepth1(TreeNode root){
        if (root == null) return 0;
        LinkedList<TreeNode> queue = new LinkedList();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()){
            //遍历同层节点，添加下一层节点
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
