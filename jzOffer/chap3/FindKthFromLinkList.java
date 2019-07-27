package jzOffer.chap3;


/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class FindKthFromLinkList {
    public class ListNode{
        int val;
        ListNode next = null;

        ListNode(int val){
            this.val = val;
        }
    }

    public ListNode FindKthToTail(ListNode head,int k) {
         if (head == null || k==0){
             return null;
         }
         int length = 1;
         ListNode p = head;
         while (p.next != null){
             length++;
             p = p.next;
         }
         if (k>length){
             return null;
         }
         ListNode node = head;
         for (int i=1;i<length-k+1;i++){
             node = node.next;
         }
         return node;
    }
    public ListNode FindKthToTail1(ListNode head,int k) {
        if (head == null || k==0){
            return null;
        }
        ListNode node = head;
        ListNode listNode = head;

        for (int i=0;i<k-1;i++){
            if (node.next == null){
                return null;
            }
            node = node.next;
        }
        ////从k开始，同时进行，保证和为k+1
        while (node.next != null){
            node = node.next;
            listNode = listNode.next;
        }

        return listNode;
    }
}
