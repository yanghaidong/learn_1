package jzOffer.chap6;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 要求时间复杂度为O(n)，空间复杂度为O(1).
 */


public class FindTwoOnlyOnceAndTwo {
    /**
     * 首先：位运算中异或的性质：两个相同数字异或=0，一个数和0异或还是它本身。
     *
     * 对数组所有元素进行异或运算，因为最后剩下两个只出现过一次的数字，所以是两个数的异或结果
     * 根据结果找到两个二进制不同的位数，也就是异或为1
     * 以该位是否为1为标志，将所有数分组，相同的必然在同一分组，两个数必然不在一起
     * 再次异或，最后剩下的就是该数
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null && array.length < 2) return;
        int res = 0;
        for (int i=0;i<array.length;i++){
            res ^= array[i];
        }
        //与操作一样的时候是0，不同时是1,意味着找到第一个不同的位
        int index = firstBitOfOne(res);
        for (int i=0;i<array.length;i++){
            //根据该位索引是否为1，分类
            if (isBitOne(array[i], index)) num1[0] ^= array[i];
            else num2[0] ^= array[i];
        }
    }

    private boolean isBitOne(int number, int index) {
        return ((number >> index) & 1)  == 1;
    }

    private int firstBitOfOne(int res) {
        //记录二进制索引位置
        int index = 0;
        while ((res & 1) == 0 && index < 32){
            res = res >> 1;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        FindTwoOnlyOnceAndTwo f = new FindTwoOnlyOnceAndTwo();
        int[] array = {2,4,3,6,3,2,5,5};
        int[] a = {0};
        int[] b = {0};
        f.FindNumsAppearOnce(array,a,b);
        System.out.println(a[0]+" "+b[0]);
    }
}
