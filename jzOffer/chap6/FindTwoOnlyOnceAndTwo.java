package jzOffer.chap6;

/**
 * һ�����������������������֮�⣬���������ֶ����������Ρ���д�����ҳ�������ֻ����һ�ε����֡�
 * Ҫ��ʱ�临�Ӷ�ΪO(n)���ռ临�Ӷ�ΪO(1).
 */


public class FindTwoOnlyOnceAndTwo {
    /**
     * ���ȣ�λ�������������ʣ�������ͬ�������=0��һ������0�����������
     *
     * ����������Ԫ�ؽ���������㣬��Ϊ���ʣ������ֻ���ֹ�һ�ε����֣��������������������
     * ���ݽ���ҵ����������Ʋ�ͬ��λ����Ҳ�������Ϊ1
     * �Ը�λ�Ƿ�Ϊ1Ϊ��־�������������飬��ͬ�ı�Ȼ��ͬһ���飬��������Ȼ����һ��
     * �ٴ�������ʣ�µľ��Ǹ���
     *
     * @param array
     * @param num1
     * @param num2
     */
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if (array == null && array.length < 2) return;
        int res = 0;
        for (int i=0;i<array.length;i++){
            res ^= array[i];
        }
        //�����һ����ʱ����0����ͬʱ��1,��ζ���ҵ���һ����ͬ��λ
        int index = firstBitOfOne(res);
        for (int i=0;i<array.length;i++){
            //���ݸ�λ�����Ƿ�Ϊ1������
            if (isBitOne(array[i], index)) num1[0] ^= array[i];
            else num2[0] ^= array[i];
        }
    }

    private boolean isBitOne(int number, int index) {
        return ((number >> index) & 1)  == 1;
    }

    private int firstBitOfOne(int res) {
        //��¼����������λ��
        int index = 0;
        while ((res & 1) == 0 && index < 32){
            res = res >> 1;
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        FindTwoOnlyOnceAndTwo f = new FindTwoOnlyOnceAndTwo();
        int[] array = {2,4,3,6,3,2,5,5};
        int[] a = {0};
        int[] b = {0};
        f.FindNumsAppearOnce(array,a,b);
        System.out.println(a[0]+" "+b[0]);
    }
}
