package jzOffer.chap6;

import java.util.ArrayList;

/**
 * 和为s的连续正数序列
 * 输入一个正数s，打印出所有何为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5 = 4+5+6 = 7+8,所有打印出三个连续的序列1~5,4~6,7~8
 */
public class ContinuousSeq {
    /**
     * 基本思路：起始位置设置两个指针1,2，比较当前两个数的和与目标值的对比
     * 如果等于则统计之间所有的数
     * 如果大于目标值，一直在移动小指针，并减去小指针对应的值
     * 如果小于目标值，在移动大指针，并加上大指针对应的值
     * 双重循环时间复杂度大
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum < 2) return lists;
        int low = 1;
        int high = 2;
        int cursum = low + high;
        //注意，最小值不可能大于和的一半，二者至少相差为1
        int mid = (sum+1)/2;
        while (low < high){
            //循环比较
            while (low < mid && cursum > sum){
                //先去除，再加1！！！
                cursum -= low;
                low++;
            }
            if (cursum == sum) lists.add(addFromSmallToBig(low, high));
            //必须先加1，再纳入计算
            high++;
            cursum += high;
        }
        return lists;

    }

    /**
     *添加之间的数
     * @param low
     * @param high
     * @return
     */
    private ArrayList<Integer> addFromSmallToBig(int low, int high) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i=low;i<=high;i++){
            list.add(i);
        }
        return list;
    }

    /**
     * 求和解法，每次循环按照数列求和的形式分别对比，比较方式类似
     * 没找到一组，移动小指针进行下一组
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence1(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum < 2) return lists;
        int small = 1;
        int big = 2;
        while (small < big){
            int curSum = (small+big)*(big - small +1)/2;
            if (curSum == sum){
                lists.add(addFromSmallToBig(small,big));
                //必不可少，因为可能循环还有其他组的数，必须要移动起始指针，否则直接中止会出现同一组或者是死循环！！！
                small++;
            }else if (curSum > sum){
                small++;
            }else {
                big++;
            }
        }
        return lists;
    }

    /**
     * 1）由于我们要找的是和为S的连续正数序列，因此这个序列是个公差为1的等差数列，而这个序列的中间值代表了平均值的大小。假设序列长度为n，那么这个序列的中间值可以通过（S / n）得到，知道序列的中间值和长度，也就不难求出这段序列了。
     * 2）满足条件的n分两种情况：
     * n为奇数时，序列中间的数正好是序列的平均值，所以条件为：(n & 1) == 1 && sum % n == 0；
     * n为偶数时，序列中间两个数的平均值是序列的平均值，而这个平均值的小数部分为0.5，所以条件为：(sum % n) * 2 == n.
     * 3）由题可知n >= 2，那么n的最大值是多少呢？我们完全可以将n从2到S全部遍历一次，但是大部分遍历是不必要的。为了让n尽可能大，我们让序列从1开始，
     * 根据等差数列的求和公式：S = (1 + n) * n / 2，得到.
     *
     * 最后举一个例子，假设输入sum = 100，我们只需遍历n = 13~2的情况（按题意应从大到小遍历），n = 8时，得到序列[9, 10, 11, 12, 13, 14, 15, 16]；n  = 5时，得到序列[18, 19, 20, 21, 22]。
     * 完整代码：时间复杂度为O(根号n)
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer> > FindContinuousSequence2(int sum) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int n = (int) Math.sqrt(2 * sum); n >= 2; n--) {
            if ((n & 1) == 1 && sum % n == 0 || (sum % n) * 2 == n) {
                ArrayList<Integer> list = new ArrayList<>();
                for (int j = 0, k = (sum / n) - (n - 1) / 2; j < n; j++, k++) {
                    list.add(k);
                }
                ans.add(list);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
        ContinuousSeq continuousSeq = new ContinuousSeq();
        System.out.println(continuousSeq.FindContinuousSequence(15));
        System.out.println(continuousSeq.FindContinuousSequence1(15));
        System.out.println(continuousSeq.FindContinuousSequence2(100));
    }
}
