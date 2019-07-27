package jzOffer.chap4;


import java.util.ArrayList;
import java.util.LinkedList;


/**
 *��ʵ��һ����������֮���δ�ӡ������������һ�а��մ����ҵ�˳���ӡ���ڶ��㰴�մ��������˳���ӡ�������а��մ����ҵ�˳���ӡ���������Դ����ơ�
 */
public class PrintBinaryTreeZ {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * ����ջ��¼��ͬ����������һ����¼�����д����ң�һ����¼ż���д��ҵ���ѭ����ӡ
     * ��ӡ��һ�к󣬸ı����ҽڵ�ķ���˳���Ƚ��ȳ�
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
           ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
           if (pRoot == null) return  lists;

           LinkedList<TreeNode> stackOdd = new LinkedList<>();
           LinkedList<TreeNode> stackEven = new LinkedList<>();
           stackOdd.push(pRoot);

           //��һ����Ϊ�գ���ѭ������
           while (!stackOdd.isEmpty() || !stackEven.isEmpty()){
               ArrayList<Integer> perList = new ArrayList<>();
               if (!stackOdd.isEmpty()){
                   while (!stackOdd.isEmpty()){
                       TreeNode temp = stackOdd.pop();
                       perList.add(temp.val);

                       if (temp.left != null) stackEven.push(temp.left);
                       if (temp.right != null) stackEven.push(temp.right);
                   }
               }else {
                   while (!stackEven.isEmpty()){
                       TreeNode temp = stackEven.pop();
                       perList.add(temp.val);

                       if (temp.right != null) stackOdd.push(temp.right);
                       if (temp.left != null) stackOdd.push(temp.left);
                   }
               }
               lists.add(perList);
           }
          return lists;
    }
}
