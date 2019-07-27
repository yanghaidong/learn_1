package jzOffer.chap5;

import java.util.ArrayList;
import java.util.List;

/**
 * ����һ�����֣����ǰ������µĹ������������ַ���
 >   0 -> a
 >   1 -> b
 >   2 -> c
 >   ...
 >   25 -> z
 >
 >   һ�����ֿ����ж��ַ��룬����12258�����֣��ֱ���"bccfi", "bwfi","bczi","mcfi", "mzi".
 ��ʵ��һ����������������һ�������ж����ֲ�ͬ�ķ��뷽����
 */
public class TranslateNumToString {
    /**
     * �����ҵĵݹ�
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
        //�ַ���ȡ�գ�����
        if (numString.equals("") || numString.isEmpty()){
            list.add(sb.toString());
            return;
        }
        //ֻȡһλ
        String s1 = numString.substring(0,1);
        char c1 = numToLetter(s1);
        sb.append(c1);
        translateToLetter(sb, list, numString.substring(1));
        //�滻���һλ�����������
        sb.deleteCharAt(sb.length()-1);

        //ȡ��λ����֤λ������1
        if (numString.length() > 1){
            String s2 = numString.substring(0,2);

            if (check(s2)){
                char c2 = numToLetter(s2);
                sb.append(c2);
                translateToLetter(sb, list, numString.substring(2));
                //�滻���һλ
                sb.deleteCharAt(sb.length() - 1);
            }
        }

    }
    /**
     * ��һ�η�����λ��ʱ������Ƿ�Χ��10-25֮��
     */
    private boolean check(String s) {
        int x = Integer.parseInt(s);
        return  x >= 10 && x <= 25;
    }
    /**
     * ���� -> ��ĸ��ӳ�䣬a��ASCII����97������0-25�����ּ���97�͵õ�����Ŀ�е�ӳ��
     */
    private char numToLetter(String s) {
        return (char) (Integer.parseInt(s) + 97);
    }


    /**
     * ���ҵ���ֱ�Ӽ���
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
            //����ֵ������10-25֮�����������
            if (combineNum >= 10 && combineNum <= 25){
                //��ǰ�����ڵ����ڶ�λ��������i+2��ֻ���ܶ�����һ�ַ���ķ���
                if (i == len-2) count[i] = count[i+1] + 1;
                //��ǰ��������i+2�������ͨ��ǰһ����ĸ���ﵱǰ������ǰ������ĸ���ϵ��ﵱǰ��ѭ������
                else count[i] = count[i+1] + count[i+2];
            }else {
                count[i] = count[i+1];
            }
        }
        //���ش�����ĸ��ʼ�ļ���
        return count[0];
    }

    public static void main(String[] args) {
        TranslateNumToString t = new TranslateNumToString();
        System.out.println(t.translateNum(12258).size());
        System.out.println(t.getTranslateCount(12258));
    }
}

