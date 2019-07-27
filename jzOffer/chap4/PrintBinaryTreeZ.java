package jzOffer.chap4;


import java.util.ArrayList;
import java.util.LinkedList;


/**
 *请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 */
public class PrintBinaryTreeZ {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 两个栈记录不同方向的输出，一个记录奇数行从左到右，一个记录偶数行从右到左，循环打印
     * 打印后一行后，改变左右节点的放入顺序，先进先出
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
           ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
           if (pRoot == null) return  lists;

           LinkedList<TreeNode> stackOdd = new LinkedList<>();
           LinkedList<TreeNode> stackEven = new LinkedList<>();
           stackOdd.push(pRoot);

           //有一个不为空，则循环继续
           while (!stackOdd.isEmpty() || !stackEven.isEmpty()){
               ArrayList<Integer> perList = new ArrayList<>();
               if (!stackOdd.isEmpty()){
                   while (!stackOdd.isEmpty()){
                       TreeNode temp = stackOdd.pop();
                       perList.add(temp.val);

                       if (temp.left != null) stackEven.push(temp.left);
                       if (temp.right != null) stackEven.push(temp.right);
                   }
               }else {
                   while (!stackEven.isEmpty()){
                       TreeNode temp = stackEven.pop();
                       perList.add(temp.val);

                       if (temp.right != null) stackOdd.push(temp.right);
                       if (temp.left != null) stackOdd.push(temp.left);
                   }
               }
               lists.add(perList);
           }
          return lists;
    }
}
