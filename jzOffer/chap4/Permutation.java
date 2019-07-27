package jzOffer.chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

/**
 * 递归解法
 *
 */
public class Permutation {

    /**
     * 固定第一个字符，递归取得首位后面的各种字符串组合；
     * 再把第一个字符与后面每一个字符交换，并同样递归获得首位后面的字符串组合；
     *递归的出口，就是只剩一个字符的时候，递归的循环过程，就是从每个子串的第二个字符开始依次与第一个字符交换，然后继续处理子串。
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() <= 0){
            return list;
        }
        permutate(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;

    }

    private void permutate(char[] str, int begin, ArrayList<String> list) {
        if (begin == str.length-1){
            String s = String.valueOf(str);
            //去除重复的字符串
            if (!list.contains(s)){
                list.add(s);
            }
            return;
        }
        //递归依次交换
        for (int i=begin;i<str.length;i++){
            swap(str,begin,i);
            permutate(str,begin+1,list);
            //回退出来后，尝试这种情况下的其他情况
            swap(str,begin,i);
        }
    }

    private void swap(char[] str, int begin, int i) {
        char temp = str[begin];
        str[begin] = str[i];
        str[i] = temp;
    }
    public static void main(String[] args) {
        Permutation a = new Permutation();
        System.out.println(a.Permutation("aab"));
    }

    /**
     * 2、字典序排列算法
     *
     * 可参考解析： http://www.cnblogs.com/pmars/archive/2013/12/04/3458289.html  （感谢作者）
     *
     * 一个全排列可看做一个字符串，字符串可有前缀、后缀。
     * 生成给定全排列的下一个排列.所谓一个的下一个就是这一个与下一个之间没有其他的。
     * 这就要求这一个与下一个有尽可能长的共同前缀，也即变化限制在尽可能短的后缀上。
     *
     * [例]839647521是1--9的排列。1—9的排列最前面的是123456789，最后面的987654321，
     * 从右向左扫描若都是增的，就到了987654321，也就没有下一个了。否则找出第一次出现下降的位置。
     *
     * 【例】 如何得到346987521的下一个
     * 1，从尾部往前找第一个P(i-1) < P(i)的位置
     * 3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
     * 最终找到6是第一个变小的数字，记录下6的位置i-1
     *
     * 2，从i位置往后找到最后一个大于6的数
     * 3 4 6 -> 9 -> 8 -> 7 5 2 1
     * 最终找到7的位置，记录位置为m
     *
     * 3，交换位置i-1和m的值
     * 3 4 7 9 8 6 5 2 1
     * 4，倒序i位置后的所有数据
     * 3 4 7 1 2 5 6 8 9
     * 则347125689为346987521的下一个排列
     *
     * @param str
     * @return
     */

    public ArrayList<String> Permutation2(String str){
        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0){
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int len = chars.length;
        while(true){
            int lIndex = len-1;
            int rIndex;
            while(lIndex>=1 && chars[lIndex-1]>=chars[lIndex]){
                lIndex--;
            }
            if(lIndex == 0)
                break;
            rIndex = lIndex;
            while(rIndex<len && chars[rIndex]>chars[lIndex-1]){
                rIndex++;
            }
            swap(chars,lIndex-1,rIndex-1);
            reverse(chars,lIndex);

            list.add(String.valueOf(chars));
        }

        return list;
    }

    private void reverse(char[] chars,int k){
        if(chars==null || chars.length<=k)
            return;
        int len = chars.length;
        for(int i=0;i<(len-k)/2;i++){
            int m = k+i;
            int n = len-1-i;
            if(m<=n){
                swap(chars,m,n);
            }
        }

    }
}

