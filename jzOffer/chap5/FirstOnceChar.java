package jzOffer.chap5;

/**
 * ��Ŀ����
 * ��һ���ַ���(0<=�ַ�������<=10000��ȫ������ĸ���)���ҵ���һ��ֻ����һ�ε��ַ�,����������λ��, ���û���򷵻� -1����Ҫ���ִ�Сд��.
 */
public class FirstOnceChar {
    /**
     * ����������һ���ַ�8���ֽڣ������ַ�һ����256�����
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
     * ���ص�һ�����ظ��ַ�
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
     * �ӵ�һ���ַ�����ɾ���ڶ����ַ����г��ֹ��������ַ�
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
     * ɾ���ַ��������е��ظ��ַ�
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
     * ��λ��
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
        ����
         */
        int[] count = new int[256];
        // ͳ�Ƶ�һ���ַ���
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i)]++;
        }
        // �ڶ����ַ���������и��ַ����ͼ�ȥ
        for (int i = 0; i < s2.length(); i++) {
            count[s2.charAt(i)]--;
        }
        // ����Ǳ�λ�ʣ����count����ÿ��λ�ö���0
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
