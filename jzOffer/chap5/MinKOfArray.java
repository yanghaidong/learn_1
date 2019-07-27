package jzOffer.chap5;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 输入n个整数，找出其中最小的K个数。例如输入4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4,。
 */
public class MinKOfArray {
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
         int len = input.length;
         ArrayList<Integer> list = new ArrayList<>();
         if (input == null || len == 0 || k < 0 || k > len){
             return list;
         }
         select(input, k-1);
         for (int i=0;i<k;i++){
             list.add(input[i]);
         }
         return list;
    }

    private void select(int[] input, int index) {
        int i=0;
        int j=input.length-1;
        while (i<j){
            int k=partition(input,i,j);
            if (k == index) break;
            if (k > index) j=k-1;
            if (k < index) i=k+1;
        }
    }

    private int partition(int[] input, int low, int high) {
        int i=low;
        int j=high+1;
        //选取输入的第一个数而不是第0个数
        int value=input[low];
        //循环的终止条件为由以下条件控制
        while (true){
            //循环与基准值比较大小，移动指针
            while (input[--j] > value) if (j == low) break;
            while (input[++i] < value) if (i == high) break;
            //必须是大于等于的关系,不然越界
            if (i >= j) break;
            swap(input, i, j);
        }
        swap(input, low, j);
        return j;
    }

    private void swap(int[] input, int i, int j) {
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }

    /**
     * 使用Java内置的优先队列
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution1(int [] input, int k) {
        int len = input.length;
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || len == 0 || k < 0 || k > len){
            return list;
        }
        //要逆转顺序(将其更改为最大优先级队列)，只需在内联比较器中更改顺序或使用reversed作为,保证输出是从大到小
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        // 只要size大于k，不断剔除最大值，最后优先队列里只剩最小的k个
        for (int a : input){
            maxHeap.offer(a);
            if (maxHeap.size() > k){
                maxHeap.poll();
            }
        }
        list.addAll(maxHeap);
        return list;
     }

    /**
     * 最大堆实现,堆排序实现
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int [] input, int k) {
        int len = input.length;
        ArrayList<Integer> list = new ArrayList<>();
        if (input == null || len == 0 || k < 0 || k > len){
            return list;
        }
        //建立堆
        for (int i=len/2-1;i>=0;i--){
            adjustHeap(input, i, len);
        }

        //替换第一个元素并调整堆，直到取到合适数量的元素
        int N = len-1;
        // 元素交换之后，毫无疑问，最后一个元素无需再考虑排序问题了。
        // 接下来我们需要排序的，就是已经去掉了部分元素的堆了，这也是为什么此方法放在循环里的原因

        for (int j=N;j>N-k;j--){
            list.add(input[0]);
            swap(input, 0, j);
            adjustHeap(input, 0, j);
        }
        return list;
    }

    private void adjustHeap(int[] input, int i, int len) {
        int temp = input[i];
        for (int k=2*i+1;k<len;k=2*k+1){
            if (k+1<len && input[k] > input[k+1]){
                k++;
            }
            if (input[k] < temp){
                swap(input, k, i);
                i = k;
            }else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        MinKOfArray m = new MinKOfArray();
        int[] array = {4,5,1,6,2,7,3,8};
        System.out.println(m.GetLeastNumbers_Solution(array,3));
        System.out.println(m.GetLeastNumbers_Solution1(array,4));
        System.out.println(m.GetLeastNumbers_Solution2(array,4));
    }
}
