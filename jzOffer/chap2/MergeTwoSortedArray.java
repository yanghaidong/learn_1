package jzOffer.chap2;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * ����������B�鲢����������A�У�A��������B�����鲢���A����Ҳ�������
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
     * ����˼·��ͳ���ܵ���Ч���ֵ�ַ�������һλ��ʼ�����������нϴ���Ǹ������һ����������һλ
     * ÿ������λ�ƣ��������a������Ч���ֶ���ǰ��
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
       //a������Ч���ֵ����һλ
       int pA = len-1;
       int pB = b.length-1;
       int index = len+b.length-1;
       while (index >= 0){
           //ע��a��b���鲻ͬʱȡ������
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
