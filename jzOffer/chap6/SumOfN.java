package jzOffer.chap6;
/**
 * ��1+2+3+...+n,
 * Ҫ����ʹ�ó˳�����for��while��if��else��switch��case�ȹؼ����Լ���Ԫ������ȡ�
 */
public class SumOfN {
    /**
     * 1+2+3..+n  = n*(n+1)/2 = n2/2 + n/2
     * @param n
     * @return
     */
    public int Sum_Solution1(int n) {
       if (n < 1) return 0;
       return (int)(Math.pow(n,2) + n) >> 1;
    }

    /**
     * ����˼·��
     * 1.�������߼���Ķ�·����ʵ�ֵݹ���ֹ�� 2.��n==0ʱ��(n>0)&&((sum+=Sum_Solution(n-1))>0)ִֻ��ǰ����жϣ�Ϊfalse��Ȼ��ֱ�ӷ���0��
     * 3.��n>0ʱ��ִ��sum+=Sum_Solution(n-1)��ʵ�ֵݹ����Sum_Solution(n)��
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int res = n;

        boolean b = (n > 0) && ((res += Sum_Solution(n-1)) > 0);
        return res;
    }
}
