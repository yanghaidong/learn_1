package jzOffer.chap4;


import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * ���ϵ��°����ӡ��������ͬһ����������������ÿһ�����һ�С�
 */
public class PrintBinaryEveryLayer {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * ˼·���������������ֱ��ʾ��ǰ�еĽڵ���Ŀ����һ�еĽڵ���Ŀ
     * ÿ��ӡһ�ε�ǰ�м�һ��ÿ���һ���ӽڵ���һ�м�1
     * ��ǰ��Ϊ0ʱ��ֵ��һ�У���һ����0
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {

        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        int toBePrinted = 1;
        int nextLevel = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        if (pRoot == null) return list;
        //����ѭ�������ÿ��ֻ��һ��
        ArrayList<Integer> perList = new ArrayList<>();
        while (!queue.isEmpty()){

            TreeNode temp = queue.poll();
            perList.add(temp.val);
            toBePrinted--;


            if (temp.left != null){
                queue.offer(temp.left);
                nextLevel++;
            }
            if (temp.right != null){
                queue.offer(temp.right);
                nextLevel++;
            }

            if (toBePrinted == 0){
                list.add(new ArrayList<Integer>(perList));
                //ֱ�Ӱ��ڴ��ַ���
                perList.clear();
                /**
                 * ���߲�������ע��
                 *
                 */
//                list.add(perList);
//                perList = new ArrayList<Integer>();
                toBePrinted = nextLevel;
                nextLevel = 0;
            }
        }

        return list;
    }

    // Ҳ�Ƿ��д�ӡ����������
    public void printEveryLayer(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int layerSize = queue.size();
            for (int i = 0; i < layerSize; i++) {
                TreeNode node = queue.poll();
                System.out.println(node.val+" ");
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            System.out.println();
        }
    }

    /**
     * ͳ�ƶ�����ÿһ��Ľڵ�����ѭ�����
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print1(TreeNode pRoot) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (pRoot == null) return lists;
        ArrayList<Integer> layerList = new ArrayList<>();
        while (!queue.isEmpty()){
            int layerSize = queue.size();
            //ÿ�ζ���ÿһ��ͳ�����ٳ�ѭ����������һ��
            for (int i=0;i<layerSize;++i){
                TreeNode temp = queue.poll();
                layerList.add(temp.val);

                if (temp.left != null) queue.offer(temp.left);
                if (temp.right != null) queue.offer(temp.right);

            }
            lists.add(new ArrayList<Integer>(layerList));
            layerList.clear();
        }
        return lists;
    }

    /**
     * �ݹ�ⷨ
     * @param pRoot
     * @return
     */
    ArrayList<ArrayList<Integer>> Print2(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        depth(pRoot,1,lists);
        return lists;
    }

    private void depth(TreeNode treeNode, int depth, ArrayList<ArrayList<Integer>> lists) {
        if (treeNode == null) return;
        //��ȸı�ʱ�����������м����µ�list
        if (depth > lists.size()){
            lists.add(new ArrayList<Integer>());
        }
        //ֱ�ӽ��ýڵ�ֵ��������list��
        lists.get(depth-1).add(treeNode.val);

        depth(treeNode.left,depth+1,lists);
        depth(treeNode.right,depth+1,lists);
    }

}
