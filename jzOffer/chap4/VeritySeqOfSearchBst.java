package jzOffer.chap4;

/**
 * ����һ���������飬�жϸ������ǲ���ĳ�����������ĺ�������Ľ�����������������������������ֶ�������ͬ��
 */
public class VeritySeqOfSearchBst {

    /**
     * ˼·��
     * ��֪�����������������һ��ֵΪroot������������������ֵ����rootС��������ֵ����root��
     * 1��ȷ��root��
     * 2���������У���ȥroot��㣩���ҵ���һ������root��λ�ã����λ�����Ϊ���������ұ�Ϊ��������
     * 3����������������������С��root��ֵ����ֱ�ӷ���false��
     * 4���ֱ��ж����������������Ƿ����Ƕ��������������ݹ鲽��1��2��3����
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length <= 0){
            return false;
        }
        return isSearchBST(sequence,0,sequence.length-1);
    }

    private boolean isSearchBST(int[] sequence, int begin, int end) {
        //���������ȣ���ȻΪҶ�ڵ㣬���С�ڱ�Ȼ����������������������
        if (begin >= end) return true;

        int rootVal = sequence[end];
        int i = begin;
        //��֤ѭ����Խ��
        while (sequence[i] < rootVal && i < end){
            i++;
        }
        //�ҵ���һ�����ڸ��ڵ����Ϊ�ֽ��
        int bound = i;
        while (i < end){
            //��Խ������£�����С����϶�����
            if (sequence[i] < rootVal) return false;
            i++;
        }
        //�����ݹ�
        return isSearchBST(sequence,begin,bound-1) && isSearchBST(sequence,bound,end-1);
    }


    /**
     * �ǵݹ�
     * �ǵݹ�Ҳ��һ�����ڵݹ��˼�룺
     * ������һ����������С�����ȥ���������ַ�Ϊleft��right�����֣�right���ֵ�
     * ���һ���������������ĸ���Ҳ������������ֵ��������ǿ���ÿ��ֻ���������Ƿ��������
     * ���ɣ���ʹ������������������Ҳ���Կ���������������ɵ���������������������
     *
     * �����������ص���ԭ���⣬������������������������ֵ�����������ĸ�С������ʱ����������������������
     * ֻ�迴�����������������Ƿ����Ҫ�󼴿�
     */

    public boolean VerifySquenceOfBST1(int [] sequence) {
        int size = sequence.length;
        if (sequence == null || size <= 0){
            return false;
        }
        int i = 0;
        while (--size >= 0){
            while (sequence[i] < sequence[size]) i++;
            while (sequence[i] > sequence[size]) i++;
            //���ǰ����ִ�С˳��ߵ�����������С����������ѭ����ǰ��ֹ
            if (i < size) return false;
            i = 0;
        }
        return true;
    }
}
