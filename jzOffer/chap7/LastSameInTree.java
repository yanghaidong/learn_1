package jzOffer.chap7;



import java.util.LinkedList;
import java.util.List;

/**
 * ����һ����ͨ����������㣬�������ǵ���͹������ȡ�
 */
public class LastSameInTree {
    private class Node {
        List<Node> children;
        int val;
    }

    /**
     * �ݹ��γ����������Ӹ��ڵ㿪ʼ����ͬ�Ľڵ�
     * @param root
     * @param a
     * @param b
     * @return
     */
    public Node findLastSame(Node root, Node a, Node b) {
        if (root == null || a == null || b == null) return root;
        LinkedList<Node> path1 = new LinkedList<>();
        LinkedList<Node> path2 = new LinkedList<>();
        //�ֱ���a��bΪ�յ�
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
        //���û���ҵ�Ŀ��ڵ㣬�����Ƴ������Ա��·��
        path.removeLast();
        return false;
    }
}
