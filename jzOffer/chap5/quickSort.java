package jzOffer.chap5;

import java.util.Arrays;

/**
 * ��������
 */
public class quickSort {
    /**
     * ��������j���ƶ�ռ�����ԣ�j���ҵ�һ��<=5������i���ܿ�ʼ�ж���>2������j���ǻ�ͣ��<=5�������ϣ�����˵����len(data)>5��data��j��i�������������ҵġ�<=���������λ���ϡ�
     * ��������Ϊ�˱���data[j]��data[0]������������j���У������i���У���ô�෴�ģ�i��jͨ������������ġ�>���������λ���ϣ�����������data[i]��data[0]����
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] qsort(int[] array, int start, int end){
        //�쳣
        if (array == null || start > end || array.length == 0){
            return array;
        }
        //��������ָ��
        int i = start;
        int j = end;
        //����Ϊ����Ҫʹ�õĻ�׼��ѡȡÿ�������һ����
        int v = array[start];
        while (i < j){
            //��������j��˳���ܻ�,����ÿ�ο�����������Խ�磬��������
            while (i < j && array[j] > v){
                j--;
            }
            //������ѭ����ֹ������
            while (i < j && array[i] < v){
                i++;
            }
            if (i < j && array[i] == array[j]){
                i++;
            }else {
                //�ҵ�ǰ���Ӧ������ֵ��������λ��
                swap(array, i, j);
            }
        }
        //������ݹ飬ÿ���������������������
        array = qsort(array, start, i-1);
        array = qsort(array, j+1, end);

        return array;

    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * �����淽ʽ�ĸĽ�������Ҫ���ñ������н������ñ����Ŀռ������¸�ֵ
     * 1��i =L; j = R; ����׼���ڳ��γɵ�һ����a[i]��
     * 2��j--�ɺ���ǰ�ұ���С�������ҵ����ڳ�������ǰһ����a[i]�С�
     * 3��i++��ǰ����ұ�����������ҵ���Ҳ�ڳ������ǰһ����a[j]�С�
     * 4�����ظ�ִ��2��3������ֱ��i==j������׼������a[i]�С�
     * @param array
     * @param start
     * @param end
     */
    public static void qsort1(int[] array, int start, int end){
        if (array == null || start > end || array.length == 0){
            return;
        }
        int i = start;
        int j = end;
        int v = array[start];
        while (i < j){
            //���ڵ����Ҳ��������
            while (i < j && array[j] >= v){
                j--;
            }
            //��֮ǰi��λ�����滻j��ֵ������1Խ��������������Ȼ��������
            if (i < j){
                array[i++] = array[j];
            }
            while (i < j && array[i] < v ){
                i++;
            }
            if (i < j){
                array[j--] = array[i];
            }

        }
        //��׼�ŵ��м�
        array[i] = v;
        qsort1(array, start, j-1);
        qsort1(array, i+1, end);
    }


    public static void main(String[] args) {
        int [] arr = {10,7,2,11,3,4,1,8};

        System.out.println(Arrays.toString(qsort(arr,0,arr.length-1)));
        qsort1(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
