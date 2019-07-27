package jzOffer.chap3;

/**
 * 给定单向链表的头指针和一个结点指针，定义一个函数在O(1)时间内删除该结点。假设要删除的结点确实在链表中
 */
public class DeleteNode {
    private class Node{
        int val;
        Node next;
        public Node(int val){
            this.val = val;
        }
    }

    /**
     * 常规思路，移动指针
     * @param first
     * @param toBeDel
     */
    public void deleteNode_2(Node first, Node toBeDel) {
        if (first == null || toBeDel == null){
            return;
        }
        if (first == toBeDel){
            first = first.next;
            return;
        }
        boolean falg = false;
        Node p = first;
        while (p != null){
            if (p.next == toBeDel){
                p.next = toBeDel.next;
                toBeDel = null;
                falg = true;
            }
            p = p.next;
        }
        if (falg){
           throw new RuntimeException("删除值不存在！");
        }

    }

    /**
     * O(1)的时间复杂度，利用被删除节点可以直接找到下一个节点的特性
     * 用下一个节点覆盖被删除节点
     * @param first
     * @param toBeDel
     */
    public static void deleteNode_1(Node first, Node toBeDel) {
        if (first == null || toBeDel == null){
            return;
        }
        if (first == toBeDel){
            first = first.next;
            return;
        }

        //可以直接找到被删除节点的下一个节点
        //考虑被删除节点没有下一个节点的特殊情况
        if (toBeDel.next != null){
            Node p = toBeDel.next;
            toBeDel.val = p.val;
            toBeDel.next = p.next;
        }else {
            Node cur = first;
            if (cur != null){
                cur = cur.next;
            }
            cur = null;
        }

    }
}
