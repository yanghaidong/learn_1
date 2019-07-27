package jzOffer.chap3;


import java.util.List;

/**
 * ����һ�������ͷ��㣬��ת����󣬲����ط�ת�����ͷ��㡣
 */
public class ReverseLinkedList {
     class ListNode {
         int val;
         ListNode next = null;

         ListNode(int val) {
             this.val = val;
         }


         /***��������ָ�������ͨ��������ָ����
          * ���һ���ڵ���Ϊͷ���
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
                 //��cur�ı�ָ��֮ǰ������next����curԭ����ָ��,��ֹ�ڵ���ֶ���
                 next = cur.next;
                 //������ָ��սڵ�
                 cur.next = pre;
                 //���ϸ��ڵ㸳���սڵ�
                 pre = cur;
                 //��ʱ��cur��ָ���Ѿ��ı�
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
          * �ݹ�ÿ�θı�ͷ������룬��ͷ���ͺ�ڵ�Ľ���
          * @param head
          * @return
          */
         public ListNode ReverseList2(ListNode head) {
             if (head == null || head.next == null){
                 return head;
             }
             //�ݹ���Ϊ���һ���ڵ�
             ListNode newHead = ReverseList2(head.next);
             //����ÿ����ͷ�ڵ��ָ��
             ListNode pNode = head.next;
             pNode.next = head;
             //ȥ��ͷ���ָ��
             head.next = null;

             return newHead;
         }
     }
}
