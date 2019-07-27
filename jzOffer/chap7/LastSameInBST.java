package jzOffer.chap7;



/**
 * ����һ�ö����������������㣬�������ǵ���͹������ȡ�
 */
public class LastSameInBST {
    private class Node {
        private Node left, right;
        private int val;

        public Node(int val) {
            this.val = val;
        }
    }

    /**
     * ����ƽ������
     * @param root
     * @param a
     * @param b
     * @return
     */
    public Node findLastSameInBST(Node root, Node a, Node b) {
        Node cur = root;
        while (cur != null){
            if (a.val < cur.val && b.val < cur.val){
                cur = cur.left;
            }else if (a.val > cur.val && b.val > cur.val){
                cur = cur.right;
            }else {
                return cur;
            }

        }
        return null;
    }


}
