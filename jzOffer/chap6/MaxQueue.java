package jzOffer.chap6;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ����һ�����У�ʵ��max�����õ������е����ֵ��
 * Ҫ�����С������Լ������ֵ�ķ���ʱ�临�Ӷȶ���O(1)
 */
public class MaxQueue {
    private Deque<Integer> dataQueue = new LinkedList<>();
    private Deque<Integer> maxQueue = new LinkedList<>();

    /**
     * �����һ���������ֵ�Ķ���
     * @param number
     */
    public void offer(int number) {
        dataQueue.offer(number);
        // ����Ҫ�����Ԫ�رȵ�ǰ�������ֵ���󣬴����Ԫ��
        // ����Ҫ�����Ԫ�ز�������ǰ�������ֵ���ٽ����ֵ����һ��
        if (maxQueue.isEmpty() || number > maxQueue.peekFirst()) maxQueue.offerFirst(number);
        else maxQueue.offerFirst(maxQueue.peekFirst());

    }

    public void poll() {
        //!!!ȡ���к�ջʱ��һ��Ҫ���ֵ�ж�
       if (dataQueue.isEmpty()) throw new RuntimeException("����Ϊ�գ�");
       if (maxQueue.peekFirst() == dataQueue.peekFirst()){
           maxQueue.pollFirst();
       }
       dataQueue.pollFirst();

    }

    public int max() {
        //��ֵ�жϣ�����
       if (maxQueue.isEmpty()) throw new RuntimeException("����Ϊ�գ�");
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
