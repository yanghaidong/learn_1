package jzOffer.chap3;




/**
 * ���������������������������������ϳɺ������.
 * ��Ȼ������Ҫ�ϳɺ���������㵥����������
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
     * �ݹ��������Ƚϼ򵥣���ͷ��ʼ��ÿ�ν���С���Ǹ��ڵ�ָ���ƺ󣬵�������
     * ��������Ϊ�����н�����
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        //����ļ��鲻̫һ������������һ��Ϊ��,ͬʱ�����ڵݹ�
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
     * �ǵݹ�д��
     */
    public ListNode Merge1(ListNode list1,ListNode list2) {
        //����ļ��鲻̫һ������������һ��Ϊ��,ͬʱ�����ڵݹ�
        if (list1 == null){
            return list2;
        }
        if (list2 == null){
            return list1;
        }
        ListNode listNode = null;
        //���ҵ���һ����С�Ľڵ㣬��Ϊͷ���
        if (list1.val > list2.val){
           listNode = list2;
           list2 = list2.next;
        }else {
            listNode = list1;
            list1 = list1.next;
        }
        //ѭ���ж�,�ȼ�¼ͷ���
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
