package jzOffer.chap3;

/**
 * ��ʵ��һ����������ƥ�����'.'��'*'��������ʽ��ģʽ�е��ַ�'.'��ʾ����һ���ַ�����'*'��ʾ��ǰ����ַ����Գ�������Σ�����0�Σ���
 * �ڱ����У�ƥ����ָ�ַ����������ַ�ƥ������ģʽ�����磬�ַ���"aaa"��ģʽ"a.a"��"ab*ac*a"ƥ�䣬������"aa.a"��"ab*a"����ƥ��
 */
public class Rematch {
    // ţ��˼·
    /**
     * ��ģʽ�еĵڶ����ַ����ǡ�*��ʱ��
     *             1������ַ�����һ���ַ���ģʽ�еĵ�һ���ַ���ƥ�䣬��ô�ַ�����ģʽ������һ���ַ���Ȼ��ƥ��ʣ��ġ�
     *             2����� �ַ�����һ���ַ���ģʽ�еĵ�һ���ַ��಻ƥ�䣬ֱ�ӷ���false��
     *
     *     ����ģʽ�еĵڶ����ַ��ǡ�*��ʱ��
     *     ����ַ�����һ���ַ���ģʽ��һ���ַ���ƥ�䣬��ģʽ����2���ַ�������ƥ�䡣����ַ�����һ���ַ���ģʽ��һ���ַ�ƥ�䣬������3��ƥ�䷽ʽ��
     *             1��ģʽ����2�ַ����൱��x*�����ԣ�
     *             2���ַ�������1�ַ���ģʽ����2�ַ���
     *             3���ַ�������1�ַ���ģʽ���䣬������ƥ���ַ���һλ����Ϊ*����ƥ���λ��
     */



    /**
     * ���õݹ�ķ�ʽ��������Ҫ���ǵڶ�λ�Ƿ���*�����ڶ�λ��*����һλƥ����񣬹�ϵ����������ȿ��ǵڶ�λ
     * �ڶ�λΪ*��
     *         ǰһλƥ�䣺1���ַ�����һλ��ģʽ����   *��������һ���ַ�
     *                    2���ַ�����һλ��ģʽ����λ   ����ֻ��Ҫһ����һ���ַ�
     *                    3, �ַ������ƣ�ģʽ����λ     ������Ҫ��һ���ַ�
     *         ǰһλ��ƥ�䣺�ַ������ƣ�ģʽ����λ��*����0���ַ���
     * �ڶ�λ����: 1,��һλ��ͬ������false
     *            2����һλ��ͬ����ͬ��һλ
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
        //��Ч�Լ��飬��������ĩβ��ƥ��ɹ�
        if (s == str.length && p == pattern.length){
            return true;
        }
        //������Ҫ���ǵ�һ�������ģʽ��ǰ���꣬�ַ���û������
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
