package jzOffer.chap7;

/**
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。
 * 数值为0或者字符串不是一个合法的数值则返回0
 */
public class StrToInt {
    private static boolean valid;
    public static int StrToInt(String str) {
       if (str == null ||str.length() == 0 || str.trim().equals("")) return 0;
       boolean isNegitive = false;
       //设置number为长整型，防止太大
       long number = 0;
       for (int i=0;i<str.length();i++){
           //如果第一个符号是正负号，符号改变变量，正号不用管
           if (i == 0 && (str.charAt(i) == '-' || str.charAt(i) == '+')){
               if (str.charAt(i) == '-'){
                   isNegitive = true;
               }
               //只有一个符号，失效
               if (str.length() == 1){
                   return 0;
               }
               continue;
           }
           //如果有一个符号不是数字，直接退出
           if (str.charAt(i) <'0' || str.charAt(i) > '9'){
               return 0;
           }
           //设置符号,得出结果
           int flag = isNegitive ? -1 : 1;
           //注意：直接在原有基础上赋值,重新组合数字的技巧
           number = number*10 + flag*(str.charAt(i) - '0');
           //判断常数的上下界限
           if ((!isNegitive && number > Integer.MAX_VALUE) || (isNegitive && number < Integer.MIN_VALUE)){
               return 0;
           }

       }
        valid = true;
        return (int) number;
    }


    public static boolean flag;
    public static int StrToInt1(String str) {
        flag = false;
        //判断输入是否合法
        if (str == null || str.trim().equals("")) {
            flag = true;
            return 0;
        }
        // symbol=0,说明该数为正数;symbol=1，该数为负数;start用来区分第一位是否为符号位
        int symbol = 0;
        int start = 0;
        char[] chars = str.trim().toCharArray();
        if (chars[0] == '+') {
            start = 1;
        } else if (chars[0] == '-') {
            start = 1;
            symbol = 1;
        }
        int result = 0;
        for (int i = start; i < chars.length; i++) {
            if (chars[i] > '9' || chars[i] < '0') {
                flag = true;
                return 0;
            }
            int sum= result * 10 + (int) (chars[i] - '0');


            if((sum-(int) (chars[i] - '0'))/10!=result){
                flag=true;
                return 0;
            }

            result=result * 10 + (int) (chars[i] - '0');
            /*
             * 本人认为java热门第一判断是否溢出是错误的，举个反例
             * 当输入为value=2147483648时，在计算机内部的表示应该是-2147483648
             * 显然value>Integer.MAX_VALUE是不成立的
             */
        }
        // 注意：java中-1的n次方不能用：(-1)^n .'^'异或运算
        // 注意，当value=-2147483648时，value=-value
        result = (int) Math.pow(-1, symbol) * result;
        return result;
    }
    public static void main(String[] args) {
        System.out.println(StrToInt("123"));
        System.out.println(StrToInt("-12"));
        System.out.println(StrToInt("+12"));
        System.out.println(StrToInt("+")+ " "+ StrToInt.valid);
        System.out.println(StrToInt("0")+ " "+ StrToInt.valid);
        System.out.println(StrToInt("12345678901112")+ " "+ StrToInt.valid);
    }
}
