package jzOffer.chap2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 将有序数组B归并到有序数组A中（A能容纳下B），归并后的A数组也是有序的
 */
public class MergeTwoSortedArray {
    public static int[] merge(Integer[] a, Integer[] b) {
        int size = a.length+b.length;
        int[] c = new int[size];
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=0;i<a.length;i++){
            c[i] = a[i];
        }
        for (int i=a.length;i<size;i++){
            c[i] = b[i-a.length];
        }
        Arrays.sort(c);
        return c;
    }

    /**
     * 基本思路是统计总的有效数字地址，从最后一位开始将两个数组中较大的那个插入第一个数组的最后一位
     * 每次索引位移，本题假设a数组有效数字都在前面
     * @param a
     * @param b
     */
    public static void merge1(Integer[] a, Integer[] b) {
       int len = 0;
       for (int i=0;i<a.length;i++){
           if (a[i] != null){
               len++;
           }
       }
       //a数组有效数字的最后一位
       int pA = len-1;
       int pB = b.length-1;
       int index = len+b.length-1;
       while (index >= 0){
           //注意a，b数组不同时取完的情况
           if (pA < 0){
               a[index--] = b[pB--];
           }else if (pB < 0){
               a[index--] = a[pA--];
           }else if (pA >= pB){
               a[index--] = a[pA--];
           }else {
               a[index--] = b[pB--];
           }

       }
    }

    public static void main(String[] args) {
//        Integer[] a = {2,4,6,8,10};
//        Integer[] b= {1, 3, 5, 7, 9};
//        int[] c = merge(a,b);
//        for (int i=0; i<c.length;i++) {
//            System.out.println(c[i]);
//        }
        Integer[] a = new Integer[10];
        Integer[] b= {1, 3, 5, 7, 9};
        // {2, 4, 6, 8, 10}
        for (int i = 0; i < 5; i++) {
            a[i] = 2 * i + 2;
        }

        merge1(a, b);
        System.out.println(Arrays.toString(a));
    }
}
