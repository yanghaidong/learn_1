package jzOffer.chap3;

import java.util.List;

/**
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。
 * 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 注意重复的结点不保留：并不是将重复结点删除到只剩一个，而是重复结点的全部会被删除。所以
 * 链表1->2->3->3->4->4->5不是1->2->3->4->5
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
     * 最简单的方法，递归，从第一个节点每个节点一样的思路
     * 分为两种方式：和相邻节点相同，找到第一个与头节点不同的节点开始递归
     *              和相邻节点不同，保存头节点（用它指向下一个节点，下一个节点由递归得出），从它开始再递归，寻找后面的节点
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead)
    {
        if (pHead == null || pHead.next == null){
            return pHead;
        }

        //判断相宁是否相等
        if (pHead.next.val == pHead.val){
            //找到下一个节点是否与第一个节点相同
            ListNode p = pHead.next;
            while (p != null && p.val == pHead.val){
                p = p.next;
            }
            //一直找到不和头结点相同的节点，开始下一次递归
            return deleteDuplication(p);
        }else {
            //相邻节点不相等，保存当前节点，从下一个节点开始是递归
            pHead.next = deleteDuplication(pHead.next);
            return pHead;

        }
    }

    /**\
     * 以上思路的非递归实现
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
        //验证cur不为空是保证连续一样时，不为空时才能进入该循环，防止一直找不到没有找到不同数字
        while (cur != null && cur.next != null){
            if (cur.val == cur.next.val){
                int val = cur.val;
                //找到与目前第一节点不同的节点
                while (cur != null && cur.val == val){
                    cur = cur.next;
                }
                //头节点重复
                if (pre == null){ pHead = cur;}
                //否则重新连接
                else pre.next = cur;

            }else {
                pre = cur;
                cur = cur.next;
            }
        }
        return pHead;
    }
    /**\
     * 以上思路的非递归实现
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
