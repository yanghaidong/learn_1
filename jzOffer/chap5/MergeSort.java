package jzOffer.chap5;

import java.util.Arrays;

/**
 * 归并排序：分治思想
 */
public class MergeSort {
    //创建了数组，所以返回值为新数组
    public static int[] mergerSort(int[] array, int left, int right){
        if (left == right){
            return new int[]{array[left]};
        }
        int mid = (left + right) / 2;
        //依次按层次划分
        int[] lArray = mergerSort(array, left, mid);
        int[] rArray = mergerSort(array, mid+1, right);
        //得到的结果分别合并并排序
        return merge(lArray, rArray);
    }
    private static int[] merge(int[] lArray, int[] rArray) {
        int[] newArray = new int[lArray.length+rArray.length];
        int p = 0;
        int pl = 0;
        int pr = 0;
        //两边都存在时，两边依次比较，新数组取最小的
        while (pl < lArray.length && pr < rArray.length){
            newArray[p++] = lArray[pl] < rArray[pr] ? lArray[pl++] : rArray[pr++];
        }
        //只剩下一边时的两种情况
        while (pl < lArray.length){
            newArray[p++] = lArray[pl++];
        }
        while (pr < rArray.length){
            newArray[p++] = rArray[pr++];
        }
        return newArray;
    }

    public static void main(String[] args) {
        int[] arrays = {9, 2, 5, 1, 3, 2, 9, 5, 2, 1, 8};
        System.out.println(Arrays.toString(mergerSort(arrays, 0, arrays.length-1)));
    }
}
