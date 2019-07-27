package jzOffer.chap6;

/**
 * 统计一个数字在排序数组中出现的次数。
 */
public class NumofK {
    /**
     * 方法一：遍历，O(n)复杂度，不推荐
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
     * 二分法找到第一个k和最后一个k，时间复杂度O(nlgn)
     * @param array
     * @param k
     * @return
     */
    public int numberOfK(int[] array, int k) {
        if (array == null || array.length == 0) return 0;
        int firstKIndex = getFirstK(array, k, 0, array.length-1);
        int lastKIndex = getLastK(array, k, 0, array.length-1);

        //当返回值都是-1的时候
        if (firstKIndex == -1 && lastKIndex == -1) return 0;
        return lastKIndex - firstKIndex +1;

    }

    private int getLastK(int[] array, int k, int low, int high) {
        while (low <= high){
            int mid = (low + high) >> 1;
            if (array[mid] > k) high = mid-1;
            else if (array[mid] < k) low = mid+1;
            //判断mid+1不越最后的界
            else if (mid+1 <= array.length-1 && array[mid+1] == k) low = mid+1;
            else return mid;
        }
        return -1;

    }

    private int getFirstK(int[] array, int k, int low, int high) {
        //递归必须判断边界条件
        if (low > high){
            return -1;
        }
        int mid = (low + high) >> 1;
        if (array[mid] < k) return getFirstK(array, k, mid+1, high);
        else if (array[mid] > k) return getFirstK(array, k, low, mid-1);
        //判断mid-1大于等于0
        //!!!!!!!索引越界必须放在前面，不能颠倒顺序
        else if (mid-1 >= 0 && array[mid-1] == k) return getFirstK(array, k, low, mid-1);
        else return mid;
    }
    /**
     * 巧妙的方法3：得到与k相邻的两个浮点数排名
     * 因为数组中元素时int型的,改为查找浮点型的值，比如找3的次数，就找2.5和3.5之间的元素个数，
     * 稍微改变二分查找的返回值就能得到数组中排名为k的方法
     */
    public int numOfK(int[] array, int k) {
        if (array == null) return 0;
        return rank(array, k + 0.5) - rank(array, k - 0.5);
    }

    // 因为数组中元素都是int型的,改为查找浮点型的值，比如要获得3的出现次数，就找2.5和3.5之间的元素个数，
    // 稍微改变二分查找的返回值就能得到数组中排名为k的方法
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
