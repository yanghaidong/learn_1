package jzOffer.chap5;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * ����һ�����������飬����������������ƴ�������ų�һ��������ӡ��ƴ�ӳ���������������С��һ����
 * ������������{3��32��321}�����ӡ���������������ųɵ���С����Ϊ321323
 */
public class PrintMinNumber {
    /**
     * * ����������£�
     *  * ��ab > ba �� a > b��
     *  * ��ab < ba �� a < b��
     *  * ��ab = ba �� a = b��
     *  * ����˵����
     *  * ���� "3" < "31"���� "331" > "313"������Ҫ������ƴ���������бȽ�
     * @param numbers
     * @return
     */
    public static String PrintMinNumber(int [] numbers) {
        if (numbers == null || numbers.length == 0){
            return "";
        }
        List<Integer> list = new ArrayList<>();
        for (int a : numbers){
            list.add(a);
        }
        //��listԪ�ذ����Զ���Ĺ��������С���������java8֮lambda���ʽ�������ǱȽ����Ӻ��Ԫ�ش�С
        list.sort((a, b)->(a+""+b).compareTo((b+""+a)));

        //����һ��д��
//        Collections.sort(list,new Comparator<Integer>(){
//
//            @Override
//            public int compare(Integer str1, Integer str2) {
//                // TODO Auto-generated method stub
//                String s1=str1+""+str2;f
//                String s2=str2+""+str1;
//
//                return s1.compareTo(s2);
//            }
//        });
        StringBuilder sb = new StringBuilder();
        for (int b : list){
            sb.append(b);
        }
        return sb.toString();

    }

    public static void main(String[] args) {
        int[] a = {3,32,321};
        System.out.println(PrintMinNumber(a));
    }
}
