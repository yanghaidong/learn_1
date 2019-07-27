package jzOffer.chap6;

import java.util.*;

/**
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个： {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 */

public class MaxInWindow {
    /**
     * 使用优先队列控制入队数量，输出最大值
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || size > num.length || num.length == 0) return list;
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i=0;i<num.length;i++){
            maxHeap.offer(num[i]);
            if (maxHeap.size() >= size){
                list.add(maxHeap.peek());
                maxHeap.remove(num[j++]);
            }
        }
        return list;
    }
    /**
     * 方法2: 使用双端队列，存放下标
     * 用一个双端队列，队列第一个位置保存当前窗口的最大值，当窗口滑动一次
     * 1.判断当前最大值是否过期
     * 2.新增加的值从队尾开始比较，把所有比他小的值丢掉
     */
    public static ArrayList<Integer> maxInWindow2(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) return list;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            //循环保证比当前值小的都出来
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) deque.pollLast();
            //记录位置不能超过3个大小
            if (!deque.isEmpty() && i - deque.peekFirst() >= size) deque.pollFirst();
            //入队
            deque.offerLast(i);
            //
            //索引值足够大，取出对头元素对应下标的值
            if (i +1 >= size) list.add(num[deque.peekFirst()]);
        }
        return list;
    }

    /**
     * 最简单的轮询方式
     * @param num
     * @param size
     * @return
     */
    public static ArrayList<Integer> maxInWindows1(int [] num, int size)
    {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) return list;

        int len = num.length;
        for (int i=0;i<len-size+1;i++){
            int max = num[i];
            int end = i+size;
            for (int j=i;j<end;j++){
                if (max < num[j]){
                    max = num[j];
                }
            }
            list.add(max);
        }
        return list;
    }
    public static void main(String[] args) {
        int[] a = {2,3,4,2,6,2,5,1};
        System.out.println(maxInWindows(a, 3));
        System.out.println(maxInWindow2(a, 3));
        System.out.println(maxInWindows1(a, 3));
    }
}
