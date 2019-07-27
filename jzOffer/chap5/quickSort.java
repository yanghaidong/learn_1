package jzOffer.chap5;

import java.util.Arrays;

/**
 * 快速排序
 */
public class quickSort {
    /**
     * 由于我让j的移动占主动性，j先找到一个<=5的数后，i才能开始行动找>2的数。j总是会停在<=5的数字上，或者说对于len(data)>5的data，j与i总是相遇在最右的“<=标杆数”的位置上。
     * 这样做是为了便于data[j]与data[0]交换，所以让j先行；如果让i先行，那么相反的，i、j通常相遇在最左的“>标杆数”的位置上，这样不利于data[i]与data[0]交换
     * @param array
     * @param start
     * @param end
     * @return
     */
    public static int[] qsort(int[] array, int start, int end){
        //异常
        if (array == null || start > end || array.length == 0){
            return array;
        }
        //定义两个指针
        int i = start;
        int j = end;
        //概数为你需要使用的基准，选取每段数组第一个数
        int v = array[start];
        while (i < j){
            //必须先找j，顺序不能换,并且每次控制索引不能越界，不能相遇
            while (i < j && array[j] > v){
                j--;
            }
            //相遇是循坏终止的条件
            while (i < j && array[i] < v){
                i++;
            }
            if (i < j && array[i] == array[j]){
                i++;
            }else {
                //找到前后对应的两个值，即交换位置
                swap(array, i, j);
            }
        }
        //分区间递归，每个区间依次完成上述操作
        array = qsort(array, start, i-1);
        array = qsort(array, j+1, end);

        return array;

    }
    private static void swap(int[] array, int i, int j) {
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }
    /**
     * 对上面方式的改进，不需要借用变量进行交换，用本来的空间来重新赋值
     * 1．i =L; j = R; 将基准数挖出形成第一个坑a[i]。
     * 2．j--由后向前找比它小的数，找到后挖出此数填前一个坑a[i]中。
     * 3．i++由前向后找比它大的数，找到后也挖出此数填到前一个坑a[j]中。
     * 4．再重复执行2，3二步，直到i==j，将基准数填入a[i]中。
     * @param array
     * @param start
     * @param end
     */
    public static void qsort1(int[] array, int start, int end){
        if (array == null || start > end || array.length == 0){
            return;
        }
        int i = start;
        int j = end;
        int v = array[start];
        while (i < j){
            //等于的情况也包括在内
            while (i < j && array[j] >= v){
                j--;
            }
            //用之前i的位置来替换j的值，并减1越过这个数，这个必然满足条件
            if (i < j){
                array[i++] = array[j];
            }
            while (i < j && array[i] < v ){
                i++;
            }
            if (i < j){
                array[j--] = array[i];
            }

        }
        //基准放到中间
        array[i] = v;
        qsort1(array, start, j-1);
        qsort1(array, i+1, end);
    }


    public static void main(String[] args) {
        int [] arr = {10,7,2,11,3,4,1,8};

        System.out.println(Arrays.toString(qsort(arr,0,arr.length-1)));
        qsort1(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));
    }
}
