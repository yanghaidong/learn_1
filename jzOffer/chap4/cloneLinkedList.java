package jzOffer.chap4;


/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
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
     *解题思路：
     *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     *3、拆分链表，将链表拆分为原链表和复制后的链表
     */
    public RandomListNode Clone(RandomListNode pHead)
    {
       if(pHead == null) return null;
       //复制节点和顺序
       copyList(pHead);
       //复制随机顺序
       selectRandomListNode(pHead);
       //分割链表
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
       //分成两个新链表
       RandomListNode cur = pHead;
       RandomListNode cloneHead = pHead.next;
       while (cur != null){
           RandomListNode cloneNode = cur.next;
           //原链表修改指向
           cur.next = cloneNode.next;
//           if (cloneNode.next != null){
//               cloneNode.next = cloneNode.next.next;
//           }
           //克隆链表修改指向
           cloneNode.next = cloneNode.next != null ? cloneNode.next.next : null;
           //指向原链表下一个指向，当前节点已经改变
           cur = cur.next;

       }
       return cloneHead;
    }
}
