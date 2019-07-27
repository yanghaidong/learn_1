package jzOffer.chap3;

/**
 * ����һ��double���͵ĸ�����base��int���͵�����exponent����base��exponent�η���
 * ����ʹ�ÿ⺯��ֱ��ʵ�֣����迼�Ǵ������⡣
 */
public class Power {


    /**
     * base Ϊ0,1��exΪ0�͵������������
     * @param base
     * @param exponent
     * @return
     */
    public static double Power1(double base, int exponent) {
        double result = 1.0;
        if (base == 0.0 ){
            return 0.0;
        }
        if (base == 1.0){
            return base;
        }
        if (exponent == 0){
            return 1.0;
        }
        int expon = Math.abs(exponent);
        for (int i=0;i<expon;i++){
            result*=base;
        }
        if (exponent < 0){
            return 1.0/result;
        }
        return result;
    }

    /**
     * ���ù�ʽ�����������������ż������
     * �����ż����ÿ�γ���2��Ȼ����豶�����㣬���Ϊ1��ʱ�򣬸��˳�ʼֵ
     * �����������ÿ�γ���2��
     * @param base
     * @param exponent
     * @return
     */
    public static double Power(double base, int exponent) {
        double result = 1.0;
        if (base == 0 ){
            return 0.0;
        }
        if (base == 1.0){
            return base;
        }
        if (exponent == 0){
            return 1.0;
        }
        int exoon = Math.abs(exponent);
        while (exoon != 0){
            if ((exoon & 1) == 1){
                result*=base;
            }
            base*=base;
            exoon = exoon >> 1;
        }
        return exponent > 0 ? result : 1.0/result;
    }

    /**
     * 1.ȫ�濼��ָ���������������Ƿ�Ϊ��������
     * 2.д��ָ���Ķ����Ʊ�����13���Ϊ������1101��
     * 3.����:10^1101 = 10^0001*10^0100*10^1000��
     * 4.ͨ��&1��>>1����λ��ȡ1101��Ϊ1ʱ����λ����ĳ����۳˵����ս����
     */
    public static double Power2(double base, int n) {
        double res = 1,curr = base;
        int exponent;
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("��ĸ����Ϊ0");
            exponent = -n;
        }else{// n==0
            return 1;// 0��0�η�
        }
        while(exponent!=0){
            if((exponent&1)==1)
                res*=curr;
            curr*=curr;// ����
            exponent>>=1;// ����һλ
        }
        return n>=0?res:(1/res);
    }

    /**
     * �ݹ���������������
     * @param base
     * @param exponent
     * @return
     */
    private static double powerUnsigned(double base, int exponent) {
        if (exponent == 0) {
            return 1;
        }
        if (exponent == 1) {
            return base;
        }
        double result = powerUnsigned(base,exponent >> 1);
        result*=result;
        if ((exponent & 1) == 1){
            result*=base;
        }
        return result;
    }

    public static double power_1(double base, int exponent) {
        if (base == 0) {
            return 0;
        }
        int positiveExponent = Math.abs(exponent);
        double result =  powerUnsigned(base,positiveExponent);
        return exponent < 0 ? 1 / result : result;
    }
    public static void main(String[] args) {
        System.out.println(Power1(2.0, 0));
        System.out.println(Power(2.0,5));
        System.out.println(power_1(2.0,5));
     }

}
