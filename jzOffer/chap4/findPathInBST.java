package jzOffer.chap4;

import java.util.ArrayList;

/**
 * ����һ�Ŷ������ĸ��ڵ��һ����������ӡ���������н��ֵ�ĺ�Ϊ��������������·����·������Ϊ�����ĸ���㿪ʼ����һֱ��Ҷ����������Ľ���γ�һ��·����(ע��: �ڷ���ֵ��list�У����鳤�ȴ�����鿿ǰ)
 */
public class findPathInBST {
    public class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> arrayLists = new ArrayList<>();
        if (root == null || target < 0) return arrayLists;
        ArrayList<Integer> path = new ArrayList<>();
        preOrder(root,target,path,arrayLists);
        return arrayLists;
    }

    private void preOrder(TreeNode root, int target, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> arrayLists) {
        if (root == null) return;
        path.add(root.val);
        //�ü�����ӣ����Լ����ۻ�����
        target -= root.val;

        //û��Ҷ�ڵ㣬�͵�ͷ��
        if (root.left == null && root.right == null && target == 0){
            arrayLists.add(new ArrayList<Integer>(path));
        }
        //���ڵ�֮ǰ�����ҽڵ㶼������
        preOrder(root.left,target,path,arrayLists);
        preOrder(root.right,target,path,arrayLists);

        //ȥ���ڵ㳢���������
        path.remove(path.size()-1);
        target+=root.val;
    }

}
