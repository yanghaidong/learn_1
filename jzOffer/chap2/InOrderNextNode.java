package jzOffer.chap2;

/**
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */
public class InOrderNextNode {
    private class TreeLinkNode{
        int val;
        TreeLinkNode left;
        TreeLinkNode right;
        TreeLinkNode next;
        public TreeLinkNode(int val){
            this.val = val;
        }
    }

    /**
     * 1.二叉树为空，则返回空；
     * 2.节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点；
     * 3.节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
     * @param pNode
     * @return
     */

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //二叉树为空，则返回空
        if (pNode == null) return null;
        //节点右孩子存在，则设置一个指针从该节点的右孩子出发，一直沿着指向左子结点的指针找到的叶子节点即为下一个节点
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }

        //节点不是根节点。如果该节点是其父节点的左孩子，则返回父节点；否则继续向上遍历其父节点的父节点，重复之前的判断，返回结果。
        while (pNode.next != null){
            if (pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }


    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
         //如果当前节点存在右子节点，则中序下一个节点为右子树最左下的节点，如果右子树没有左子结点就返回右子树根结点
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }

        //如果不存在右子节点，则回到父节点中判断，如果父节点的右子树为该节点，则继续寻找父节点
        while (pNode.next != null && pNode == pNode.next.right){
            pNode = pNode.next;
        }
        //若该节点为父节点的左孩子，则下一个中序节点就是父节点

        return pNode.next;
    }
}
