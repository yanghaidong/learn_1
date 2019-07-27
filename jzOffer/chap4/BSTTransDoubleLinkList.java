package jzOffer.chap4;


import java.util.Stack;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class BSTTransDoubleLinkList {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 解题思路：
     * 1.将左子树构造成双链表，并返回链表头节点。
     * 2.定位至左子树双链表最后一个节点。
     * 3.如果左子树链表不为空的话，将当前root追加到左子树链表。
     * 4.将右子树构造成双链表，并返回链表头节点。
     * 5.如果右子树链表不为空的话，将该链表追加到root节点之后。
     * 6.根据左子树链表是否为空确定返回的节点。
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
       if (pRootOfTree == null) return null;
       if (pRootOfTree.right == null && pRootOfTree.left == null){
           return pRootOfTree;
       }
       //左边子树交换顺序，并返回链表的头结点
       TreeNode left = Convert(pRootOfTree.left);
       TreeNode p = left;

       //定位到左子树双链表最后一个节点
       while (p != null && p.right != null){
           p = p.right;
       }

       //如果左子树链表不为空，根添加到末尾
        if (left != null){
            p.right = pRootOfTree;
            pRootOfTree.left = p;
        }

        //右子树交换节点，并返回形成链表的头结点
        TreeNode right = Convert(pRootOfTree.right);

        //如果右子树不为空，根添加到头部
        if (right != null){
            right.left = pRootOfTree;
            pRootOfTree.right = right;
        }

        return left != null ? left : pRootOfTree;
    }

    /**
     * 递归的改进，新增一个全局变量记录左子树的最后一个节点
     * @param pRootOfTree
     * @return
     */
    //记录子树链表的最后一个节点，终结点只可能为只含左子树的非叶节点与叶节点
            //不能放在递归函数里
    protected TreeNode leftLast = null;
    public TreeNode convert(TreeNode pRootOfTree){

         if (pRootOfTree == null) return null;
         if (pRootOfTree.left == null && pRootOfTree.right == null){
             //最后一个节点可能为最右侧的叶节点
             leftLast = pRootOfTree;
             return pRootOfTree;
         }

         TreeNode left = convert(pRootOfTree.left);
         if (left != null){
             leftLast.right = pRootOfTree;
             pRootOfTree.left = leftLast;
         }
         // 当根节点只含左子树时，则该根节点为最后一个节点
         leftLast = pRootOfTree;
         TreeNode right = convert(pRootOfTree.right);
         if (right != null){
             right.left = pRootOfTree;
             pRootOfTree.right = right;
         }

         return left != null ? left : pRootOfTree;
    }

    /**
     * 非递归解法
     * 用栈保存中序遍历的结果
     * pre记录上一个节点，交换前后的指针
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert1(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return null;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = pRootOfTree;
        TreeNode pre = null;
        boolean isFirst = true;
        //可能出现叶节点为空的情况
        while (p != null || !stack.isEmpty()){
            while (p != null){
                stack.push(p);
                p = p.left;
            }
            p = stack.pop();
            //如果是第一次，则记录第一个节点，作为返回值
            if (isFirst){
                pRootOfTree = p;
                pre = pRootOfTree;
                isFirst = false;

            }else {
                //否则交换，而且左右的交换顺序一致
                pre.right = p;
                p.left = pre;
                pre = p;
            }
            //左节点结束遍历右节点
            p = p.right;
        }
        return pRootOfTree;
    }

}
