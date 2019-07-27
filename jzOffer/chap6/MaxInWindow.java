package jzOffer.chap6;

import java.util.*;

/**
 * ����һ������ͻ������ڵĴ�С���ҳ����л�����������ֵ�����ֵ�����磬�����������{2,3,4,2,6,2,5,1}���������ڵĴ�С3����ôһ������6���������ڣ����ǵ����ֵ�ֱ�Ϊ{4,4,6,6,6,5}�� �������{2,3,4,2,6,2,5,1}�Ļ�������������6���� {[2,3,4],2,6,2,5,1}�� {2,[3,4,2],6,2,5,1}�� {2,3,[4,2,6],2,5,1}�� {2,3,4,[2,6,2],5,1}�� {2,3,4,2,[6,2,5],1}�� {2,3,4,2,6,[2,5,1]}��
 */

public class MaxInWindow {
    /**
     * ʹ�����ȶ��п������������������ֵ
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
     * ����2: ʹ��˫�˶��У�����±�
     * ��һ��˫�˶��У����е�һ��λ�ñ��浱ǰ���ڵ����ֵ�������ڻ���һ��
     * 1.�жϵ�ǰ���ֵ�Ƿ����
     * 2.�����ӵ�ֵ�Ӷ�β��ʼ�Ƚϣ������б���С��ֵ����
     */
    public static ArrayList<Integer> maxInWindow2(int[] num, int size) {
        ArrayList<Integer> list = new ArrayList<>();
        if (num == null || num.length < size || size <= 0) return list;
        Deque<Integer> deque = new LinkedList<>();
        for (int i = 0; i < num.length; i++) {
            //ѭ����֤�ȵ�ǰֵС�Ķ�����
            while (!deque.isEmpty() && num[i] >= num[deque.peekLast()]) deque.pollLast();
            //��¼λ�ò��ܳ���3����С
            if (!deque.isEmpty() && i - deque.peekFirst() >= size) deque.pollFirst();
            //���
            deque.offerLast(i);
            //
            //����ֵ�㹻��ȡ����ͷԪ�ض�Ӧ�±��ֵ
            if (i +1 >= size) list.add(num[deque.peekFirst()]);
        }
        return list;
    }

    /**
     * ��򵥵���ѯ��ʽ
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
