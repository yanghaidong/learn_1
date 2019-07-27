package jzOffer.chap6;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 定义一个队列，实现max方法得到队列中的最大值。
 * 要求入列、出列以及邱最大值的方法时间复杂度都是O(1)
 */
public class MaxQueue {
    private Deque<Integer> dataQueue = new LinkedList<>();
    private Deque<Integer> maxQueue = new LinkedList<>();

    /**
     * 另外加一个保存最大值的队列
     * @param number
     */
    public void offer(int number) {
        dataQueue.offer(number);
        // 即将要存入的元素比当前队列最大值还大，存入该元素
        // 即将要存入的元素不超过当前队列最大值，再将最大值存入一次
        if (maxQueue.isEmpty() || number > maxQueue.peekFirst()) maxQueue.offerFirst(number);
        else maxQueue.offerFirst(maxQueue.peekFirst());

    }

    public void poll() {
        //!!!取队列和栈时，一定要最空值判断
       if (dataQueue.isEmpty()) throw new RuntimeException("队列为空！");
       if (maxQueue.peekFirst() == dataQueue.peekFirst()){
           maxQueue.pollFirst();
       }
       dataQueue.pollFirst();

    }

    public int max() {
        //空值判断！！！
       if (maxQueue.isEmpty()) throw new RuntimeException("队列为空！");
       return maxQueue.peekFirst();
    }
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.offer(2);
        maxQueue.offer(3);
        maxQueue.offer(4);
        maxQueue.offer(2);
        maxQueue.offer(6);
        maxQueue.offer(2);
        maxQueue.offer(5);
        maxQueue.offer(1);

        System.out.println(maxQueue.max());
        maxQueue.poll();
        maxQueue.poll();
        maxQueue.poll();
        maxQueue.poll();
        System.out.println(maxQueue.max());
        maxQueue.poll();
        System.out.println(maxQueue.max());
        maxQueue.poll();
        System.out.println(maxQueue.max());

    }
}
