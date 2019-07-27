package jzOffer.chap5;

/**
 * ����һ���������飬�������������������У������е�һ�����������Ķ���������һ�������顣
 * ������������ĺ͵����ֵ��Ҫ��ʱ�临�Ӷ�ΪO(n)
 */
public class MaxSumOfSubArray {
    /**
     * ��ͨ�ۼ��㷨
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length == 0) return 0;
          int curSum = array[0];
          int maxSum = array[0];
          for (int i=1;i<array.length;i++){
              if (curSum < 0) curSum = array[i];
              else {
                  curSum += array[i];
              }
              if (curSum > maxSum) maxSum = curSum;
          }
          return maxSum;
    }

    /**
     * ��̬�滮
     * @param array
     * @return
     */
    public static int FindGreatestSumOfSubArray1(int[] array) {
        if (array == null || array.length == 0) return 0;
        int curSum = array[0];
        int maxSum = array[0];
        for (int i=1;i<array.length;i++){
            curSum = Math.max(curSum+array[i],array[i]);
            maxSum = Math.max(curSum,maxSum);
        }
        return maxSum;
    }

    public static void main(String[] args) {
        int[] a = {6,-3,-2,7,-15,1,2,2};
        System.out.println(FindGreatestSumOfSubArray(a));
        System.out.println(FindGreatestSumOfSubArray1(a));
    }
}
