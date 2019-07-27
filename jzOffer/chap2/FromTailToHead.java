package jzOffer.chap2;

import java.util.ArrayList;
import java.util.LinkedList;

public class FromTailToHead {

    /**
     * 输入一个链表的头节点，从尾到头打印链表每个节点的值。
     */
    private class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * 使用栈结构正序弹入，逆序输出
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
     * 递归一直到最后一个才开始添加
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
