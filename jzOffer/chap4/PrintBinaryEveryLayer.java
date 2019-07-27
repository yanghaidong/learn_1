package jzOffer.chap4;


import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 */
public class PrintBinaryEveryLayer {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 思路，增加两个变量分别表示当前行的节点数目和下一行的节点数目
     * 每打印一次当前行减一，每添加一次子节点下一行加1
     * 当前行为0时赋值下一行，下一行清0
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int toBePrinted = 1;
        int nextLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        if (pRoot == null) return list;
        //放在循坏里会变成每次只有一个
        ArrayList<Integer> perList = new ArrayList<>();
        while (!queue.isEmpty()){

            TreeNode temp = queue.poll();
            perList.add(temp.val);
            toBePrinted--;


            if (temp.left != null){
                queue.offer(temp.left);
                nextLevel++;
            }
            if (temp.right != null){
                queue.offer(temp.right);
                nextLevel++;
            }

            if (toBePrinted == 0){
                list.add(new ArrayList<Integer>(perList));
                //直接把内存地址清空
                perList.clear();
                /**
                 * 或者采用如下注释
                 *
                 */
//                list.add(perList);
//                perList = new ArrayList<Integer>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }

        return list;
    }

    // 也是分行打印，比上面简洁
    public void printEveryLayer(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val+" ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println();
        }
    }

    /**
     * 统计队列中每一层的节点数，循环添加
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        ArrayList<Integer> layerList = new ArrayList<>();
        while (!queue.isEmpty()){
            int layerSize = queue.size();
            //每次都将每一行统计完再出循环，进入下一行
            for (int i=0;i<layerSize;++i){
                TreeNode temp = queue.poll();
                layerList.add(temp.val);

                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);

            }
            lists.add(new ArrayList<Integer>(layerList));
            layerList.clear();
        }
        return lists;
    }

    /**
     * 递归解法
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        depth(pRoot,1,lists);
        return lists;
    }

    private void depth(TreeNode treeNode, int depth, ArrayList<ArrayList<Integer>> lists) {
        if (treeNode == null) return;
        //深度改变时，才往集合中加入新的list
        if (depth > lists.size()){
            lists.add(new ArrayList<Integer>());
        }
        //直接将该节点值接如最后的list中
        lists.get(depth-1).add(treeNode.val);

        depth(treeNode.left,depth+1,lists);
        depth(treeNode.right,depth+1,lists);
    }

}
