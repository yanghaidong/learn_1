package jzOffer.chap6;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内的顺序不变。为简单起见，标点符号和普通字母一样处理。
 * 例如输入"I am a student."则输出"student. a am I"
 */
public class ReverseWord {
    public static String ReverseSentence(String str) {
        if (str.isEmpty() || str.length() == 0) return str;
        StringBuilder sb = new StringBuilder();
        String[] strArray = str.split(" ");
        for (int i=strArray.length-1;i>=0;i--){
            sb.append(strArray[i]);
            if (i > 0) sb.append(" ");
        }
        return sb.toString();
    }

    /**
     * 分为两个步骤（递归）
     * 将字符中的所有单词翻转
     * 将每个单词再翻转回来正常的顺序
     * @param str
     * @return
     */
    public static String reverseWords(String str) {
       if (str == null || str.length() == 0){
           return "";
       }
       char[] c = str.toCharArray();
       int len = str.length();
       reverse(c, 0, len-1);
       int low = 0;
       int high = 0;
       while (low < len){
           //分为三种情况，如果低位为空，则将索引都移动
           //若高位为空或者到头，则将高位前一位之前的单词翻转
           //否则移动高位指针
           if (c[low] == ' '){
               low++;
               high++;
           }else if (high == len || c[high] == ' '){//数组调用和索引判断的顺序不能变
               reverse(c, low, --high);
               low = ++high;
           }else {
               high++;
           }
       }
       //转化为字符串输出
       return new String(c);


    }

    private static void reverse(char[] chars, int low, int high) {
        while (low < high){
            char c = chars[high];
            chars[high] = chars[low];
            chars[low] = c;
            low++;
            high--;
        }
    }

    /**
     * 变种
     * 字符串的左旋操作是把字符串前面的若干个字符转移到字符串的尾部。
     * 比如输入字符串"abcdefg"和一个数字2，则左旋转后得到字符串"cdefgab"
     */

    public String leftRotateString1(String str, int n) {
        if (str == null || n < 0 || n > str.length()) return null;
        StringBuilder sb = new StringBuilder(str);
        sb.append(str.substring(0,n));
        return sb.substring(n,sb.length()-1);

    }

    public static String LeftRotateString(String str,int n) {
        if (str == null || n < 0 || n > str.length()) return "";
        char[] chars = str.toCharArray();
        reverse(chars, 0, n-1);
        reverse(chars, n, chars.length-1);
        reverse(chars, 0, chars.length-1);

        return new String(chars);

    }
    public static void main(String[] args) {
        System.out.println(ReverseSentence("I am a student."));
        System.out.println(reverseWords("I am a student."));
        System.out.println(LeftRotateString("abcXYZdef",3));
    }
}
