package jzOffer.chap6;

import java.util.LinkedList;

/**
 * 0, 1, 2...,n - 1��n�������ų�һ��ԲȦ��һ��ʼ������0��ʼ�������ԲȦ��ɾ����m�����֣�Ȼ��ӱ�ɾ�������ֺ�һλ��ʼ����������ɾ����m������...
 * �ظ�������̣�ֱ�����ֻʣһ������Ϊֹ��������ԲȦ��ʣ�µ����һ�����֡�
 */
public class LastInCircle {
    /**
     * �Լ�����һ��������������¼�������̣������Ƴ���Ӧλ�õĽڵ㣬ֱ��ֻʣ��һλ
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
       if (n <=0  || m<=0 ) return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<n;i++) list.add(i);
        int p = 0;
        while (list.size() > 1){
            //j������m+1����ΪjΪ0ʱ������pΪ1;����Ϊm-2ʱ��pΪm-1������Ĭ���л���0������
            for (int j=0;j<m-1;j++){
                p++;
                //��ͷ�Ժ��Զ�������ʼ
                if (p == list.size()) p=0;
            }
            list.remove(p);
            //���һλ���Ƴ����ٻص����
            if (p == list.size()) p = 0;
        }
        return list.get(0);
    }

    /**
     * �������ݽṹ����������߻��ζ�����ӳ��ӵ�����һ����λ
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution1(int n, int m) {
        if (n <=0 || m <= 0) return -1;
        LinkedList<Integer> list = new LinkedList<>();
        for (int i=0;i<n;i++) list.add(i);
        int removeIndex = 0;
        while (list.size() > 1){
            //�ؼ����ڻ��������������
            removeIndex = (removeIndex + m -1) % list.size();
            list.remove(removeIndex);

        }
        return list.get(0);
    }

    /**
     * ��ѧ���ɣ�Լɪ������,ʱ�临�Ӷ�Ϊo��n�����ռ临�Ӷ�Ϊo��1��
     * ��f[i]��ʾi��������Ϸ��m�˳����ʤ���ߵı�ţ����Ľ����Ȼ��f[n]��
     *
     * ���ƹ�ʽ
     *
     * f[1]=0;
     *
     * f[i]=(f[i-1]+m)%i;  (i>1)
     */
    public int lastNumInCycle(int n, int m) {
        if (n <= 0 || m <= 0) return -1;
        int last = 0;
        for (int i=2;i<=n;i++){
            last = (last + m)%i;
        }
        return last;
    }
    public static void main(String[] args) {
        LastInCircle lastInCircle = new LastInCircle();
        System.out.println(lastInCircle.LastRemaining_Solution(5, 3));
        System.out.println(lastInCircle.LastRemaining_Solution1(5,3));
    }
}
