package jzOffer.chap6;

import java.util.LinkedList;

/**
 * 0, 1, 2...,n - 1这n个数字排成一个圆圈，一开始从数字0开始，从这个圆圈里删除第m个数字；然后从被删除的数字后一位开始计数，继续删除第m个数字...
 * 重复这个过程，直到最后只剩一个数字为止。求出这个圆圈里剩下的最后一个数字。
 */
public class LastInCircle {
    /**
     * 自己设立一个环形链表，并记录遍历过程，依次移除相应位置的节点，直到只剩下一位
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
            //j计数到m+1，因为j为0时，索引p为1;索引为m-2时，p为m-1，到底默认切换到0！！！
            for (int j=0;j<m-1;j++){
                p++;
                //到头以后，自动跳到开始
                if (p == list.size()) p=0;
            }
            list.remove(p);
            //最后一位被移除，再回到最初
            if (p == list.size()) p = 0;
        }
        return list.get(0);
    }

    /**
     * 利用数据结构环形链表或者环形队列入队出队的特性一步到位
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
            //关键在于环形链表的这句操作
            removeIndex = (removeIndex + m -1) % list.size();
            list.remove(removeIndex);

        }
        return list.get(0);
    }

    /**
     * 数学规律：约瑟夫环问题,时间复杂度为o（n），空间复杂度为o（1）
     * 令f[i]表示i个人玩游戏报m退出最后胜利者的编号，最后的结果自然是f[n]。
     *
     * 递推公式
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
