package jzOffer.chap3;




/**
 * 输入两个单调递增的链表，输出两个链表合成后的链表.
 * 当然我们需要合成后的链表满足单调不减规则。
 */
public class MergeTwoOrderList {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 递归做法，比较简单，从头开始，每次将较小的那个节点指针移后，调用自身
     * 结束条件为其中有结束的
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        //这里的检验不太一样，允许其中一个为空,同时有利于递归
             if (list1 == null){
                 return list2;
             }
             if (list2 == null){
                 return list1;
             }
             ListNode listNode = null;
             if (list1.val > list2.val){
                 listNode = list2;
                 listNode.next = Merge(list1,list2.next);
             }else {
                 listNode = list1;
                 listNode.next = Merge(list1.next,list2);
             }
             return listNode;
    }

    /**
     * 非递归写法
     */
    public ListNode Merge1(ListNode list1,ListNode list2) {
        //这里的检验不太一样，允许其中一个为空,同时有利于递归
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode listNode = null;
        //先找到第一个较小的节点，作为头结点
        if (list1.val > list2.val){
           listNode = list2;
           list2 = list2.next;
        }else {
            listNode = list1;
            list1 = list1.next;
        }
        //循环判断,先记录头结点
        ListNode cur = listNode;
        while (list1 != null || list2 != null){
            if (list1 == null){
                cur.next = list2;
                break;
            }
            if (list2 == null){
                cur.next = list1;
                break;
            }
            if (list1.val < list2.val){
                cur.next = list1;
                cur = cur.next;
                list1 = list1.next;
            }else {
                cur.next = list2;
                cur = cur.next;
                list2 = list2.next;
            }
        }
        return listNode;
    }

}
