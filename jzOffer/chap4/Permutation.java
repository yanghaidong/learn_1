package jzOffer.chap4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * ����һ���ַ���,���ֵ����ӡ�����ַ������ַ����������С����������ַ���abc,���ӡ�����ַ�a,b,c�������г����������ַ���abc,acb,bac,bca,cab��cba��
 */

/**
 * �ݹ�ⷨ
 *
 */
public class Permutation {

    /**
     * �̶���һ���ַ����ݹ�ȡ����λ����ĸ����ַ�����ϣ�
     * �ٰѵ�һ���ַ������ÿһ���ַ���������ͬ���ݹ�����λ������ַ�����ϣ�
     *�ݹ�ĳ��ڣ�����ֻʣһ���ַ���ʱ�򣬵ݹ��ѭ�����̣����Ǵ�ÿ���Ӵ��ĵڶ����ַ���ʼ�������һ���ַ�������Ȼ����������Ӵ���
     * @param str
     * @return
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> list = new ArrayList<>();
        if (str == null || str.length() <= 0){
            return list;
        }
        permutate(str.toCharArray(),0,list);
        Collections.sort(list);
        return list;

    }

    private void permutate(char[] str, int begin, ArrayList<String> list) {
        if (begin == str.length-1){
            String s = String.valueOf(str);
            //ȥ���ظ����ַ���
            if (!list.contains(s)){
                list.add(s);
            }
            return;
        }
        //�ݹ����ν���
        for (int i=begin;i<str.length;i++){
            swap(str,begin,i);
            permutate(str,begin+1,list);
            //���˳����󣬳�����������µ��������
            swap(str,begin,i);
        }
    }

    private void swap(char[] str, int begin, int i) {
        char temp = str[begin];
        str[begin] = str[i];
        str[i] = temp;
    }
    public static void main(String[] args) {
        Permutation a = new Permutation();
        System.out.println(a.Permutation("aab"));
    }

    /**
     * 2���ֵ��������㷨
     *
     * �ɲο������� http://www.cnblogs.com/pmars/archive/2013/12/04/3458289.html  ����л���ߣ�
     *
     * һ��ȫ���пɿ���һ���ַ������ַ�������ǰ׺����׺��
     * ���ɸ���ȫ���е���һ������.��νһ������һ��������һ������һ��֮��û�������ġ�
     * ���Ҫ����һ������һ���о����ܳ��Ĺ�ͬǰ׺��Ҳ���仯�����ھ����̵ܶĺ�׺�ϡ�
     *
     * [��]839647521��1--9�����С�1��9��������ǰ�����123456789��������987654321��
     * ��������ɨ�����������ģ��͵���987654321��Ҳ��û����һ���ˡ������ҳ���һ�γ����½���λ�á�
     *
     * ������ ��εõ�346987521����һ��
     * 1����β����ǰ�ҵ�һ��P(i-1) < P(i)��λ��
     * 3 4 6 <- 9 <- 8 <- 7 <- 5 <- 2 <- 1
     * �����ҵ�6�ǵ�һ����С�����֣���¼��6��λ��i-1
     *
     * 2����iλ�������ҵ����һ������6����
     * 3 4 6 -> 9 -> 8 -> 7 5 2 1
     * �����ҵ�7��λ�ã���¼λ��Ϊm
     *
     * 3������λ��i-1��m��ֵ
     * 3 4 7 9 8 6 5 2 1
     * 4������iλ�ú����������
     * 3 4 7 1 2 5 6 8 9
     * ��347125689Ϊ346987521����һ������
     *
     * @param str
     * @return
     */

    public ArrayList<String> Permutation2(String str){
        ArrayList<String> list = new ArrayList<String>();
        if(str==null || str.length()==0){
            return list;
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        list.add(String.valueOf(chars));
        int len = chars.length;
        while(true){
            int lIndex = len-1;
            int rIndex;
            while(lIndex>=1 && chars[lIndex-1]>=chars[lIndex]){
                lIndex--;
            }
            if(lIndex == 0)
                break;
            rIndex = lIndex;
            while(rIndex<len && chars[rIndex]>chars[lIndex-1]){
                rIndex++;
            }
            swap(chars,lIndex-1,rIndex-1);
            reverse(chars,lIndex);

            list.add(String.valueOf(chars));
        }

        return list;
    }

    private void reverse(char[] chars,int k){
        if(chars==null || chars.length<=k)
            return;
        int len = chars.length;
        for(int i=0;i<(len-k)/2;i++){
            int m = k+i;
            int n = len-1-i;
            if(m<=n){
                swap(chars,m,n);
            }
        }

    }
}

