package jzOffer.chap5;

/**
 * 输入一个整型数组，数组里正负数都可能有，数组中的一个或者连续的多个整数组成一个子数组。
 * 求所有子数组的和的最大值，要求时间复杂度为O(n)
 */
public class MaxSumOfSubArray {
    /**
     * 普通累加算法
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
     * 动态规划
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
