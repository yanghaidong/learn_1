package jzOffer.chap5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ����n���������ҳ�������С��K��������������4,5,1,6,2,7,3,8��8�����֣�����С��4��������1,2,3,4,��
 */
public class MinKOfArray {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
         int len = input.length;
         ArrayList<Integer> list = new ArrayList<>();
         if (input == null || len == 0 || k < 0 || k > len){
             return list;
         }
         select(input, k-1);
         for (int i=0;i<k;i++){
             list.add(input[i]);
         }
         return list;
    }

    private void select(int[] input, int index) {
        int i=0;
        int j=input.length-1;
        while (i<j){
            int k=partition(input,i,j);
            if (k == index) break;
            if (k > index) j=k-1;
            if (k < index) i=k+1;
        }
    }

    private int partition(int[] input, int low, int high) {
        int i=low;
        int j=high+1;
        //ѡȡ����ĵ�һ���������ǵ�0����
        int value=input[low];
        //ѭ������ֹ����Ϊ��������������
        while (true){
            //ѭ�����׼ֵ�Ƚϴ�С���ƶ�ָ��
            while (input[--j] > value) if (j == low) break;
            while (input[++i] < value) if (i == high) break;
            //�����Ǵ��ڵ��ڵĹ�ϵ,��ȻԽ��
            if (i >= j) break;
            swap(input, i, j);
        }
        swap(input, low, j);
        return j;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    /**
     * ʹ��Java���õ����ȶ���
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        int len = input.length;
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || len == 0 || k < 0 || k > len){
            return list;
        }
        //Ҫ��ת˳��(�������Ϊ������ȼ�����)��ֻ���������Ƚ����и���˳���ʹ��reversed��Ϊ,��֤����ǴӴ�С
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // ֻҪsize����k�������޳����ֵ��������ȶ�����ֻʣ��С��k��
        for (int a : input){
            maxHeap.offer(a);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        list.addAll(maxHeap);
        return list;
     }

    /**
     * ����ʵ��,������ʵ��
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        int len = input.length;
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || len == 0 || k < 0 || k > len){
            return list;
        }
        //������
        for (int i=len/2-1;i>=0;i--){
            adjustHeap(input, i, len);
        }

        //�滻��һ��Ԫ�ز������ѣ�ֱ��ȡ������������Ԫ��
        int N = len-1;
        // Ԫ�ؽ���֮�󣬺������ʣ����һ��Ԫ�������ٿ������������ˡ�
        // ������������Ҫ����ģ������Ѿ�ȥ���˲���Ԫ�صĶ��ˣ���Ҳ��Ϊʲô�˷�������ѭ�����ԭ��

        for (int j=N;j>N-k;j--){
            list.add(input[0]);
            swap(input, 0, j);
            adjustHeap(input, 0, j);
        }
        return list;
    }

    private void adjustHeap(int[] input, int i, int len) {
        int temp = input[i];
        for (int k=2*i+1;k<len;k=2*k+1){
            if (k+1<len && input[k] > input[k+1]){
                k++;
            }
            if (input[k] < temp){
                swap(input, k, i);
                i = k;
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        MinKOfArray m = new MinKOfArray();
        int[] array = {4,5,1,6,2,7,3,8};
        System.out.println(m.GetLeastNumbers_Solution(array,3));
        System.out.println(m.GetLeastNumbers_Solution1(array,4));
        System.out.println(m.GetLeastNumbers_Solution2(array,4));
    }
}
