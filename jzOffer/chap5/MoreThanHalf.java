package jzOffer.chap5;


import java.util.Arrays;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 */
public class MoreThanHalf {
    /**
     * 暴力解决
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        int len = array.length;
         if (array == null && len == 0){
             return 0;
         }
         //特殊情况为长度为1时，不需要对比
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
     * 排序找中位数
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution1(int [] array) {
        int len = array.length;
        if (array == null || len == 0) return 0;
        Arrays.sort(array);
        //如果存在这样的数，中位数必然是大于一半的数
        int medin = array[len/2];
        int count = 0;
        //找到它的数量
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
     * 如果有符合条件的数字，则它出现的次数比其他所有数字出现的次数和还要多。
     * 在遍历数组时保存两个值：一是数组中一个数字，一是次数。遍历下一个数字时，若它与之前保存的数字相同，则次数加1，否则次数减1；若次数为0，则保存下一个数字，并将次数置为1。遍历结束后，所保存的数字即为所求。然后再判断它是否符合条件即可。
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
     * 运用快速排序的方式找到有序数组中间的数
     * 好处在于不一定要排序结束才能出现结果，只要参照值正好在中间位置即可
     * 也要检验最后的个数
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
         * 递归方式
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
         * 循环方式
         */
        while (high > low){
            //返回快排的参照值
            int j = partition(array , low , high);
            if (j == middle) break;
            //标准值向南或者向北
            if (j > middle) high = j-1;
            if (j < middle) low = j+1;
        }
        return array[middle];
    }

    private int partition(int[] array, int low, int high) {
        //便于找到起始的位置
        int i = low;
        //定位到后面一位，保证从倒数第一位开始比较
        int j = high;
        int v = array[low];

        while (true){
            while (array[++i] < v) if (i >= high) break;
            while (array[--j] > v) if (j <= low) break;
            if (i >= j) break;
            swap(array, i , j);
        }
        //交换参照值，便于下次开始
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
