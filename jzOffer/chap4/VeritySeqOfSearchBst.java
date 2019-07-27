package jzOffer.chap4;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。假设输入的数组的任意两个数字都互不相同。
 */
public class VeritySeqOfSearchBst {

    /**
     * 思路：
     * 已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
     * 1、确定root；
     * 2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
     * 3、遍历右子树，若发现有小于root的值，则直接返回false；
     * 4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0){
            return false;
        }
        return isSearchBST(sequence,0,sequence.length-1);
    }

    private boolean isSearchBST(int[] sequence, int begin, int end) {
        //如果索引相等，必然为叶节点，如果小于必然不存在左子树或者右子树
        if (begin >= end) return true;

        int rootVal = sequence[end];
        int i = begin;
        //保证循环不越界
        while (sequence[i] < rootVal && i < end){
            i++;
        }
        //找到第一个大于根节点的作为分界点
        int bound = i;
        while (i < end){
            //不越界情况下，出现小于则肯定不是
            if (sequence[i] < rootVal) return false;
            i++;
        }
        //子树递归
        return isSearchBST(sequence,begin,bound-1) && isSearchBST(sequence,bound,end-1);
    }


    /**
     * 非递归
     * 非递归也是一个基于递归的思想：
     * 左子树一定比右子树小，因此去掉根后，数字分为left，right两部分，right部分的
     * 最后一个数字是右子树的根他也比左子树所有值大，因此我们可以每次只看有子树是否符合条件
     * 即可，即使到达了左子树左子树也可以看出由左右子树组成的树还像右子树那样处理
     *
     * 对于左子树回到了原问题，对于右子树，左子树的所有值都比右子树的根小可以暂时把他看出右子树的左子树
     * 只需看看右子树的右子树是否符合要求即可
     */

    public boolean VerifySquenceOfBST1(int [] sequence) {
        int size = sequence.length;
        if (sequence == null || size <= 0){
            return false;
        }
        int i = 0;
        while (--size >= 0){
            while (sequence[i] < sequence[size]) i++;
            while (sequence[i] > sequence[size]) i++;
            //如果前面出现大小顺序颠倒，不满足先小后大的条件，循环提前终止
            if (i < size) return false;
            i = 0;
        }
        return true;
    }
}
