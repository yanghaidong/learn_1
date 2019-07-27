package jzOffer.chap5;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * ��εõ�һ���������е���λ����������������ж�����������ֵ����ô��λ������������ֵ����֮��λ���м����ֵ��������������ж���ż������ֵ����ô��λ������������ֵ����֮���м���������ƽ��ֵ��
 */
public class MedianInStream {

    /**˼·��
     Ϊ�˱�֤���������ݺ�ȡ��λ����ʱ��Ч�ʶ���Ч������ʹ�ô󶥶�+С���ѵ��������������㣺
     1���������е�������Ŀ��ܳ���1����������ʹ��λ��ֻ������������ѵĽ��Ӵ���
     2���󶥶ѵ��������ݶ�С��С���ѣ�����������������Ҫ��
     * �����з�Ϊ�����ѣ�һ�����ѣ�һ����С�ѣ��ܸ���Ϊ�������Ƕ���Ǹ��ѵĸ��ڵ�
     * �ܸ�����ż�����������Ѹ��ڵ��ƽ����
     * @param num
     */
    private PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    private int count = 0;
    public void Insert(Integer num) {
       if (count == 0){
           maxHeap.offer(num);
       }
       //�����������������С��
       else if ((count & 1) == 1){
           //�����жϲ�����С�ѵ�ֵ����������ѵ����ֵ
           if (num < maxHeap.peek()){
               minHeap.offer(maxHeap.poll());
               maxHeap.offer(num);
           }else {
               minHeap.offer(num);
           }
       }
       //�����ż���Ͳ�������
        else {
            //��֤�������ѵı���С�ѵ���СԪ��ҪС
           if (num > minHeap.peek()){
               maxHeap.offer(minHeap.poll());
               minHeap.offer(num);
           }else {
               maxHeap.offer(num);
           }
       }
       //��¼��ȫ�ֵ�����
       count++;
    }

    public Double GetMedian() {
       if ((count & 1) == 1) return Double.valueOf(maxHeap.peek());
       //����2�������棬��֤����
       else return Double.valueOf((maxHeap.peek()+minHeap.peek()))/2;
    }

}
