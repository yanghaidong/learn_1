package jzOffer.chap5;


import java.util.Arrays;

/**
 * ��������һ�����ֳ��ֵĴ����������鳤�ȵ�һ�룬���ҳ�������֡�
 * ��������һ������Ϊ9������{1,2,3,2,2,2,5,4,2}����������2�������г�����5�Σ��������鳤�ȵ�һ�룬������2����������������0��
 */
public class MoreThanHalf {
    /**
     * �������
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
         if (array == null && len == 0){
             return 0;
         }
         //�������Ϊ����Ϊ1ʱ������Ҫ�Ա�
         if (len == 1){
             return array[0];
         }
         for (int i=0;i<len;++i){
             int count = 1;
             for (int j=i+1;j<len;++j){
                 if (array[i] == array[j]){
                     if ((len/2) < ++count){
                         return array[i];
                     }
                 }
             }
         }
         return 0;
    }

    /**
     * ��������λ��
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        int len = array.length;
        if (array == null || len == 0) return 0;
        Arrays.sort(array);
        //�������������������λ����Ȼ�Ǵ���һ�����
        int medin = array[len/2];
        int count = 0;
        //�ҵ���������
        for (int one : array){
            if (medin == one){
                count++;
            }
        }
        if (count > len/2){
            return medin;
        }
        return 0;
    }

    /**
     * ����з������������֣��������ֵĴ����������������ֳ��ֵĴ����ͻ�Ҫ�ࡣ
     * �ڱ�������ʱ��������ֵ��һ��������һ�����֣�һ�Ǵ�����������һ������ʱ��������֮ǰ�����������ͬ���������1�����������1��������Ϊ0���򱣴���һ�����֣�����������Ϊ1����������������������ּ�Ϊ����Ȼ�����ж����Ƿ�����������ɡ�
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution2(int [] array) {
        int len = array.length;
        if (array == null || len == 0){
            return 0;
        }
        int num = array[0];
        int count = 1;
        for (int i=1;i<array.length;++i){
            if (count == 0){
                num = array[i];
                count = 1;
            }else if (num == array[i]){
                count++;
            }else {
                count--;
            }
        }
        return checkMoreThanHalf(array, num);
    }

    private int checkMoreThanHalf(int[] array, int number) {
        int count = 0;
        for (int i=0;i<array.length;++i){
            if (array[i] == number){
                count++;
            }
        }
        return count > array.length/2 ? number : 0;
    }

    /**
     * ���ÿ�������ķ�ʽ�ҵ����������м����
     * �ô����ڲ�һ��Ҫ����������ܳ��ֽ����ֻҪ����ֵ�������м�λ�ü���
     * ҲҪ�������ĸ���
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution3(int [] array) {
        int len = array.length;
        if (array == null || len == 0){
            return 0;
        }
        int mid = selectMid(array , len/2);
        return checkMoreThanHalf(array, mid);
    }

    private int selectMid(int[] array, int middle) {
        int low = 0;
        int high = array.length-1;
        /**
         * �ݹ鷽ʽ
         *
         */
        int index = partition(array,low,high);
        while (index != middle){
            if (index > middle){
                high = index-1;
                index = partition(array, low, high);
            }else {
                low = index+1;
                index = partition(array, low, high);
            }
        }
        /**
         * ѭ����ʽ
         */
        while (high > low){
            //���ؿ��ŵĲ���ֵ
            int j = partition(array , low , high);
            if (j == middle) break;
            //��׼ֵ���ϻ�����
            if (j > middle) high = j-1;
            if (j < middle) low = j+1;
        }
        return array[middle];
    }

    private int partition(int[] array, int low, int high) {
        //�����ҵ���ʼ��λ��
        int i = low;
        //��λ������һλ����֤�ӵ�����һλ��ʼ�Ƚ�
        int j = high;
        int v = array[low];

        while (true){
            while (array[++i] < v) if (i >= high) break;
            while (array[--j] > v) if (j <= low) break;
            if (i >= j) break;
            swap(array, i , j);
        }
        //��������ֵ�������´ο�ʼ
        swap(array, low, j);
        return j;
    }

    private void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    public static void main(String[] args) {
        MoreThanHalf m = new MoreThanHalf();
        int[] arr = {1,2,3,2,2,2,5,4,2};
        int[] arr1 = {4,2,1,4,2,4};
        System.out.println(m.MoreThanHalfNum_Solution(arr));
//        System.out.println(m.MoreThanHalfNum_Solution1(arr));
        System.out.println(m.MoreThanHalfNum_Solution1(arr1));
    }
}
