package jzOffer.chap2;

import java.util.ArrayList;
import java.util.LinkedList;

public class FromTailToHead {

    /**
     * ����һ�������ͷ�ڵ㣬��β��ͷ��ӡ����ÿ���ڵ��ֵ��
     */
    private class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * ʹ��ջ�ṹ�����룬�������
     * @param listNode
     * @return
     */
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        LinkedList<Integer> stack = new LinkedList<>();
        for (ListNode node = listNode; node != null;node = node.next){
            stack.push(node.val);
        }
        return new ArrayList<>(stack);
    }

    /**
     * �ݹ�һֱ�����һ���ſ�ʼ���
     */
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<Integer> printListFromTailToHead1(ListNode listNode) {
        if (listNode != null){
            printListFromTailToHead1(listNode.next);
            list.add(listNode.val);
        }
        return list;
    }
}
