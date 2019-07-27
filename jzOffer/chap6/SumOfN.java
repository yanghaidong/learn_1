package jzOffer.chap6;
/**
 * 求1+2+3+...+n,
 * 要求不能使用乘除法、for、while、if、else、switch、case等关键词以及三元运算符等。
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
     * 解题思路：
     * 1.需利用逻辑与的短路特性实现递归终止。 2.当n==0时，(n>0)&&((sum+=Sum_Solution(n-1))>0)只执行前面的判断，为false，然后直接返回0；
     * 3.当n>0时，执行sum+=Sum_Solution(n-1)，实现递归计算Sum_Solution(n)。
     * @param n
     * @return
     */
    public int Sum_Solution(int n) {
        int res = n;

        boolean b = (n > 0) && ((res += Sum_Solution(n-1)) > 0);
        return res;
    }
}
