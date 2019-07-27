package jzOffer.chap7;



import java.util.LinkedList;
import java.util.List;

/**
 * 输入一棵普通树的两个结点，返回它们的最低公共祖先。
 */
public class LastSameInTree {
    private class Node {
        List<Node> children;
        int val;
    }

    /**
     * 递归形成两个链表，从根节点开始找相同的节点
     * @param root
     * @param a
     * @param b
     * @return
     */
    public Node findLastSame(Node root, Node a, Node b) {
        if (root == null || a == null || b == null) return root;
        LinkedList<Node> path1 = new LinkedList<>();
        LinkedList<Node> path2 = new LinkedList<>();
        //分别以a，b为终点
        collectNode(root, a, path1);
        collectNode(root, b, path2);
        return getLastSameNode(path1, path2);
     }

    private Node getLastSameNode(LinkedList<Node> path1, LinkedList<Node> path2) {
        while (!path1.isEmpty() && !path2.isEmpty()){
            if (path1.peekFirst() == path2.pollFirst()){
                return path1.pollFirst();
            }
        }
        return null;
    }

    private boolean collectNode(Node root, Node node, LinkedList<Node> path) {
        if (root == node) return true;
        path.add(root);
        for (Node child : root.children){
            if (collectNode(child, node, path)) return true;
        }
        //如果没有找到目标节点，则先移除，尝试别的路径
        path.removeLast();
        return false;
    }
}
