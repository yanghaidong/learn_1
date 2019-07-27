package jzOffer.chap5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 */
public class MedianInStream {

    /**思路：
     为了保证插入新数据和取中位数的时间效率都高效，这里使用大顶堆+小顶堆的容器，并且满足：
     1、两个堆中的数据数目差不能超过1，这样可以使中位数只会出现在两个堆的交接处；
     2、大顶堆的所有数据都小于小顶堆，这样就满足了排序要求。
     * 将序列分为两个堆，一个最大堆，一个最小堆，总个数为奇数就是多的那个堆的根节点
     * 总个数是偶数就是两个堆根节点的平均数
     * @param num
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int count = 0;
    public void Insert(Integer num) {
       if (count == 0){
           maxHeap.offer(num);
       }
       //如果是奇数，插入最小堆
       else if ((count & 1) == 1){
           //必须判断插入最小堆的值必须大于最大堆的最大值
           if (num < maxHeap.peek()){
               minHeap.offer(maxHeap.poll());
               maxHeap.offer(num);
           }else {
               minHeap.offer(num);
           }
       }
       //如果是偶数就插入最大堆
        else {
            //保证插入最大堆的比最小堆的最小元素要小
           if (num > minHeap.peek()){
               maxHeap.offer(minHeap.poll());
               minHeap.offer(num);
           }else {
               maxHeap.offer(num);
           }
       }
       //记录下全局的数量
       count++;
    }

    public Double GetMedian() {
       if ((count & 1) == 1) return Double.valueOf(maxHeap.peek());
       //除以2放在外面，保证精度
       else return Double.valueOf((maxHeap.peek()+minHeap.peek()))/2;
    }

}
