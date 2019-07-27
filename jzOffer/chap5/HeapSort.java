package jzOffer.chap5;

import java.util.Arrays;

/**
 * ������
 */
public class HeapSort {
    public void heapSort(int[] array){
        int len = array.length;
        if (array == null && len == 0) return;

        //��������
        for (int i=len/2-1;i>=0;i--){
            adjustHeap(array, i, len);
        }

        //��������
        for (int j=len-1;j>0;j--){
            swap(array, 0, j);
            // Ԫ�ؽ���֮�󣬺������ʣ����һ��Ԫ�������ٿ������������ˡ�
            // ������������Ҫ����ģ������Ѿ�ȥ���˲���Ԫ�صĶ��ˣ���Ҳ��Ϊʲô�˷�������ѭ�����ԭ��
            // �����ʵ���������϶��£��������ҽ��е�����

            adjustHeap(array, 0, j);
        }
    }

    private void adjustHeap(int[] array, int i, int len) {
        // �Ȱѵ�ǰԪ��ȡ��������Ϊ��ǰԪ�ؿ���Ҫһֱ�ƶ�
        int temp = array[i];
        // ʵ���ϣ����Ǹ��ڵ���������ӽڵ���ԱȽϣ���kָ����������������ڵ������������ֵ
        // �������Ҫ˵��Ϊʲôkֵ����Ծ�Եġ�
        // ���ȣ��ٸ����ӣ����a[0] > a[1]&&a[0]>a[2],˵��0,1,2���������Ҫ��������ô����һ���õ��ĸ��ڵ����أ��϶���a[1]���ڵ������ˣ�
        // Ҳ����˵�����Ա��ڵ�����ӽڵ�Ϊ�����ǿ�С������
        // �����a[0}<a[2]�أ��Ǿ͵���a[0]��a[2]��λ�ã�Ȼ�����������a[2]Ϊ���ڵ���ǿ����������ҿ϶��Ǵ���������ʼ������
        // ���ԣ����������������ڣ����϶��£���������һ�������������Ĳ��֣�ֱ��ÿһ��С�������������ѵĹ���Ϊֹ

        for (int k=2*i+1;k<len;k=2*k+1){
            if (k+1 < len && array[k] < array[k+1] ){
                k++;
            }
            // ��������ӽڵ���������ֵ�Ľ���
            if (temp < array[k]){
                swap(array, k, i);
                // ������Ƿǳ��ؼ���һ����
                // ����ӽڵ�����ˣ���ô�����ӽڵ�Ϊ���������᲻���ܵ�Ӱ���أ�
                // ���ԣ�ѭ�����ӽڵ����ڵ������������ж�

                i = k;//�ı���ǽ�����iֵ
            }else {
                break;
            }
        }
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    public static void main(String[] args) {
        HeapSort h = new HeapSort();
        int [] arr = {10,7,2,11,3,4,1,8};
        h.heapSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
