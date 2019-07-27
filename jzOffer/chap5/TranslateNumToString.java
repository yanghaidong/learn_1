package jzOffer.chap5;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个数字，我们按照如下的规则把它翻译成字符串
 >   0 -> a
 >   1 -> b
 >   2 -> c
 >   ...
 >   25 -> z
 >
 >   一个数字可能有多种翻译，比如12258有五种，分别是"bccfi", "bwfi","bczi","mcfi", "mzi".
 请实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 */
public class TranslateNumToString {
    /**
     * 从左到右的递归
     * @param n
     * @return
     */
    public List<String> translateNum(int n) {
        List<String> list = new ArrayList<>();
        if (n < 0) return list;

        String numString = String.valueOf(n);
        StringBuilder sb = new StringBuilder();
        translateToLetter(sb, list, numString.trim());
        return list;
    }

    private void translateToLetter(StringBuilder sb, List<String> list, String numString) {
        //字符被取空，跳出
        if (numString.equals("") || numString.isEmpty()){
            list.add(sb.toString());
            return;
        }
        //只取一位
        String s1 = numString.substring(0,1);
        char c1 = numToLetter(s1);
        sb.append(c1);
        translateToLetter(sb, list, numString.substring(1));
        //替换最后一位考虑其他情况
        sb.deleteCharAt(sb.length()-1);

        //取两位，保证位数大于1
        if (numString.length() > 1){
            String s2 = numString.substring(0,2);

            if (check(s2)){
                char c2 = numToLetter(s2);
                sb.append(c2);
                translateToLetter(sb, list, numString.substring(2));
                //替换最后一位
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
    /**
     * 当一次翻译两位数时，检查是否范围在10-25之间
     */
    private boolean check(String s) {
        int x = Integer.parseInt(s);
        return  x >= 10 && x <= 25;
    }
    /**
     * 数字 -> 字母的映射，a的ASCII码是97，所以0-25的数字加上97就得到了题目中的映射
     */
    private char numToLetter(String s) {
        return (char) (Integer.parseInt(s) + 97);
    }


    /**
     * 从右到左直接计数
     */
    public int getTranslateCount(int n) {
        if (n < 0) return -1;
        return Count(String.valueOf(n));
    }

    private int Count(String number) {
        int len = number.length();
        int[] count = new int[len];
        count[len-1] = 1;
        for (int i=len-2;i>=0;i--){
            int high = number.charAt(i) - '0';
            int low = number.charAt(i+1) - '0';
            int combineNum = high*10 + low;
            //联合值必须在10-25之间才满足条件
            if (combineNum >= 10 && combineNum <= 25){
                //当前索引在倒数第二位，不存在i+2，只可能多增加一种翻译的方法
                if (i == len-2) count[i] = count[i+1] + 1;
                //当前索引存在i+2，则可以通过前一个字母到达当前，或者前两个字母联合到达当前，循环往复
                else count[i] = count[i+1] + count[i+2];
            }else {
                count[i] = count[i+1];
            }
        }
        //返回从首字母开始的计数
        return count[0];
    }

    public static void main(String[] args) {
        TranslateNumToString t = new TranslateNumToString();
        System.out.println(t.translateNum(12258).size());
        System.out.println(t.getTranslateCount(12258));
    }
}

