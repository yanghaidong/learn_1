package jzOffer.chap3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ����һ���������飬ʵ��һ�����������������������ֵ�˳��ʹ�����е�����λ�������ǰ�벿�֣����е�ż��λ��λ������ĺ�벿�֣�
 * ����֤������������ż����ż��֮������λ�ò��䡣
 */
public class ReOderArray {
    /**
     * ����������
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
     * û��˳��
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
            //0��ʼ���ҵ���һ������������
            while (isOdd(array[p1])) {
                p1++;
            }
            //���һλ��ʼ�ҵ���һ������ż����
            while (!isOdd(array[p2])) {
                p2--;
            }
            //������������Ϊѭ���ڿ��ܲ���
            if (p1 < p2) {
                swap(array, p1, p2);
            }
        }
    }

    /**
     * �ж���ż
     * @param val
     * @return
     */
    private static boolean isOdd(int val) {
        return (val & 1) == 1;
    }

    /**
     * ������������
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
     * �����������
     * @param array
     */
    public static void reOrderArray2(int [] array) {
        int len = array.length;
        if (array == null || len == 0){
            return;
        }
        //ð�����ڵĽ�����i�������ƿ���ɨ��ǰ���Ѿ�ȷ������С��������ǰ��Ŀ϶��ǲ���Ҫ�ڱ任λ�õ���
        for (int i=0;i<len;i++){
            for (int j=len-1;j>i;j--){
                //ǰż���棬����j-1�ɱ���Խ��
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
