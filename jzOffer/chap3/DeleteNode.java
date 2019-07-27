package jzOffer.chap3;

/**
 * �������������ͷָ���һ�����ָ�룬����һ��������O(1)ʱ����ɾ���ý�㡣����Ҫɾ���Ľ��ȷʵ��������
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
     * ����˼·���ƶ�ָ��
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
           throw new RuntimeException("ɾ��ֵ�����ڣ�");
        }

    }

    /**
     * O(1)��ʱ�临�Ӷȣ����ñ�ɾ���ڵ����ֱ���ҵ���һ���ڵ������
     * ����һ���ڵ㸲�Ǳ�ɾ���ڵ�
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

        //����ֱ���ҵ���ɾ���ڵ����һ���ڵ�
        //���Ǳ�ɾ���ڵ�û����һ���ڵ���������
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
