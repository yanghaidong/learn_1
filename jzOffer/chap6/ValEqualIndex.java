package jzOffer.chap6;
/**
 * 数组中数值和下标相等的元素。
 * 假设一个单调递增的数组里的每个元素都是整数并且是唯一的。
 * 找出数组中任意一个数值等于其下标的元素。比如在数组{-3， -1， 1， 3， 5}，数字3和它的下标相等
 */
public class ValEqualIndex {
    public int findValEqualsIndex(int[] array) {
        if (array == null) return -1;
        int low = 0;
        int high = array.length-1;
        while (low <= high){
            int mid = (low + high) >> 1;
            if (mid == array[mid]) return mid;
            //如果下标大于值，则相等的值必然在右边
            if (mid > array[mid]) low = mid +1;
            //如果下边小于值，则相等的值必然在左边
            if (mid < array[mid]) high = mid -1;
        }
        return -1;
    }
}
