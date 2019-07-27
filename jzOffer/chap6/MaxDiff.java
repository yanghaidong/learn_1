package jzOffer.chap6;
/**
 * ����ĳ��Ʊ�ļ۸���ʱ���Ⱥ�˳��洢�������У��������ù�Ʊһ�ο��ܻ�õ���������Ƕ��٣�
 * ��һ֧��Ʊ��ĳ��ʱ���ڵļ۸�Ϊ{9, 11, 8, 5, 7, 12, 16, 14}��ô���ڼ۸�Ϊ5��ʱ���벢�ڼ۸�Ϊ16ʱ�������ܻ���������11
 */
public class MaxDiff {
    /**
     * ɨ������һ�Σ�ʱ�临�Ӷ�ΪO(n)
     * �������飬ͬʱ��¼��ǰ��ֵ��ǰ��������ֵ����Сֵ�����㲢��¼����ֵ
     * @param prices
     * @return
     */
    public int getMaxDiff(int[] prices) {
        if (prices == null || prices.length < 0){
            return 0;
        }
        //����ֵ��ǰ�����Сֵ
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
