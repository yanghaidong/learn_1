package jzOffer.chap4;
import java.util.ArrayList;
import java.util.List;

/**
 * ���ַ����������,������������ظ�Ԫ��
 */
public class combination {

    /**
     * ��ʵ������C(n, m) ����n == str.length; m == num
     *
     * @param str �ַ�����
     * @param num ѡ�����ַ��������
     * @return C(n, m)�ļ���
     */
    public List<String> combinationAccordingToNum(String str, int num) {
        List<String> list = new ArrayList<>();
        if (str == null || str.length() <= 0 || num > str.length()){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        collect(str, num , sb , list);
        return list;
    }

    /**
     * ���������
     * @param str
     * @return
     */
    public List<String> combination(String str){
        List<String> list = new ArrayList<>();
        if (str == null || str.length() == 0){
            return list;
        }
        StringBuilder sb = new StringBuilder();
        //1���ַ����ȵ����е�λ
        for (int i=1;i<=str.length();i++){
            collect(str, i , sb, list);
        }
        return list;
    }
    private void collect(String str, int num, StringBuilder sb, List<String> list) {
        //��ʣ��0λ���������һλ������
        // ����if˳�򲻿ɽ���������C(n, n)������뵽list�У���collect("", sb, 0)ʱ��Ҫ���ж�num==0��������ж�str.length ==0�������ٵݹ�
        if (num == 0){
            //�ַ��Ѿ�ȥ��
            list.add(sb.toString());
            return;
        }
        //// ��strΪ""ʱ��ֱ�ӷ��أ���Ȼ��һ��charAt(0)�ͻ�Խ��
        if (str.length() == 0){
            return;
        }

        // ��ʽC(n, m) = C(n-1, m-1)+ C(n-1, m)
        // ��һ���ַ�������еĵ�һ���ַ�����ʣ�µ�n-1���ַ���ѡm-1���ַ�
        sb.append(str.charAt(0));
        collect(str.substring(1), num-1, sb , list);
        // ��һ���ַ���������еĵ�һ���ַ�����ʣ�µ�n-1���ַ���ѡm���ַ�
        sb.deleteCharAt(sb.length()-1);  //ȡ��ѡ�еĵ�һ���ַ�
        collect(str.substring(1), num, sb , list);

    }
    public static void main(String[] args) {
        combination c = new combination();
        System.out.println(c.combination("abcca"));
        System.out.println(c.combination("abc"));
        System.out.println(c.combinationAccordingToNum("aabbc", 2));
    }
}
