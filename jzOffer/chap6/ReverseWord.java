package jzOffer.chap6;

/**
 * ����һ��Ӣ�ľ��ӣ���ת�����е��ʵ�˳�򣬵������ڵ�˳�򲻱䡣Ϊ������������ź���ͨ��ĸһ������
 * ��������"I am a student."�����"student. a am I"
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
     * ��Ϊ�������裨�ݹ飩
     * ���ַ��е����е��ʷ�ת
     * ��ÿ�������ٷ�ת����������˳��
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
           //��Ϊ��������������λΪ�գ����������ƶ�
           //����λΪ�ջ��ߵ�ͷ���򽫸�λǰһλ֮ǰ�ĵ��ʷ�ת
           //�����ƶ���λָ��
           if (c[low] == ' '){
               low++;
               high++;
           }else if (high == len || c[high] == ' '){//������ú������жϵ�˳���ܱ�
               reverse(c, low, --high);
               low = ++high;
           }else {
               high++;
           }
       }
       //ת��Ϊ�ַ������
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
     * ����
     * �ַ��������������ǰ��ַ���ǰ������ɸ��ַ�ת�Ƶ��ַ�����β����
     * ���������ַ���"abcdefg"��һ������2��������ת��õ��ַ���"cdefgab"
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
