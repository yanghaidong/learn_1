package jzOffer.chap5;

import java.util.HashSet;
import java.util.LinkedList;



/**
 * 输入两个链表，找出它们的第一个公共结点。
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
     * 使用栈保存节点，然后出栈比较，找到最后一个相等的节点
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
            //一个出栈，一个取元素用于比较
            if (stack1.peek() == stack2.pop()) listNode = stack1.pop();
                //找到最后一个相等的节点
            else return listNode;
        }
        return listNode;
    }

    /**
     * 还可以用Set，先存入第一个链表的所有结点，然后存入第二个链表的结点，当第一次添加失败的时候说明发现了第一个重复结点
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
     * 方法2：先得到两个链表的长度；
     *       让两个链表的尾部对齐，即先让长链表走若干部，然后两个链表同时走，保证它俩同时到链表末尾
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
     * 很短的代码
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
