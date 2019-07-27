package jzOffer.chap7;
/**
 * 输入一棵普通树（拥有指向父结点的指针）的两个结点，返回它们的最低公共祖先。。
 */
public class LastSameInParent {

    private class Node {
        Node parent;
        int val;

        public Node() {
            this.val = val;
        }
    }
    /**
     * 存在指向父节点的指针
     * 求出长度以后，让其中一个先移动多出来的长度，然后一起移动找到交点
     * @param a
     * @param b
     * @return
     */
    public Node findLastSameInParent(Node a, Node b) {

        int len1 = 0;
        int len2 = 0;
        Node cur1 = a;
        while (cur1 != null){
            len1++;
            cur1 = cur1.parent;
        }
        Node cur2 = b;
        while (cur2 != null){
            len2++;
            cur2 = cur2.parent;
        }
        if (len1 > len2){
            for (int i=0;i<(len1 - len2);i++){
                a = a.parent;
            }
        }
        if (len1 < len2){
            for (int i=0;i<(len2 - len1);i++){
                b = b.parent;
            }
        }
        while (a != null && b != null){
            if (a == b) return a;
            a = a.parent;
            b = b.parent;
        }
        return null;

    }
}
