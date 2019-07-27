package jzOffer.chap2;

import java.util.LinkedList;
import java.util.Queue;

/**
 * ��������ģ��ջ
 */
public class TwoQueueImplStack {
    private Queue<Integer> queue1;
    private Queue<Integer> queue2;

    public TwoQueueImplStack(){
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }
    /**
     * �����ʱ��������ж�Ϊ�գ������1����
     * �������һ����Ϊ�գ�����벻Ϊ�յĶ���
     */
    public void push(int node){

        if (queue1.isEmpty() && queue2.isEmpty()){
            queue1.add(node);
        }else if (!queue1.isEmpty()){
            queue1.add(node);
        }else {
            queue2.add(node);
        }
        System.out.println(queue1);
    }


    /**
     * ��ջ���ж��ĸ���Ϊ�գ�����������Ԫ���Ƶ���һ������
     * @return
     */
    public int pop(){
        if (queue1.isEmpty() && queue2.isEmpty()){
            throw new RuntimeException("����Ϊ��");
        }
        if (!queue1.isEmpty()){
            while (queue1.size() > 1) {
                queue2.add(queue1.poll());
            }
            return queue1.poll();
        }else {
            while (queue2.size() > 1){
                queue1.add(queue2.poll());
            }
            return queue2.poll();
        }
    }

    public static void main(String[] args) {
        TwoQueueImplStack a = new TwoQueueImplStack();
        a.push(54);
        a.push(55);
        a.push(56);
        System.out.println(a.pop());
        System.out.println(a.pop());
        a.push(53);
        System.out.println(a.pop());
        a.push(52);
        System.out.println(a.pop());
        System.out.println(a.pop());
    }
}
