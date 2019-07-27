package jzOffer.chap5;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.
 */
public class FirstOnceChar {
    /**
     * 返回索引，一个字符8个字节，所有字符一共有256种情况
     * @param str
     * @return
     */
    public int FirstNotRepeatingChar(String str) {
        if (str.isEmpty() || str.length() == 0) return -1;
        int[] map = new int[256];
        for (int i=0;i<str.length();i++){
            map[str.charAt(i)] += 1;
        }
        for (int j=0;j<str.length();j++){
            if (map[str.charAt(j)] == 1){
                return j;
            }
        }
        return -1;
    }

    /**
     * 返回第一个不重复字符
     */
    public char firstNotRepeatingChar(String str) {
        if (str == null || str.length() == 0) return '\0';
        int[] count = new int[256];

        for (int i = 0; i < str.length(); i++) {
            count[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) return str.charAt(i);
        }
        return '\0';
    }

    /**
     * 从第一个字符串中删除第二个字符串中出现过的所有字符
     */
    public String deleteFromAnother(String str, String another) {
        if (another == null || another.length() == 0){
            return str;
        }
//        int[] map = new int[256];
        boolean[] map = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<another.length();i++){
//            map[another.charAt(i)]++;
            map[another.charAt(i)] = true;
        }
        for (int j=0;j<str.length();j++){
//            if (map[str.charAt(j)] == 0){
//                sb.append(str.charAt(j));
//            }
            if (!map[str.charAt(j)]){
                sb.append(str.charAt(j));
            }
        }
        return sb.toString();
    }
    /**
     * 删除字符串中所有的重复字符
     */
    public String deleteRepeating(String str) {
        if (str.length() == 0 || str == null) return str;
        boolean[] map = new boolean[256];
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<str.length();i++){
            if (!map[str.charAt(i)]){
                sb.append(str.charAt(i));
            }
            map[str.charAt(i)] = true;
        }
        return sb.toString();
    }

    /**
     * 变位词
     */
    public boolean hasSameChar(String s1, String s2) {
        if (s1 == null || s2 == null) return false;
//        int len1 = s1.length();
//        int len2 = s2.length();
//        if (len1 != len1) return false;
//        boolean[] map = new boolean[256];
//        for (int i=0;i<len1;i++){
//            map[s1.charAt(i)] = true;
//        }
//        for (int j=0;j<len2;j++){
//            if (!map[s2.charAt(j)]){
//                return false;
//            }
//        }
//        return true;
        /*
        计数
         */
        int[] count = new int[256];
        // 统计第一个字符串
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }
        // 第二个字符串中如果有该字符，就减去
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i)]--;
        }
        // 如果是变位词，最后count数组每个位置都是0
        for (int i = 0; i < 256; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
    public static void main(String[] args) {
        FirstOnceChar f = new FirstOnceChar();
        System.out.println(f.firstNotRepeatingChar("google"));
        System.out.println(f.FirstNotRepeatingChar("google"));
        System.out.println(f.deleteFromAnother("google", "aeiou"));
        System.out.println(f.deleteRepeating("google"));
        System.out.println(f.hasSameChar("google", "eggloo"));
    }
}
