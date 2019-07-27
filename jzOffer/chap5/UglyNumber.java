package jzOffer.chap5;

/**
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。 习惯上我们把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 */
public class UglyNumber {
    /**
     * 三个指针由小到大模拟顺序前进
     * 每次同时乘以2，3，5，赋值其中最小的
     * 为了保存三个指针中的其他数，让它们前进的顺序不一样，只有被取走了才前进
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        //如果是1-6，因子就是他自身
        if (index < 7) return index;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        //保存所有因子的数组
        int [] res = new int[index];
        //1不能漏
        res[0] = 1;
        for (int i=1;i<index;++i){
            //三条线每次乘以相同的值，指针移动了才会改变，每次只取最小值
            int m2 = res[p2]*2;
            int m3 = res[p3]*3;
            int m5 = res[p5]*5;
            res[i] = Math.min(m2,Math.min(m3,m5));
            //记录后通过移动指针来保留三条线上的最小值
            if (res[i] == m2) p2++;
            if (res[i] == m3) p3++;
            if (res[i] == m5) p5++;
        }
        return res[index-1];

    }
    /**
     * 低效的方法
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution0(int index) {
        if (index < 0) return 0;
        int number = 0;
        int uglyFound = 0;
        while (uglyFound < index){
            ++number;
            if (isUgly(number)){
                ++uglyFound;
            }
        }
        return number;
    }

    private boolean isUgly(int number) {
        while (number % 2 == 0){
            number = number/2;
        }
        while (number % 3 == 0){
            number = number/3;
        }
        while (number % 5 == 0){
            number = number/5;
        }

        return number==1 ? true : false;
    }


}
