package jzOffer.chap6;

/**
 * ������Ψһ����һ�ε����֡�
 * ��һ�������г���һ������ֻ����һ��֮�⣬�������ֶ����������Σ����ҳ��Ǹ�ֻ����һ�ε�����
 */
public class FindOneOnlyOnceAndThree {
    /**
     * ͨ��һ��32λ�����鱣��������ÿ������ͬλ�ϵ��ۼӺͣ��ۼ�ֻ�м�1�ͼ�0
     * Ȼ���ÿ���������һλ��ʼ�ж�ÿһλ������
     * ����һ������Ϊ1�ı�־λ���ж�ÿ������ÿһλ�����֣�����ѭ��������ƣ���1���ۼ�
     * �������ÿһλ����ȡ��3�����Եõ�Ψһ����ÿһλ���֣�0��1��
     * ����һ����ʼΪ0������ÿ�������ƣ�Ȼ���ۼ�����
     *
     * @param numbers
     * @return
     */
    public int findNumberAppearOnlyOnce(int[] numbers) {
        if (numbers == null && numbers.length < 2) throw new RuntimeException("��Ч����");
        int[] bitSum = new int[32];
        int bitMask = 1;
        //��Ϊ�Ա�ֵ��1��ʼ
        for (int i=31;i>=0;i--){
            for (int number : numbers){
                //�������������һ����1���������������λ������2��n�η��������ж��������Ƿ�Ϊ0
                if ((number & bitMask) != 0){
                    bitSum[i] += 1;
                }
            }
            bitMask = bitMask << 1;
        }
        int result = 0;
        //��λ����λ��,ѭ���Ӹ�λ��ʼ
        for (int j=0;j<32;j++){
            //���������ƣ����ܱ�֤��һ�������ܱ�Ĩ������ζ�ŵ�λ����λ��
            result = result << 1;
            //ͨ��ȡ���Ƿ�Ϊ0���ж�Ψһ���Ķ����ƣ��ж�Ψһ
            result += bitSum[j] % 3;
        }
        return result;
    }
    public static void main(String[] args) {
        int[] a = {1, 1, 1, 4};
        FindOneOnlyOnceAndThree appearOnlyOnce = new FindOneOnlyOnceAndThree();
        System.out.println(appearOnlyOnce.findNumberAppearOnlyOnce(a));
    }
}
