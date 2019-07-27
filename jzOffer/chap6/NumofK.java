package jzOffer.chap6;

/**
 * ͳ��һ�����������������г��ֵĴ�����
 */
public class NumofK {
    /**
     * ����һ��������O(n)���Ӷȣ����Ƽ�
     */
    public int GetNumberOfK(int [] array , int k) {

       if (array == null || array.length == 0) return 0;
       int count = 0;
       for (int l : array){
           if (l == k){
               count++;
           }
       }
       return count;
    }

    /**
     * ���ַ��ҵ���һ��k�����һ��k��ʱ�临�Ӷ�O(nlgn)
     * @param array
     * @param k
     * @return
     */
    public int numberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        int firstKIndex = getFirstK(array, k, 0, array.length-1);
        int lastKIndex = getLastK(array, k, 0, array.length-1);

        //������ֵ����-1��ʱ��
        if (firstKIndex == -1 && lastKIndex == -1) return 0;
        return lastKIndex - firstKIndex +1;

    }

    private int getLastK(int[] array, int k, int low, int high) {
        while (low <= high){
            int mid = (low + high) >> 1;
            if (array[mid] > k) high = mid-1;
            else if (array[mid] < k) low = mid+1;
            //�ж�mid+1��Խ���Ľ�
            else if (mid+1 <= array.length-1 && array[mid+1] == k) low = mid+1;
            else return mid;
        }
        return -1;

    }

    private int getFirstK(int[] array, int k, int low, int high) {
        //�ݹ�����жϱ߽�����
        if (low > high){
            return -1;
        }
        int mid = (low + high) >> 1;
        if (array[mid] < k) return getFirstK(array, k, mid+1, high);
        else if (array[mid] > k) return getFirstK(array, k, low, mid-1);
        //�ж�mid-1���ڵ���0
        //!!!!!!!����Խ��������ǰ�棬���ܵߵ�˳��
        else if (mid-1 >= 0 && array[mid-1] == k) return getFirstK(array, k, low, mid-1);
        else return mid;
    }
    /**
     * ����ķ���3���õ���k���ڵ���������������
     * ��Ϊ������Ԫ��ʱint�͵�,��Ϊ���Ҹ����͵�ֵ��������3�Ĵ���������2.5��3.5֮���Ԫ�ظ�����
     * ��΢�ı���ֲ��ҵķ���ֵ���ܵõ�����������Ϊk�ķ���
     */
    public int numOfK(int[] array, int k) {
        if (array == null) return 0;
        return rank(array, k + 0.5) - rank(array, k - 0.5);
    }

    // ��Ϊ������Ԫ�ض���int�͵�,��Ϊ���Ҹ����͵�ֵ������Ҫ���3�ĳ��ִ���������2.5��3.5֮���Ԫ�ظ�����
    // ��΢�ı���ֲ��ҵķ���ֵ���ܵõ�����������Ϊk�ķ���
    private int rank(int[] array, double k) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (k < array[mid]) high = mid - 1;
            else if (k > array[mid]) low = mid + 1;
        }
        return low;
    }
    public static void main(String[] args) {
        int[] a = {3,3,3,3,4,5};
        NumofK k = new NumofK();
//        System.out.println(k.GetNumberOfK1(a,3));
        System.out.println(k.numberOfK(a,3));
    }
}
