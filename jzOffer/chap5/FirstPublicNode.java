package jzOffer.chap5;

import java.util.HashSet;
import java.util.LinkedList;



/**
 * �������������ҳ����ǵĵ�һ��������㡣
 */
public class FirstPublicNode {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
        }

    /**
     * ʹ��ջ����ڵ㣬Ȼ���ջ�Ƚϣ��ҵ����һ����ȵĽڵ�
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        LinkedList<ListNode> stack1 = new LinkedList<>();
        LinkedList<ListNode> stack2 = new LinkedList<>();

        while (cur1 != null){
            stack1.push(cur1);
            cur1 = cur1.next;
        }

        while (cur2 != null){
            stack2.push(cur2);
            cur2 = cur2.next;
        }
        ListNode listNode = null;
        while (!stack1.isEmpty() && !stack2.isEmpty()){
            //һ����ջ��һ��ȡԪ�����ڱȽ�
            if (stack1.peek() == stack2.pop()) listNode = stack1.pop();
                //�ҵ����һ����ȵĽڵ�
            else return listNode;
        }
        return listNode;
    }

    /**
     * ��������Set���ȴ����һ����������н�㣬Ȼ�����ڶ�������Ľ�㣬����һ�����ʧ�ܵ�ʱ��˵�������˵�һ���ظ����
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode findFirstCommonNodeSet(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        HashSet<ListNode> set = new HashSet<>();
        while (cur1 != null){
            set.add(cur1);
            cur1 = cur1.next;
        }
        while (cur2 != null){
            if (!set.add(cur2)) return cur2;
            cur2 = cur2.next;
        }
        return null;
    }

    /**
     * ����2���ȵõ���������ĳ��ȣ�
     *       �����������β�����룬�����ó����������ɲ���Ȼ����������ͬʱ�ߣ���֤����ͬʱ������ĩβ
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode firstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode cur1 = pHead1;
        ListNode cur2 = pHead2;
        int len1 = 0;
        int len2 = 0;

        while (cur1 != null){
            len1++;
            cur1 = cur1.next;
        }
        while (cur2 != null){
            len2++;
            cur2 = cur2.next;
        }
        if (len1 > len2){
            for (int i=0;i<len1-len2;i++){
                pHead1 = pHead1.next;
            }
        }
        if (len1 < len2){
            for (int i=0;i<len2-len1;i++){
                pHead2 = pHead2.next;
            }
        }
        while (pHead1 != null && pHead2 != null){
            if (pHead1 == pHead2) return pHead1;
            pHead1 = pHead1.next;
            pHead2 = pHead2.next;

        }
        return null;
    }

    /**
     * �̵ܶĴ���
     */
    public ListNode FindFirstCommonNode1(ListNode pHead1, ListNode pHead2) {
        ListNode p1 = pHead1;
        ListNode p2 = pHead2;
        while (p1 != p2) {
            p1 = (p1 == null ? pHead2 : p1.next);
            p2 = (p2 == null ? pHead1 : p2.next);
        }
        return p1;
    }
}
