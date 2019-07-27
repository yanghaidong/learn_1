package jzOffer.chap3;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 一个链表中包含环，请找出该链表的环的入口结点。
 */
public class EntryNodeOfLoop {
    public class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
    public ListNode EntryNodeOfLoop(ListNode pHead)
    {
        if (pHead == null){
            return null;
        }
        ListNode node1 = null;
        if (isLoop(pHead) != null){
            node1 = isLoop(pHead);
        }else {
            return null;
        }
        ListNode node2 = node1;
        int len = 1;
        while (node2.next != node1){
            len++;
            node2 = node2.next;
        }
        ListNode p1 = pHead;
        ListNode p2 = pHead;
        for (int i=0;i<len;i++){
            p1 = p1.next;
        }
        while (p1 != p2){
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
    private ListNode isLoop(ListNode pHead){

        ListNode pSlow = pHead.next;
        if (pSlow == null){
            return null;
        }
        ListNode pFast = pSlow.next;
        while (pFast != null){
            if (pFast == pSlow){
                return pSlow;
            }
            pFast = pFast.next;
            pSlow = pSlow.next;
            if (pFast != pSlow){
                pFast = pFast.next;
            }
        }
        return null;
    }


    /**
     * 标准版
     * 先一快一慢判断是否有环
     * 然后从相遇节点开始，行走一周得到环的个数
     * 两个新的指针从头结点开始，一个先移动环的个数，然后同时移动直到相遇就是入口
     * @param head
     * @return
     */
    public static ListNode meetingNode(ListNode head) {
        if(head==null)
            return null;

        ListNode slow = head.next;
        if(slow==null)
            return null;

        ListNode fast = slow.next;
        while (slow != null && fast != null) {
            if(slow==fast){
                return fast;
            }
            slow=slow.next;
            fast=fast.next;

            if(fast!=slow){
                fast=fast.next;
            }
        }
        return null;
    }
    public ListNode EntryNodeOfLoop1(ListNode pHead) {
        ListNode meetingNode=meetingNode(pHead);
        if(meetingNode==null)
            return null;
//      得到环中的节点个数
        int nodesInLoop=1;
        ListNode p1=meetingNode;
        while(p1.next!=meetingNode){
            p1=p1.next;
            ++nodesInLoop;
        }
//      移动p1
        p1=pHead;
        for(int i=0;i<nodesInLoop;i++){
            p1=p1.next;
        }
//      移动p1，p2
        ListNode p2=pHead;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    /**
     * 第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
     * 第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop2(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        ListNode pfast = pHead;
        ListNode pslow = pHead;
        while (pfast.next != null && pslow.next != null){
             pfast = pfast.next.next;
             pslow = pslow.next;

             if (pfast == pslow){
                 pfast=pHead;
                 while (pslow != pfast){
                     pfast = pfast.next;
                     pslow = pslow.next;
                 }
                 return pslow;
             }
        }
        return null;
    }

    /**
     * 利用set
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop3(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode cur = pHead;
        //最后一个也要遍历到
        while (cur != null){
            //如果重复值没有添加成功，则返回false，找到第一个重复值
            if (!set.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * 利用map
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop4(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        Map<ListNode,Boolean> map = new HashMap();
        ListNode cur = pHead;
        while (cur != null){
            //map中是否有重复主键，如果重复出现第一个，则是入口
            if (map.containsKey(cur)){
                return cur;
            }
            map.put(cur,true);
            cur=cur.next;
        }
        return null;
    }
}
