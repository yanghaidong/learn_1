package jzOffer.chap5;


/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。
 * 输入一个数组,求出这个数组中的逆序对的总数
 */
public class InversePairs {
    public int InversePairs1(int [] array) {
       if (array == null || array.length == 0) return 0;
       int[] aux = new int[array.length];

       return sort(array, aux, 0, array.length-1);

    }

    private int sort(int[] array, int[] aux, int low, int high) {

        //边界
        if (low >= high) return 0;
        int mid = low + (high-low)/2;
        ///分为两个范围
        int left = sort(array, aux, low, mid);
        int right = sort(array, aux, mid+1, high);
        //传入分界点作为第一个指针默认值
        int merge = mergePairs(array, aux, low, mid, high);

        return left+right+merge;

    }

    private int mergePairs(int[] array, int[] aux, int low, int mid, int high) {
        int count = 0;
        int len = (high-low)/2;
        //mid是一个数组的最后一个值的索引
        int i = mid;
        int j = high;

        //递归起始点不是0，有边界
        for (int m=low;m<array.length;m++){
            aux[m] = array[m];
        }
        //起始点是low
        for (int k=high;k>=low;k--){
            if (i < low) array[k] = aux[j--];
            //第二个数组从mid+1开始
            else if (j < mid+1) array[k] = aux[i--];
            else if (aux[i] > aux[j]){
                //每次累加，当得到第一个数组中的一个数比第二个数组对应位置大时，因为数组有序，所以二数组对应位置之前的所有值都是满足逆序对的
                count += j - mid;
                array[k] = aux[i--];
            }else {
                array[k] = aux[j--];
            }
        }
        return count;
    }
    //设置全局变量记录数量
    private int cnt = 0;

    public int InversePairs(int[] array) {
        if (array == null || array.length == 0) return 0;

        mergeSortUp2Down(array, 0, array.length-1);
        return cnt;

    }

    /*
     * 归并排序(从上往下)
     */
    public void mergeSortUp2Down(int[] a, int start, int end) {
        if (start >= end) return;
        //右移表示除以2
        int mid = (start + end) >> 1;

        mergeSortUp2Down(a, start, mid);
        mergeSortUp2Down(a, mid+1, end);
        merge(a, start, mid, end);
    }

    /*
     * 将一个数组中的两个相邻有序区间合并成一个
     */
    public void merge(int[] a, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid+1;
        int k = 0;
        while (i <= mid && j <= end){
            if (a[i] <= a[j]){
                temp[k++] = a[i++];
            }else {
                cnt += mid - i +1;
                temp[k++] = a[j++];
            }
        }
        //其中一个结束了
        while (i <= mid){
            temp[k++] = a[i++];
        }
        while (j <= end){
            temp[k++] = a[j++];
        }
        //排序后的重新赋给相应位置的原数组
        for (int m=0;m<temp.length;m++){
            a[start+m] = temp[m];
        }

    }
    public static void main(String[] args) {
        InversePairs i = new InversePairs();
        int[]  a = {1,2,3,4,5,6,7,0};
        System.out.println(i.InversePairs(a));
        System.out.println(i.InversePairs(a));
    }
}
