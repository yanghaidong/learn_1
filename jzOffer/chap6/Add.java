package jzOffer.chap6;
/**
 * 写一个函数，求两个整数之和，
 * 要求在函数体内不得使用"+"、"-"、"x"、"÷"四则运算符号。
 */
public class Add {
    public int Add(int num1,int num2) {
        //num2表示进位不为0 则继续进位
        while (num2 != 0){
            int temp = num1 ^ num2;  //表示不进位相加，找出只有一个1的情况
            num2 = (num1 & num2) << 1;  //表示进位情况，找出都是1的情况
            num1 = temp;    //循环往复
        }

        return num1;
    }

    /**
     * 不使用新的变量交换两个变量的值
     * 加减法
     * a = a + b;
     * b = a - b;
     * a = a - b;
     * 异或
     * a = a ^ b;
     * b = a ^ b;
     * a = a ^ b;
     */


}
