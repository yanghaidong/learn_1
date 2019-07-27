package jzOffer.chap4;


/**
 * ����һ����������ÿ���ڵ����нڵ�ֵ���Լ�����ָ�룬һ��ָ����һ���ڵ㣬��һ������ָ��ָ������һ���ڵ㣩�����ؽ��Ϊ���ƺ��������head����ע�⣬���������벻Ҫ���ز����еĽڵ����ã�������������ֱ�ӷ��ؿգ�
 */
public class cloneLinkedList {
    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    /*
     *����˼·��
     *1��������������ÿ����㣬�縴�ƽ��A�õ�A1�������A1�嵽���A���棻
     *2�����±������������Ͻ������ָ����½�㣬��A1.random = A.random.next;
     *3�����������������Ϊԭ����͸��ƺ������
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
       if(pHead == null) return null;
       //���ƽڵ��˳��
       copyList(pHead);
       //�������˳��
       selectRandomListNode(pHead);
       //�ָ�����
       return splitLsit(pHead);
    }

    private void copyList(RandomListNode pHead) {
        RandomListNode cur = pHead;
        while (cur != null){
        RandomListNode CloneNode = new RandomListNode(cur.label);
        CloneNode.next = cur.next;
        cur.next = CloneNode;
        cur = CloneNode.next;

        }
    }

    private void selectRandomListNode(RandomListNode pHead) {
        RandomListNode cur = pHead;
        while (cur != null){
            RandomListNode cloneNode = cur.next;
//            if (cur.random != null){
//
//                cloneNode.random = cur.random.next;
//            }
            cloneNode.random = cur.random != null ? cur.random.next : null;
            cur = cloneNode.next;
        }
    }

    private RandomListNode splitLsit(RandomListNode pHead){
       //�ֳ�����������
       RandomListNode cur = pHead;
       RandomListNode cloneHead = pHead.next;
       while (cur != null){
           RandomListNode cloneNode = cur.next;
           //ԭ�����޸�ָ��
           cur.next = cloneNode.next;
//           if (cloneNode.next != null){
//               cloneNode.next = cloneNode.next.next;
//           }
           //��¡�����޸�ָ��
           cloneNode.next = cloneNode.next != null ? cloneNode.next.next : null;
           //ָ��ԭ������һ��ָ�򣬵�ǰ�ڵ��Ѿ��ı�
           cur = cur.next;

       }
       return cloneHead;
    }
}
