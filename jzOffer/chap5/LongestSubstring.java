package jzOffer.chap5;

/**
 * ����ַ������ҳ�һ����Ĳ������ظ��ַ������ַ��������������ַ����ĳ��ȡ�
 * �����ַ�����ֻ����'a'~'z'֮����ַ����������ַ���"arabcacfr"�У���Ĳ����ظ��ַ������ַ�����"acfr"������Ϊ4
 */
public class LongestSubstring {
    public int findLongestSubstring(String str) {
        int curlen = 0;
        int maxlen = 0;
        int[] position = new int[26];
        for (int i=0;i<26;i++){
            position[i] = -1;
        }
        for (int j=0;j<str.length();j++){
            int preIndex = position[str.charAt(j)-'a'];
            int distance = j - preIndex;
            if (preIndex == -1 || distance > curlen) curlen++;
            else curlen = distance;
            //��¼��ǰ�ַ����ֵ�λ��
            position[str.charAt(j)-'a'] = j;
            if (maxlen < curlen) maxlen = curlen;

        }
        return maxlen;
    }

    /**
     * �Ż�
     * @param str
     * @return
     */
    public int findLongestSubstring1(String str) {
        int curlen = 0;
        int maxlen = 0;
        int preIndex = -1;
        int[] position = new int[26];
        for (int i=0;i<26;i++){
            position[i] = -1;
        }
        for (int j=0;j<str.length();j++){
            preIndex = Math.max(preIndex,position[str.charAt(j) - 'a']);
            //ͳһ�����������һ�γ���Ϊ��1���������ȥ��������
            curlen = j - preIndex;
            //��¼�ϴγ��ֵ�λ��
            position[str.charAt(j) - 'a'] = j;
            maxlen = Math.max(curlen,maxlen);
        }
        return maxlen;
    }
    public static void main(String[] args) {
        LongestSubstring l = new LongestSubstring();
        System.out.println(l.findLongestSubstring("arabcacfr"));
        System.out.println(l.findLongestSubstring1("arabcacfr"));
    }
}
