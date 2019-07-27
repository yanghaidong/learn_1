package jzOffer.chap7;



/**
 * 输入一棵二叉查找树的两个结点，返回它们的最低公共祖先。
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
     * 二查平衡树中
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
