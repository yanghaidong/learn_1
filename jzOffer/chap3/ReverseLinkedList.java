package jzOffer.chap3;


import java.util.List;

/**
 * 输入一个链表的头结点，反转链表后，并返回反转链表的头结点。
 */
public class ReverseLinkedList {
     class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }


         /***利用三个指针操作，通过将所有指向反向
          * 最后一个节点作为头结点
          *
          * @param head
          * @return
          */
         public ListNode ReverseList(ListNode head) {
              if (head == null){
                  return null;
              }
              ListNode cur = head;
              ListNode pre = null;
              ListNode next = null;
              while (cur != null){
                 //在cur改变指向之前，先用next保存cur原来的指向,防止节点出现断链
                 next = cur.next;
                 //先让其指向空节点
                 cur.next = pre;
                 //把上个节点赋给空节点
                 pre = cur;
                 //这时候，cur的指向已经改变
                 cur = next;
              }
            return pre;
         }

         public ListNode ReverseList1(ListNode head) {
             if (head == null){
                 return null;
             }
             ListNode cur = head;
             ListNode pre = null;
             ListNode temp = null;
             ListNode newHead = null;
             while (cur != null){
                 temp = cur.next;
                 if (temp == null){
                     newHead = cur;
                 }
                 cur.next = pre;
                 pre = cur;
                 cur = temp;
             }
             return newHead;
         }

         /**
          * 递归每次改变头结点输入，作头结点和后节点的交换
          * @param head
          * @return
          */
         public ListNode ReverseList2(ListNode head) {
             if (head == null || head.next == null){
                 return head;
             }
             //递归结果为最后一个节点
             ListNode newHead = ReverseList2(head.next);
             //交换每个新头节点的指向
             ListNode pNode = head.next;
             pNode.next = head;
             //去掉头结点指向
             head.next = null;

             return newHead;
         }
     }
}
