package jzOffer.chap3;

/**
 * 请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
 * 在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配
 */
public class Rematch {
    // 牛客思路
    /**
     * 当模式中的第二个字符不是“*”时：
     *             1、如果字符串第一个字符和模式中的第一个字符相匹配，那么字符串和模式都后移一个字符，然后匹配剩余的。
     *             2、如果 字符串第一个字符和模式中的第一个字符相不匹配，直接返回false。
     *
     *     而当模式中的第二个字符是“*”时：
     *     如果字符串第一个字符跟模式第一个字符不匹配，则模式后移2个字符，继续匹配。如果字符串第一个字符跟模式第一个字符匹配，可以有3种匹配方式：
     *             1、模式后移2字符，相当于x*被忽略；
     *             2、字符串后移1字符，模式后移2字符；
     *             3、字符串后移1字符，模式不变，即继续匹配字符下一位，因为*可以匹配多位；
     */



    /**
     * 采用递归的方式，由于需要考虑第二位是否是*，当第二位是*，第一位匹配与否，关系不大，因此优先考虑第二位
     * 第二位为*：
     *         前一位匹配：1，字符串移一位，模式不变   *代表多个第一个字符
     *                    2，字符串移一位，模式移两位   代表只需要一个第一个字符
     *                    3, 字符串不移，模式移两位     代表不需要第一个字符
     *         前一位不匹配：字符串不移，模式移两位，*代表0个字符串
     * 第二位不是: 1,第一位不同，返回false
     *            2，第一位相同，共同移一位
     * @param str
     * @param pattern
     * @return
     */
    public boolean match(char[] str, char[] pattern)
    {
        if (str == null || pattern == null){
            return false;
        }
        return matchRecur(str,pattern,0,0);

    }

    private boolean matchRecur(char[] str, char[] pattern, int s, int p) {
        //有效性检验，两个都到末尾，匹配成功
        if (s == str.length && p == pattern.length){
            return true;
        }
        //最先需要考虑的一种情况，模式提前走完，字符串没有走完
        if (pattern.length == p && s < str.length){
            return false;
        }
        if (p < pattern.length-1 && pattern[p+1] == '*'){
            if ((s < str.length && str[s] == pattern[p]) || s<str.length && pattern[p] == '.'){
                return matchRecur(str,pattern,s+1,p+2) || matchRecur(str,pattern,s+1,p) || matchRecur(str,pattern,s,p+2);
            }else {
                return matchRecur(str,pattern,s,p+2);
            }
        }
        if ((s < str.length && str[s] == pattern[p]) || (s < str.length && pattern[p] == '.')){
            return matchRecur(str,pattern,s+1,p+1);
        }
        return false;

    }
}
