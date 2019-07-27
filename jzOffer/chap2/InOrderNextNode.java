package jzOffer.chap2;

/**
 * ����һ�������������е�һ����㣬���ҳ��������˳�����һ����㲢�ҷ��ء�ע�⣬���еĽ�㲻�����������ӽ�㣬ͬʱ����ָ�򸸽���ָ�롣
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
     * 1.������Ϊ�գ��򷵻ؿգ�
     * 2.�ڵ��Һ��Ӵ��ڣ�������һ��ָ��Ӹýڵ���Һ��ӳ�����һֱ����ָ�����ӽ���ָ���ҵ���Ҷ�ӽڵ㼴Ϊ��һ���ڵ㣻
     * 3.�ڵ㲻�Ǹ��ڵ㡣����ýڵ����丸�ڵ�����ӣ��򷵻ظ��ڵ㣻����������ϱ����丸�ڵ�ĸ��ڵ㣬�ظ�֮ǰ���жϣ����ؽ����
     * @param pNode
     * @return
     */

    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        //������Ϊ�գ��򷵻ؿ�
        if (pNode == null) return null;
        //�ڵ��Һ��Ӵ��ڣ�������һ��ָ��Ӹýڵ���Һ��ӳ�����һֱ����ָ�����ӽ���ָ���ҵ���Ҷ�ӽڵ㼴Ϊ��һ���ڵ�
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }

        //�ڵ㲻�Ǹ��ڵ㡣����ýڵ����丸�ڵ�����ӣ��򷵻ظ��ڵ㣻����������ϱ����丸�ڵ�ĸ��ڵ㣬�ظ�֮ǰ���жϣ����ؽ����
        while (pNode.next != null){
            if (pNode.next.left == pNode) return pNode.next;
            pNode = pNode.next;
        }
        return null;
    }


    public TreeLinkNode GetNext1(TreeLinkNode pNode) {
         //�����ǰ�ڵ�������ӽڵ㣬��������һ���ڵ�Ϊ�����������µĽڵ㣬���������û�����ӽ��ͷ��������������
        if (pNode.right != null){
            pNode = pNode.right;
            while (pNode.left != null){
                pNode = pNode.left;
            }
            return pNode;
        }

        //������������ӽڵ㣬��ص����ڵ����жϣ�������ڵ��������Ϊ�ýڵ㣬�����Ѱ�Ҹ��ڵ�
        while (pNode.next != null && pNode == pNode.next.right){
            pNode = pNode.next;
        }
        //���ýڵ�Ϊ���ڵ�����ӣ�����һ������ڵ���Ǹ��ڵ�

        return pNode.next;
    }
}
