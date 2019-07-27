package jzOffer.chap6;
/**
 * 假设某股票的价格按照时间先后顺序存储在数组中，问买卖该股票一次可能获得的最大利润是多少？
 * 如一支股票在某段时间内的价格为{9, 11, 8, 5, 7, 12, 16, 14}那么能在价格为5的时候购入并在价格为16时卖出，能获得最大利润11
 */
public class MaxDiff {
    /**
     * 扫描数组一次，时间复杂度为O(n)
     * 遍历数组，同时记录当前数值和前面所有数值的最小值，计算并记录最大差值
     * @param prices
     * @return
     */
    public int getMaxDiff(int[] prices) {
        if (prices == null || prices.length < 0){
            return 0;
        }
        //最大差值和前面的最小值
        int maxDiff = 0;
        int min = prices[0];
        for (int i=1;i<prices.length;i++){
            if (prices[i-1] < min) min = prices[i];
            int diff = prices[i]-min;
            if (maxDiff < diff) maxDiff = diff;
        }
       return maxDiff;
    }

    public static void main(String[] args) {
        int[] prices = {9, 11, 8, 5, 7, 12, 16, 14};
        MaxDiff maxDiff = new MaxDiff();
        System.out.println(maxDiff.getMaxDiff(prices));
    }
}
