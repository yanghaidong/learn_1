package jzOffer.chap5;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 * 假设字符串中只包含'a'~'z'之间的字符，例如在字符串"arabcacfr"中，最长的不含重复字符的子字符串是"acfr"，长度为4
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
            //记录当前字符出现的位置
            position[str.charAt(j)-'a'] = j;
            if (maxlen < curlen) maxlen = curlen;

        }
        return maxlen;
    }

    /**
     * 优化
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
            //统一两种情况，第一次出现为加1，其他情况去距离更大的
            curlen = j - preIndex;
            //记录上次出现的位置
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
