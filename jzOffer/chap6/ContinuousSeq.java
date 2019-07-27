package jzOffer.chap6;

import java.util.ArrayList;

/**
 * ��Ϊs��������������
 * ����һ������s����ӡ�����к�Ϊs�������������У����ٺ�������������
 * ��������15������1+2+3+4+5 = 4+5+6 = 7+8,���д�ӡ����������������1~5,4~6,7~8
 */
public class ContinuousSeq {
    /**
     * ����˼·����ʼλ����������ָ��1,2���Ƚϵ�ǰ�������ĺ���Ŀ��ֵ�ĶԱ�
     * ���������ͳ��֮�����е���
     * �������Ŀ��ֵ��һֱ���ƶ�Сָ�룬����ȥСָ���Ӧ��ֵ
     * ���С��Ŀ��ֵ�����ƶ���ָ�룬�����ϴ�ָ���Ӧ��ֵ
     * ˫��ѭ��ʱ�临�Ӷȴ�
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        if (sum < 2) return lists;
        int low = 1;
        int high = 2;
        int cursum = low + high;
        //ע�⣬��Сֵ�����ܴ��ں͵�һ�룬�����������Ϊ1
        int mid = (sum+1)/2;
        while (low < high){
            //ѭ���Ƚ�
            while (low < mid && cursum > sum){
                //��ȥ�����ټ�1������
                cursum -= low;
                low++;
            }
            if (cursum == sum) lists.add(addFromSmallToBig(low, high));
            //�����ȼ�1�����������
            high++;
            cursum += high;
        }
        return lists;

    }

    /**
     *���֮�����
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
     * ��ͽⷨ��ÿ��ѭ������������͵���ʽ�ֱ�Աȣ��ȽϷ�ʽ����
     * û�ҵ�һ�飬�ƶ�Сָ�������һ��
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
                //�ز����٣���Ϊ����ѭ���������������������Ҫ�ƶ���ʼָ�룬����ֱ����ֹ�����ͬһ���������ѭ��������
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
     * 1����������Ҫ�ҵ��Ǻ�ΪS�������������У������������Ǹ�����Ϊ1�ĵȲ����У���������е��м�ֵ������ƽ��ֵ�Ĵ�С���������г���Ϊn����ô������е��м�ֵ����ͨ����S / n���õ���֪�����е��м�ֵ�ͳ��ȣ�Ҳ�Ͳ��������������ˡ�
     * 2������������n�����������
     * nΪ����ʱ�������м�������������е�ƽ��ֵ����������Ϊ��(n & 1) == 1 && sum % n == 0��
     * nΪż��ʱ�������м���������ƽ��ֵ�����е�ƽ��ֵ�������ƽ��ֵ��С������Ϊ0.5����������Ϊ��(sum % n) * 2 == n.
     * 3�������֪n >= 2����ôn�����ֵ�Ƕ����أ�������ȫ���Խ�n��2��Sȫ������һ�Σ����Ǵ󲿷ֱ����ǲ���Ҫ�ġ�Ϊ����n�����ܴ����������д�1��ʼ��
     * ���ݵȲ����е���͹�ʽ��S = (1 + n) * n / 2���õ�.
     *
     * ����һ�����ӣ���������sum = 100������ֻ�����n = 13~2�������������Ӧ�Ӵ�С��������n = 8ʱ���õ�����[9, 10, 11, 12, 13, 14, 15, 16]��n  = 5ʱ���õ�����[18, 19, 20, 21, 22]��
     * �������룺ʱ�临�Ӷ�ΪO(����n)
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
