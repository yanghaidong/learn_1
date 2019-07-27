package jzOffer.chap3;

/**
 * 输入两棵二叉树A，B，判断B是不是A的子结构。
 * ps：我们约定空树不是任意一个树的子结构
 */
public class subTree {
    class TreeNode{
        int val;
        TreeNode left = null;
        TreeNode right = null;

        TreeNode(int val){
            this.val = val;

        }
    }

    /**
     * 递归方案，第一个递归遍历树，找到相等节点
     * @param root1
     * @param root2
     * @return
     */
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        //标志用于检验是否找到子树
        boolean result = false;
        if (root1 != null && root2 !=null){
            if (root1.val == root2.val){
                result = isSubTree(root1,root2);
            }
            if (!result){
                result = HasSubtree(root1.left,root2);
            }
            if (!result){
                result = HasSubtree(root1.right,root2);
            }
        }
        return result;
    }

    /**
     * 第二个递归判断左右子树是否相同
     * @param root1
     * @param root2
     * @return
     */
    private boolean isSubTree(TreeNode root1, TreeNode root2) {
        //递归时子结构到叶节点，说明左节点或者右节点一致
        if (root2 == null){
            return true;
        }
        //树先结束了，说明肯定不符合
        if (root1 == null){
            return false;
        }
        //不相等，则肯定不符合
        if (root1.val != root2.val){
            return false;
        }
        //左右都得满足
        return isSubTree(root1.left,root2.left) && isSubTree(root1.right ,root2.right);
    }


    /**
     *
     * 更简洁的写法,利用短路特性
     * &&和||运算有一个短路特性简单叙述如下。
     *
     * 要使（表达式1）&&（表达式2）运算结果为真则要求：表达式1，表达式2都为真，如果表达式1为假，则不计算表达式2了，因为此时已经确定（表达式1）&&（表达式2）运算结果不可能为真，这就是&&运算的短路特性。
     *
     * 要使（表达式1）||（表达式2）运算结果为假则要求：表达式1，表达式2都为假，如果表达式1为真，则不计算表达式2了，因为此时已经确定（表达式1）||（表达式2）运算结果不可能为假，这就是||运算的短路特性。
     */
    public boolean HasSubtree1(TreeNode root1,TreeNode root2) {
        if (root1 == null || root2 == null){
            return false;
        }
        return isSubTree1(root1,root2) || HasSubtree1(root1.left,root2) || HasSubtree1(root1.right,root2);
    }

    private boolean isSubTree1(TreeNode root1, TreeNode root2) {
        /**
         * 检擦在判断是否子树的函数isSubtree里，先判断的rootB == NULL 还是 先判断的RootA == NULL,这个先后顺序不一样结果是不同的
         * 存在同时遍历到空，但是是子结构的情况
         * 顺序不能变
         */
        if (root2 == null)  return true;
        if (root1 == null)  return false;

       if (root1.val == root2.val){
           return isSubTree1(root1.left,root2.left) && isSubTree1(root1.right,root2.right);
       }else {
           return false;
       }
    }

}
