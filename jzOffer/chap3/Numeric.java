package jzOffer.chap3;


/**
 * ��ʵ��һ�����������ж��ַ����Ƿ��ʾ��ֵ������������С������
 * ���磬�ַ���"+100","5e2","-123","3.1416"��"-1E-16"����ʾ��ֵ��
 * ����"12e","1a3.14","1.2.3","+-5"��"12e+4.3"�����ǡ�
 */
public class Numeric {

    public static boolean isNumeric(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        String s = String.valueOf(str);
        //?	ƥ��ǰ����ӱ��ʽ��λ�һ�Σ���ָ��һ����̰���޶�����Ҫƥ�� ? �ַ�����ʹ�� \?��
        //*	ƥ��ǰ����ӱ��ʽ��λ��Ρ�Ҫƥ�� * �ַ�����ʹ�� \*��
        return s.matches("[+-]?[0-9]*(\\.[0-9]*)?([eE][+-]?[0-9]+)?");
    }

    /**
     * @param str
     * @return
     */
    public static boolean isNumeric1(char[] str) {
        if (str == null || str.length == 0) {
            return false;
        }
        //����ֻ��1��������0-9֮��
        if (str.length == 1 && (str[0] < '0' || str[0] > '9')) {
            return false;
        }
        boolean hasDot = false;
        boolean hasE = false;
        for (int i = 0; i < str.length; i++) {
            //�ж�+-�ŵ��������
            if (str[i] == '+' || str[i] == '-') {
                //�ڶ��γ��������ţ�ǰһ���ַ�������E��e
                if (i != 0 && str[i - 1] != 'E' && str[i - 1] != 'e') return false;
            } else if (str[i] == 'E' || str[i] == 'e') {
                //e:ֻ��һ�����Һ������������==�������������һλ
                if (i == str.length - 1) return false;
                if (hasE) return false;
                hasE = true;
            } else if (str[i] == '.') {
                //ֻ�ܳ���һ�Σ�����e��E�Ժ󲻿��ܳ���
                if (hasDot || hasE) return false;
                hasDot = true;
            } else if (str[i] < '0' || str[i] > '9') {
                //����ֻ��������
                return false;
            }
        }
        return true;
    }

    /**
     * ��ָoffer
     */
    private int index = 0;

    public boolean isNumeric3(char[] str) {
        if (str.length < 1)
            return false;

        boolean flag = scanInteger(str);

        if (index < str.length && str[index] == '.') {
            index++;
            flag = scanUnsignedInteger(str) || flag;
        }

        if (index < str.length && (str[index] == 'E' || str[index] == 'e')) {
            index++;
            flag = flag && scanInteger(str);
        }

        return flag && index == str.length;

    }

    private boolean scanInteger(char[] str) {
        if (index < str.length && (str[index] == '+' || str[index] == '-') )
            index++;
        return scanUnsignedInteger(str);

    }

    private boolean scanUnsignedInteger(char[] str) {
        int start = index;
        while (index < str.length && str[index] >= '0' && str[index] <= '9')
            index++;
        return start < index; //�Ƿ��������
    }


    public static void main(String[] args) {
        char[] c = {'1','a','3','.','1','4'};
        System.out.println(isNumeric(c));
        System.out.println(isNumeric1(c));
    }
}


