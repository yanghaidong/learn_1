package jzOffer.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class ReOderArray {
    /**
     * 构造新数组
     * @param array
     */
    public void reOrderArray(int [] array) {

         int len = array.length;
        if (array == null || len == 0){
            return;
        }
         List<Integer> mergeArray = new ArrayList<>();
         List<Integer> evenList = new ArrayList<>();
         for (int i=0;i<len;i++){
             if (array[i] % 2 != 0){
                 mergeArray.add(array[i]);
             }else {
                 evenList.add(array[i]);
             }
         }
         mergeArray.addAll(evenList);
         for (int i=0;i<len;i++){
             array[i] = mergeArray.get(i);
         }
    }
    /**
     * 没有顺序
     * @param array
     */
    public static void reOrderArray1(int [] array) {
        int len = array.length;
        if (array == null || len == 0){
            return;
        }
        int p1 = 0;
        int p2 = len-1;
        while (p1 < p2) {
            //0开始，找到第一个不是奇数的
            while (isOdd(array[p1])) {
                p1++;
            }
            //最后一位开始找到第一个不是偶数的
            while (!isOdd(array[p2])) {
                p2--;
            }
            //满足条件，因为循环内可能产生
            if (p1 < p2) {
                swap(array, p1, p2);
            }
        }
    }

    /**
     * 判断奇偶
     * @param val
     * @return
     */
    private static boolean isOdd(int val) {
        return (val & 1) == 1;
    }

    /**
     * 交换数组数字
     * @param c
     * @param a
     * @param b
     */
    private static void swap(int[] c,int a, int b) {
        int temp = c[a];
        c[a]=c[b];
        c[b]=temp;
    }

    /**
     * 解决无序问题
     * @param array
     */
    public static void reOrderArray2(int [] array) {
        int len = array.length;
        if (array == null || len == 0){
            return;
        }
        //冒泡相邻的交换，i用来控制控制扫描前面已经确定的最小奇数，最前面的肯定是不需要在变换位置的数
        for (int i=0;i<len;i++){
            for (int j=len-1;j>i;j--){
                //前偶后奇，并且j-1可避免越界
                if (isOdd(array[j]) && !isOdd(array[j-1])){
                    swap(array,j,j-1);
                }
            }
        }
    }
    public static void main(String[] args) {
       int[] c = {1,2,3,4,5,6,7};
       reOrderArray2(c);
       System.out.println(Arrays.toString(c));
    }
}
