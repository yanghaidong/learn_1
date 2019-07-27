package jzOffer.chap3;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * һ�������а����������ҳ�������Ļ�����ڽ�㡣
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
     * ��׼��
     * ��һ��һ���ж��Ƿ��л�
     * Ȼ��������ڵ㿪ʼ������һ�ܵõ����ĸ���
     * �����µ�ָ���ͷ��㿪ʼ��һ�����ƶ����ĸ�����Ȼ��ͬʱ�ƶ�ֱ�������������
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
//      �õ����еĽڵ����
        int nodesInLoop=1;
        ListNode p1=meetingNode;
        while(p1.next!=meetingNode){
            p1=p1.next;
            ++nodesInLoop;
        }
//      �ƶ�p1
        p1=pHead;
        for(int i=0;i<nodesInLoop;i++){
            p1=p1.next;
        }
//      �ƶ�p1��p2
        ListNode p2=pHead;
        while(p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;
    }

    /**
     * ��һ�����һ������㡣�ֱ���p1��p2ָ������ͷ����p1ÿ����һ����p2ÿ���߶�����ֱ��p1==p2�ҵ��ڻ��е����㡣
     * �ڶ������һ�����ڡ����ϲ�����p1==p2ʱ��p2�������ڵ���Ϊ2x,p1�������ڵ���Ϊx,�軷����n���ڵ�,p2��p1����һȦ��2x=n+x; n=x;���Կ���p1ʵ������һ�����Ĳ���������p2ָ������ͷ����p1λ�ò��䣬p1,p2ÿ����һ��ֱ��p1==p2; ��ʱp1ָ�򻷵���ڡ�
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
     * ����set
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop3(ListNode pHead) {
        if (pHead == null){
            return null;
        }
        Set<ListNode> set = new HashSet<>();
        ListNode cur = pHead;
        //���һ��ҲҪ������
        while (cur != null){
            //����ظ�ֵû����ӳɹ����򷵻�false���ҵ���һ���ظ�ֵ
            if (!set.add(cur)){
                return cur;
            }
            cur = cur.next;
        }
        return null;
    }

    /**
     * ����map
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
            //map���Ƿ����ظ�����������ظ����ֵ�һ�����������
            if (map.containsKey(cur)){
                return cur;
            }
            map.put(cur,true);
            cur=cur.next;
        }
        return null;
    }
}
