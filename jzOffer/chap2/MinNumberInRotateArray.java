package jzOffer.chap2;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0
 */
public class MinNumberInRotateArray {
    public int minNumberInRotateArray(int [] array) {
        if (array.length <= 0 || array == null){
            return 0;
        }
        int left = 0,right = array.length-1,mid = 0;
        //保证旋转
        while (array[left] >= array[right]){
            //左右指针相邻停止
            if (right - left == 1){
                mid = right;
                //循环终止
                break;
            }
            /**
             * 如果中间值和首尾相等，则按顺序寻找最小值
             * or mid = (left + right)/2
             */
//            mid = (left + right)/2;
            mid = left + (right - left)/2;
            if (array[left] == array[right] && array[right] == array[mid]){
                return minArray(array,left,right);
            }
            /**
             *如果中间值大于等于左边指针，则位于第一个递增数组中，最小元素位于中间元素的前面，改变左指针
             * 否则最小元素位于后数组中，最小元素位于中间数组的后面，改变右指针继续
             */
            if (array[mid] >= array[left]){
                left = mid;
            }else{
                right = mid;
            }
        }
        return array[mid];
    }

    private int minArray(int[] array, int left, int right) {
        int min = array[left];
        for (int i=left+1;i<array.length;i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        return min;
    }

    public static void main(String[] args) {
        MinNumberInRotateArray number = new MinNumberInRotateArray();
        int[] a = {3,4,5,1,2};
        System.out.println(number.minNumberInRotateArray(a));
    }
}
