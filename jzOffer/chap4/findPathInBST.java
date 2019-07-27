package jzOffer.chap4;

import java.util.ArrayList;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class findPathInBST {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (root == null || target < 0) return arrayLists;
        ArrayList<Integer> path = new ArrayList<>();
        preOrder(root,target,path,arrayLists);
        return arrayLists;
    }

    private void preOrder(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> arrayLists) {
        if (root == null) return;
        path.add(root.val);
        //用减替代加，可以减少累积变量
        target -= root.val;

        //没有叶节点，就到头了
        if (root.left == null && root.right == null && target == 0){
            arrayLists.add(new ArrayList<Integer>(path));
        }
        //父节点之前的左右节点都包括了
        preOrder(root.left,target,path,arrayLists);
        preOrder(root.right,target,path,arrayLists);

        //去除节点尝试其他情况
        path.remove(path.size()-1);
        target+=root.val;
    }

}
