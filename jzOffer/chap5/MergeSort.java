package jzOffer.chap5;

import java.util.Arrays;

/**
 * �鲢���򣺷���˼��
 */
public class MergeSort {
    //���������飬���Է���ֵΪ������
    public static int[] mergerSort(int[] array, int left, int right){
        if (left == right){
            return new int[]{array[left]};
        }
        int mid = (left + right) / 2;
        //���ΰ���λ���
        int[] lArray = mergerSort(array, left, mid);
        int[] rArray = mergerSort(array, mid+1, right);
        //�õ��Ľ���ֱ�ϲ�������
        return merge(lArray, rArray);
    }
    private static int[] merge(int[] lArray, int[] rArray) {
        int[] newArray = new int[lArray.length+rArray.length];
        int p = 0;
        int pl = 0;
        int pr = 0;
        //���߶�����ʱ���������αȽϣ�������ȡ��С��
        while (pl < lArray.length && pr < rArray.length){
            newArray[p++] = lArray[pl] < rArray[pr] ? lArray[pl++] : rArray[pr++];
        }
        //ֻʣ��һ��ʱ���������
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
