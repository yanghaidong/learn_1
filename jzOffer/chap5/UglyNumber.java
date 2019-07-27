package jzOffer.chap5;

/**
 * ��ֻ����������2��3��5��������������Ugly Number��������6��8���ǳ�������14���ǣ���Ϊ������������7�� ϰ�������ǰ�1�����ǵ�һ���������󰴴�С�����˳��ĵ�N��������
 */
public class UglyNumber {
    /**
     * ����ָ����С����ģ��˳��ǰ��
     * ÿ��ͬʱ����2��3��5����ֵ������С��
     * Ϊ�˱�������ָ���е���������������ǰ����˳��һ����ֻ�б�ȡ���˲�ǰ��
     * @param index
     * @return
     */
    public int GetUglyNumber_Solution(int index) {
        //�����1-6�����Ӿ���������
        if (index < 7) return index;

        int p2 = 0;
        int p3 = 0;
        int p5 = 0;
        //�����������ӵ�����
        int [] res = new int[index];
        //1����©
        res[0] = 1;
        for (int i=1;i<index;++i){
            //������ÿ�γ�����ͬ��ֵ��ָ���ƶ��˲Ż�ı䣬ÿ��ֻȡ��Сֵ
            int m2 = res[p2]*2;
            int m3 = res[p3]*3;
            int m5 = res[p5]*5;
            res[i] = Math.min(m2,Math.min(m3,m5));
            //��¼��ͨ���ƶ�ָ���������������ϵ���Сֵ
            if (res[i] == m2) p2++;
            if (res[i] == m3) p3++;
            if (res[i] == m5) p5++;
        }
        return res[index-1];

    }
    /**
     * ��Ч�ķ���
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
