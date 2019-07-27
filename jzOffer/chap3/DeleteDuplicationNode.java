package jzOffer.chap3;

import java.util.List;

/**
 * ��һ������������У������ظ��Ľ�㣬��ɾ�����������ظ��Ľ�㣬�ظ��Ľ�㲻��������������ͷָ�롣
 * ���磬����1->2->3->3->4->4->5 �����Ϊ 1->2->5
 * ע���ظ��Ľ�㲻�����������ǽ��ظ����ɾ����ֻʣһ���������ظ�����ȫ���ᱻɾ��������
 * ����1->2->3->3->4->4->5����1->2->3->4->5
 */
public class DeleteDuplicationNode {
    private class ListNode{
        int val;
        ListNode next = null;
        ListNode(int val){
            this.val = val;
        }
    }

    /**
     * ��򵥵ķ������ݹ飬�ӵ�һ���ڵ�ÿ���ڵ�һ����˼·
     * ��Ϊ���ַ�ʽ�������ڽڵ���ͬ���ҵ���һ����ͷ�ڵ㲻ͬ�Ľڵ㿪ʼ�ݹ�
     *              �����ڽڵ㲻ͬ������ͷ�ڵ㣨����ָ����һ���ڵ㣬��һ���ڵ��ɵݹ�ó�����������ʼ�ٵݹ飬Ѱ�Һ���Ľڵ�
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }

        //�ж������Ƿ����
        if (pHead.next.val == pHead.val){
            //�ҵ���һ���ڵ��Ƿ����һ���ڵ���ͬ
            ListNode p = pHead.next;
            while (p != null && p.val == pHead.val){
                p = p.next;
            }
            //һֱ�ҵ�����ͷ�����ͬ�Ľڵ㣬��ʼ��һ�εݹ�
            return deleteDuplication(p);
        }else {
            //���ڽڵ㲻��ȣ����浱ǰ�ڵ㣬����һ���ڵ㿪ʼ�ǵݹ�
            pHead.next = deleteDuplication(pHead.next);
            return pHead;

        }
    }

    /**\
     * ����˼·�ķǵݹ�ʵ��
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication1(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode pre = null;
        ListNode cur = pHead;
        //��֤cur��Ϊ���Ǳ�֤����һ��ʱ����Ϊ��ʱ���ܽ����ѭ������ֹһֱ�Ҳ���û���ҵ���ͬ����
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                int val = cur.val;
                //�ҵ���Ŀǰ��һ�ڵ㲻ͬ�Ľڵ�
                while (cur != null && cur.val == val){
                    cur = cur.next;
                }
                //ͷ�ڵ��ظ�
                if (pre == null){ pHead = cur;}
                //������������
                else pre.next = cur;

            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }
    /**\
     * ����˼·�ķǵݹ�ʵ��
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication2(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }
        ListNode pre = new ListNode(pHead.val-1);
        ListNode cur = pHead;
        pre.next = pHead;

        while (cur.next != null && cur != null){
            if (cur.val == cur.next.val){
                int val = cur.val;
                while (cur != null && cur.val == val){
                    cur = cur.next;
                }
                pre.next = cur;
            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pre.next;
    }
}
