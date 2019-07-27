package jzOffer.chap3;


/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * 例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 */
public class Numeric {

    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        String s = String.valueOf(str);
        //?	匹配前面的子表达式零次或一次，或指明一个非贪婪限定符。要匹配 ? 字符，请使用 \?。
        //*	匹配前面的子表达式零次或多次。要匹配 * 字符，请使用 \*。
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    /**
     * @param str
     * @return
     */
    public static boolean isNumeric1(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        //长度只有1，必须在0-9之间
        if (str.length == 1 && (str[0] < '0' || str[0] > '9')) {
            return false;
        }
        boolean hasDot = false;
        boolean hasE = false;
        for (int i = 0; i < str.length; i++) {
            //判断+-号的特殊情况
            if (str[i] == '+' || str[i] == '-') {
                //第二次出现正负号，前一个字符必须是E，e
                if (i != 0 && str[i - 1] != 'E' && str[i - 1] != 'e') return false;
            } else if (str[i] == 'E' || str[i] == 'e') {
                //e:只有一个并且后面必须有数字==它不可能是最后一位
                if (i == str.length - 1) return false;
                if (hasE) return false;
                hasE = true;
            } else if (str[i] == '.') {
                //只能出现一次，并且e和E以后不可能出现
                if (hasDot || hasE) return false;
                hasDot = true;
            } else if (str[i] < '0' || str[i] > '9') {
                //否则只能是数字
                return false;
            }
        }
        return true;
    }

    /**
     * 剑指offer
     */
    private int index = 0;

    public boolean isNumeric3(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') )
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //是否存在整数
    }


    public static void main(String[] args) {
        char[] c = {'1','a','3','.','1','4'};
        System.out.println(isNumeric(c));
        System.out.println(isNumeric1(c));
    }
}


