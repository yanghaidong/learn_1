package jzOffer.chap3;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 不得使用库函数直接实现，无需考虑大数问题。
 */
public class Power {


    /**
     * base 为0,1；ex为0和倒数的特殊情况
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
     * 利用公式减少运算次数，分奇偶数讨论
     * 如果是偶数，每次除以2，然后给予倍乘运算，最后为1的时候，给乘初始值
     * 如果是奇数，每次除以2，
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
     * 1.全面考察指数的正负、底数是否为零等情况。
     * 2.写出指数的二进制表达，例如13表达为二进制1101。
     * 3.举例:10^1101 = 10^0001*10^0100*10^1000。
     * 4.通过&1和>>1来逐位读取1101，为1时将该位代表的乘数累乘到最终结果。
     */
    public static double Power2(double base, int n) {
        double res = 1,curr = base;
        int exponent;
        if(n>0){
            exponent = n;
        }else if(n<0){
            if(base==0)
                throw new RuntimeException("分母不能为0");
            exponent = -n;
        }else{// n==0
            return 1;// 0的0次方
        }
        while(exponent!=0){
            if((exponent&1)==1)
                res*=curr;
            curr*=curr;// 翻倍
            exponent>>=1;// 右移一位
        }
        return n>=0?res:(1/res);
    }

    /**
     * 递归做法，由上往下
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
